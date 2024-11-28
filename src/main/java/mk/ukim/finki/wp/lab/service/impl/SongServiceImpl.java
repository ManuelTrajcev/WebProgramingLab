package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;
import mk.ukim.finki.wp.lab.repository.InMemoryArtistRepository;
import mk.ukim.finki.wp.lab.repository.InMemorySongRepository;
import mk.ukim.finki.wp.lab.service.SongService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SongServiceImpl implements SongService {
    private final InMemorySongRepository songRepository;
    private final InMemoryArtistRepository artistRepository;

    public SongServiceImpl(InMemorySongRepository songRepository, InMemoryArtistRepository artistRepository) {
        this.songRepository = songRepository;
        this.artistRepository = artistRepository;
    }

    @Override
    public List<Song> listSongs() {
        return songRepository.findAll();
    }

    @Override
    public Artist addArtistToSong(Artist artist, Song song) {
        return songRepository.addArtistToSong(artist, song);
    }

    @Override
    public Song findByTrackId(String trackId) {
        return songRepository.findByTrackId(trackId).orElseThrow();
    }

    @Override
    public Optional<Song> findById(Long id) {
        return songRepository.findById(id);
    }
}
