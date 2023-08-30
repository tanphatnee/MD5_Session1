package ra.model.entity;

import javax.persistence.*;
@Entity
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String singer;
    private String genre;
    private String url;

    public Song() {
    }

    public Song(Long id, String name, String singer, String genre, String url) {
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    public void copy(Song copySong) {
        this.id = copySong.getId();
        this.name = copySong.getName();
        this.singer = copySong.getSinger();
        this.genre = copySong.getGenre();
        this.url = copySong.getUrl();
    }
}