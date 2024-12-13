package mk.ukim.finki.wp.lab.bootstrap;


import jakarta.annotation.PostConstruct;
import mk.ukim.finki.wp.lab.model.Album;
import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Price;
import mk.ukim.finki.wp.lab.model.Song;
import mk.ukim.finki.wp.lab.repository.AlbumRepository;
import mk.ukim.finki.wp.lab.repository.ArtistRepository;
import mk.ukim.finki.wp.lab.repository.SongRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Dataholder {
    public static List<Artist> artists = null;
    public static List<Song> songs = null;
    public static List<Album> albums = null;

    private final ArtistRepository artistRepository;
    private final SongRepository songRepository;
    private final AlbumRepository albumRepository;

    public Dataholder(ArtistRepository artistRepository, SongRepository songRepository, AlbumRepository albumRepository) {
        this.artistRepository = artistRepository;
        this.songRepository = songRepository;
        this.albumRepository = albumRepository;



    }

    @PostConstruct
    public void init() {
        this.songRepository.deleteAll();
        this.artistRepository.deleteAll();
        this.albumRepository.deleteAll();

        artists = new ArrayList<>();
        artists.add(new Artist("Freddie", "Mercury", "Lead vocalist of Queen, known for his powerful voice and flamboyant stage presence."));
        artists.add(new Artist("Elvis", "Presley", "The King of Rock and Roll, a cultural icon and legendary performer."));
        artists.add(new Artist("Whitney", "Houston", "American singer and actress, known for her powerful voice and numerous hits."));
        artists.add(new Artist("Michael", "Jackson", "The King of Pop, renowned for his unique style, dance moves, and iconic music."));
        artists.add(new Artist("Aretha", "Franklin", "The Queen of Soul, celebrated for her deep, emotive voice and powerful performances."));
        this.artistRepository.saveAll(artists);

        albums = new ArrayList<>();
        albums.add(new Album("The Dark Side of the Moon", "Progressive Rock", "1973", new ArrayList<>()));
        albums.add(new Album("Abbey Road", "Rock", "1969", new ArrayList<>()));
        albums.add(new Album("Thriller", "Pop", "1982", new ArrayList<>()));
        albums.add(new Album("Back in Black", "Hard Rock", "1980", new ArrayList<>()));
        albums.add(new Album("I Am... Sasha Fierce", "Pop", "2008", new ArrayList<>()));
        this.albumRepository.saveAll(albums);

        songs = new ArrayList<>();
        Song song1 = new Song("TRK001", "We Will Rock You", "Rock", 1977, List.of(artists.get(0), artists.get(1)), albums.get(0), "100$");
        Song song2 = new Song("TRK002", "Jailhouse Rock", "Rock and Roll", 1957, List.of(artists.get(1), artists.get(4)), albums.get(1), "100$");
        Song song3 = new Song("TRK003", "I Will Always Love You", "Pop", 1992, List.of(artists.get(2)), albums.get(0), "100$");
        Song song4 = new Song("TRK004", "Thriller", "Pop", 1982, List.of(artists.get(3), artists.get(4), artists.get(1)), albums.get(2), "100$");
        Song song5 = new Song("TRK005", "Respect", "Soul", 1967, List.of(artists.get(4), artists.get(2)), albums.get(3), "100$");

        songs.add(song1);
        songs.add(song2);
        songs.add(song3);
        songs.add(song4);
        songs.add(song5);
        songs
                .forEach(s -> System.out.println(s.getId()));
        this.songRepository.saveAll(songs);

        albums.get(0).getSongs().add(song1);
        albums.get(0).getSongs().add(song3);
        albums.get(1).getSongs().add(song2);
        albums.get(2).getSongs().add(song4);
        albums.get(3).getSongs().add(song5);

    }
}
