package ra.model.service;

import ra.model.dto.SongDto;
import ra.model.entity.Song;
import ra.model.repository.ISongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class SongService implements ISongService {
    @Autowired
    private ISongRepository songRepository;
    @Override
    public List<Song> findAll() {

        return songRepository.findAll();
    }

    @Override
    public Song findById(Long id) {

        return songRepository.findById(id);
    }

    @Override
    public void save(SongDto songDto) {
        String uploadPath = "C:\\Users\\nvtph\\OneDrive\\Máy tính\\MD5\\SS1\\Bt\\src\\main\\webapp\\upload\\";
        // xử lí chuyển đổi
        // upload file
        String filename = null;
        if(!(songDto.getUrl().isEmpty())){
            filename = songDto.getUrl().getOriginalFilename();
            try {
                FileCopyUtils.copy(songDto.getUrl().getBytes(),new File(uploadPath+filename));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        // chuyển từ dto thành entity
        Song song = new Song(songDto.getId(),
                songDto.getName(),songDto.getSinger(),
                songDto.getGenre(), filename);
        songRepository.save(song);
    }

    @Override
    public void delete(Long id) {
        songRepository.delete(id);
    }
}