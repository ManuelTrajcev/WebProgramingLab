package mk.ukim.finki.wp.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.wp.lab.model.Album;
import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Dataholder {
    public static List<Artist> artists = null;
    public static List<Song> songs = null;
    public static List<Album> albums = null;


    @PostConstruct
    public void init() {
        artists = new ArrayList<>();
        artists.add(new Artist(1L, "Freddie", "Mercury", "Lead vocalist of Queen, known for his powerful voice and flamboyant stage presence."));
        artists.add(new Artist(2L, "Elvis", "Presley", "The King of Rock and Roll, a cultural icon and legendary performer."));
        artists.add(new Artist(3L, "Whitney", "Houston", "American singer and actress, known for her powerful voice and numerous hits."));
        artists.add(new Artist(4L, "Michael", "Jackson", "The King of Pop, renowned for his unique style, dance moves, and iconic music."));
        artists.add(new Artist(5L, "Aretha", "Franklin", "The Queen of Soul, celebrated for her deep, emotive voice and powerful performances."));

        albums = new ArrayList<>();
        albums.add(new Album(1L, "The Dark Side of the Moon", "Progressive Rock", "1973"));
        albums.add(new Album(2L, "Abbey Road", "Rock", "1969"));
        albums.add(new Album(3L, "Thriller", "Pop", "1982"));
        albums.add(new Album(4L, "Back in Black", "Hard Rock", "1980"));
        albums.add(new Album(5L, "I Am... Sasha Fierce", "Pop", "2008"));
        songs = new ArrayList<>();

        songs.add(new Song("TRK001", "We Will Rock You", "Rock", 1977, List.of(artists.get(0), artists.get(1)), albums.get(0)));
        songs.add(new Song("TRK002", "Jailhouse Rock", "Rock and Roll", 1957, List.of(artists.get(1), artists.get(4)), albums.get(1)));
        songs.add(new Song("TRK003", "I Will Always Love You", "Pop", 1992, List.of(artists.get(2)),  albums.get(0)));
        songs.add(new Song("TRK004", "Thriller", "Pop", 1982, List.of(artists.get(3), artists.get(4), artists.get(1)), albums.get(2)));
        songs.add(new Song("TRK005", "Respect", "Soul", 1967, List.of(artists.get(4), artists.get(2)), albums.get(3)));

    }
}
