package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.bootstrap.Dataholder;
import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class InMemorySongRepository {
    public List<Song> findAll() {
        return Dataholder.songs;
    }

    public Optional<Song> findByTrackId(String trackId) {
        return Dataholder.songs
                .stream()
                .filter(s -> s.getTrackId().equals(trackId))
                .findFirst();
    }

    public Artist addArtistToSong(Artist artist, Song song) {
        Optional<Song> optionalSong = Dataholder.songs
                .stream()
                .filter(s -> s.equals(song))
                .findFirst();

        if (optionalSong.isPresent()) {
            Song foundSong = optionalSong.get();
            if (foundSong.getPerformers().contains(artist)) {
                return artist;
            }
            List<Artist> mutablePerformers = new ArrayList<>(foundSong.getPerformers());
            mutablePerformers.add(artist);
            foundSong.setPerformers(mutablePerformers);
            return artist;
        } else {
            throw new IllegalArgumentException("Song not found");
        }

    }

    public Optional<Song> findById(Long id) {
        return Dataholder.songs
                .stream()
                .filter(i -> i.getId().equals(id))
                .findFirst();
    }
}
