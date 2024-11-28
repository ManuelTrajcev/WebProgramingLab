package mk.ukim.finki.wp.lab.web.controller;

import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;
import mk.ukim.finki.wp.lab.service.ArtistService;
import mk.ukim.finki.wp.lab.service.SongService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/artist")
public class ArtistController {

    private final ArtistService artistService;
    private final SongService songService;

    public ArtistController(ArtistService artistService, SongService songService) {
        this.artistService = artistService;
        this.songService = songService;
    }

    @GetMapping("/{trackId}")
    public String getArtist(@PathVariable String trackId, Model model) {
        Song song = songService.findByTrackId(trackId);

        model.addAttribute("song", song);
        model.addAttribute("artists", artistService.listArtists());

        return "artistsList";
    }

    @PostMapping("/addArtist")
    public String addArtist(@RequestParam Long artistId, @RequestParam String trackId) {
        Artist artist = artistService.ArtistfindById(artistId);
        Song song = songService.findByTrackId(trackId);

        if (artist != null && song != null) {
            songService.addArtistToSong(artist, song);
        }

        return "redirect:/songDetails?trackId=" + trackId + "&artistId=" + artistId;
    }
}
