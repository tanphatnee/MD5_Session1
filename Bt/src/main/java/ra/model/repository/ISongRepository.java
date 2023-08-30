package ra.model.repository;

import ra.model.entity.Song;

import java.util.List;

public interface ISongRepository {
    List<Song> findAll();
    Song findById(Long id);
    void save(Song song);
    void delete(Long id);
}