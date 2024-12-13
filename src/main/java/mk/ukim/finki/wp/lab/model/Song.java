package mk.ukim.finki.wp.lab.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
public class Song {
    private String trackId;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String genre;
    private int releaseYear;
    @ManyToMany
    private List<Artist> performers = new ArrayList<>();
    @ManyToOne
    private Album album;
    private String price;

    public Song(String trackId, String title, String genre, int releaseYear, List<Artist> performers, Album album, String price) {
        this.trackId = trackId;
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.performers = performers;
        this.album = album;
        this.price = price;
    }

    public void addArtist(Artist artist) {
        performers.add(artist);
    }
}
