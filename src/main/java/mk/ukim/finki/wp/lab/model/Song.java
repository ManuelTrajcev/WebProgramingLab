package mk.ukim.finki.wp.lab.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.List;

@Data
public class Song {
    private String trackId;
    private Long id = (long) (Math.random()*1000);
    private String title;
    private String genre;
    private int releaseYear;
    private List<Artist> performers;
    private Album album;
    private Price price;

    public Song(String trackId, String title, String genre, int releaseYear, List<Artist> performers, Album album, Price price) {
        this.trackId = trackId;
        this.id = (long) (Math.random()*1000);
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.performers = performers;
        this.album = album;
        this.price = price;
    }
}
