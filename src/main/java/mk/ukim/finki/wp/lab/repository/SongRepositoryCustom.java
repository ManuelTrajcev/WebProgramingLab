package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;

public interface SongRepositoryCustom {
    Artist addArtistToSong(Artist artist, Song song);
}
