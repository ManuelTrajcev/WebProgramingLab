package mk.ukim.finki.wp.lab.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Album {
    private Long id;
    private String name;
    private String genre;
    private String releaseYear;
}
