package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;

import java.util.List;
import java.util.Optional;

public interface SongService {
    List<Song> listSongs();

    Artist addArtistToSong(Artist artist, Song song);

    Song findByTrackId(String trackId);

    Optional<Song> findById(Long id);

    void deleteSong(Song song);

    void saveSong(Song newSong);

    List<Song> filterSongs(String name, String genre, Long albumId);
}
