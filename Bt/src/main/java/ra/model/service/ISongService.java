package ra.model.service;

import ra.model.dto.SongDto;
import ra.model.entity.Song;

import java.util.List;

public interface ISongService {
    List<Song> findAll();
    Song findById(Long id);
    void save(SongDto songdto);
    void delete(Long id);
}