package mk.ukim.finki.wp.lab.repository.InMemoryRepositories;

import mk.ukim.finki.wp.lab.bootstrap.Dataholder;
import mk.ukim.finki.wp.lab.model.Artist;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class InMemoryArtistRepository {
    public List<Artist> findAll() {
        return Dataholder.artists;
    }

    public Optional<Artist> findById(Long id) {
        return Dataholder.artists
                .stream()
                .filter(a -> a.getId().equals(id))
                .findFirst();
    }
}
