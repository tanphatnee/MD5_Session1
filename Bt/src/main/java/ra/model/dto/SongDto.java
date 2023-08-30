package ra.model.dto;

import org.springframework.web.multipart.MultipartFile;

public class SongDto {
    private Long id;
    private String name;
    private String singer;
    private String genre;
    private MultipartFile url;

    public SongDto() {
    }

    public SongDto(Long id, String name, String singer, String genre, MultipartFile url) {
        this.id = id;
        this.name = name;
        this.singer = singer;
        this.genre = genre;
        this.url = url;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public MultipartFile getUrl() {
        return url;
    }

    public void setUrl(MultipartFile url) {
        this.url = url;
    }
}