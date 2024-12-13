package mk.ukim.finki.wp.lab.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@Repository
public class SongRepositoryImpl implements SongRepositoryCustom{
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public Artist addArtistToSong(Artist artist, Song song) {
        song.addArtist(artist);
        entityManager.merge(song);
        return artist;
    }
}
