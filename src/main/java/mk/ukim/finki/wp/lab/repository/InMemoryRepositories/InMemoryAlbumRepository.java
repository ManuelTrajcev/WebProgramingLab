package mk.ukim.finki.wp.lab.repository.InMemoryRepositories;

import mk.ukim.finki.wp.lab.bootstrap.Dataholder;
import mk.ukim.finki.wp.lab.model.Album;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InMemoryAlbumRepository {
    public List<Album> findAll() {
        return Dataholder.albums;
    }
}
