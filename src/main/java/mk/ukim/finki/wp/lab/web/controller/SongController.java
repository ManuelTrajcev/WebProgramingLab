package mk.ukim.finki.wp.lab.web.controller;


import mk.ukim.finki.wp.lab.model.Album;
import mk.ukim.finki.wp.lab.model.Price;
import mk.ukim.finki.wp.lab.model.Song;
import mk.ukim.finki.wp.lab.service.AlbumService;
import mk.ukim.finki.wp.lab.service.SongService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping({"/songs", "/"})
public class SongController {
    private final SongService songService;
    private final AlbumService albumService;

    public SongController(SongService songService, AlbumService albumService) {
        this.songService = songService;
        this.albumService = albumService;
    }

    @GetMapping
    public String getSongsPage(
            @RequestParam(required = false) String error,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String genre,
            @RequestParam(required = false) Long albumSelectionId,
            Model model) {

        System.out.println(name);
        System.out.println(genre);
        System.out.println(albumSelectionId);


        List<Song> filteredSongs = songService.filterSongs(name, genre, albumSelectionId);
        model.addAttribute("songs", filteredSongs);
        model.addAttribute("albums", albumService.findAll());
        return "listSongs";
    }

    @GetMapping("/access_denied")
    public String getAccessDeniedPage(Model model) {
        model.addAttribute("bodyContent", "access-denied");
        return "access-denied";
    }


    @PostMapping("/add")
    public String saveSong(
            @RequestParam("title") String title,
            @RequestParam("trackId") String trackId,
            @RequestParam("genre") String genre,
            @RequestParam("releaseYear") int releaseYear,
            @RequestParam("albumId") Long albumId,
            Model model) {
        Optional<Album> album = albumService.findById(albumId);
        Album a = null;
        if (album.isPresent()) {
            a = album.get();
        }
        Song newSong = new Song(trackId, title, genre, releaseYear, List.of(), a, "100 $");
        songService.saveSong(newSong);

        return "redirect:/songs";
    }

//    @PostMapping("/edit/{songId}")
//    public String editSong(@PathVariable Long songId) {
//
//    }

    @PostMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteSong(@PathVariable Long id) {
        Optional<Song> s = songService.findById(id);
        Song song = null;
        if (s.isPresent()) {
            song = s.get();
        }
        songService.deleteSong(song);
        return "redirect:/songs";
    }

    @PostMapping("/select/{id}")
    public String selectSong(@PathVariable Long id) {
        Optional<Song> s = songService.findById(id);
        Song song = null;
        if (s.isPresent()) {
            song = s.get();
        }

        return "redirect:/artist?trackId=" + song.getTrackId();
    }

    @GetMapping("/edit-form/{id}")
    @PreAuthorize("isAuthenticated()")
    public String getEditSongForm(
            @PathVariable Long id,
            Model model, RedirectAttributes redirectAttributes) {
        model.addAttribute("songs", songService.listSongs());
        model.addAttribute("albums", albumService.findAll());
        Optional<Song> s = songService.findById(id);
        Song song = null;
        if (s.isPresent()) {
            song = s.get();
        } else {
            redirectAttributes.addFlashAttribute("error", "Song with ID " + id + " not found!");
            return "redirect:/songs";
        }


        return "redirect:/songs/add-form?id=" + id;
    }


    @GetMapping("/add-form")
    @PreAuthorize("isAuthenticated()")
    public String getAddSongPage(@RequestParam(required = false) Long id, Model model) {
        Song song = null;

        if (id != null) {
            Optional<Song> optionalSong = songService.findById(id);
            if (optionalSong.isPresent()) {
                song = optionalSong.get();
            }
        }

        model.addAttribute("song", song);
        model.addAttribute("albums", albumService.findAll());
        return "add-song";
    }

    @PostMapping("/add-form")
    @PreAuthorize("hasRole('ADMIN')")
    public String addSongForm(@RequestParam(required = false) Long id,
                              @RequestParam("title") String title,
                              @RequestParam("trackId") String trackId,
                              @RequestParam("genre") String genre,
                              @RequestParam("releaseYear") int releaseYear,
                              @RequestParam("albumId") Long albumId,
                              @RequestParam("price") String price,
                              Model model) {
        Optional<Album> album = albumService.findById(albumId);
        Album a = album.orElse(null);

        if (id != null && songService.findById(id).isPresent()) {
            Song oldSong = songService.findById(id).get();
            oldSong.setTitle(title);
            oldSong.setTrackId(trackId);
            oldSong.setGenre(genre);
            oldSong.setReleaseYear(releaseYear);
            oldSong.setAlbum(a);
            songService.saveSong(oldSong);
        } else {
            Song newSong = new Song(trackId, title, genre, releaseYear, List.of(), a, price);
            songService.saveSong(newSong);
        }

        return "redirect:/songs";
    }

    @GetMapping("/songDetails/{trackId}")
    public String getSongDetails(@PathVariable("trackId") String trackId, Model model) {
        Song song = songService.findByTrackId(trackId);
        model.addAttribute("song", song);

        return "songDetails";
    }

    @GetMapping("/listSongs/{trackId}")
    public String listSongs(@PathVariable("trackId") String selectedSongId, Model model) {
        Song song = songService.findByTrackId(selectedSongId);

        return "redirect:/artist/" + song.getTrackId();
    }

}
