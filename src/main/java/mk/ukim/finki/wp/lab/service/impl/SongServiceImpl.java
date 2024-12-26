package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;
import mk.ukim.finki.wp.lab.repository.*;
import mk.ukim.finki.wp.lab.service.SongService;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static mk.ukim.finki.wp.lab.service.specifications.FieldFilterSpecification.filterContainsText;
import static mk.ukim.finki.wp.lab.service.specifications.FieldFilterSpecification.filterEquals;

@Service
public class SongServiceImpl implements SongService {
    private final SongRepository songRepository;
    private final ArtistRepository artistRepository;
    private final SongRepositoryImpl songRepositoryCustom;

    public SongServiceImpl(SongRepository songRepository, ArtistRepository artistRepository, SongRepositoryImpl songRepositoryCustom) {
        this.songRepository = songRepository;
        this.artistRepository = artistRepository;
        this.songRepositoryCustom = songRepositoryCustom;
    }

    @Override
    public List<Song> listSongs() {
        return songRepository.findAll();
    }

    @Override
    public Artist addArtistToSong(Artist artist, Song song) {
        return songRepositoryCustom.addArtistToSong(artist, song);
    }

    @Override
    public Song findByTrackId(String trackId) {
        return (Song) songRepository.findByTrackId(trackId).orElseThrow();
    }

    @Override
    public Optional<Song> findById(Long id) {
        return songRepository.findById(id);
    }

    @Override
    public void deleteSong(Song song) {
        this.songRepository.deleteById(song.getId());
    }

    @Override
    public void saveSong(Song newSong) {
        this.songRepository.save(newSong);
    }

    @Override
    public List<Song> filterSongs(String name, String genre, Long albumId) {
        Specification<Song> specification = Specification
                .where(filterContainsText(Song.class, "title", name))
                .and(filterEquals(Song.class, "genre", genre))
                .and(filterEquals(Song.class, "album.id", albumId));


        return this.songRepository.findAll(specification);
    }


}
