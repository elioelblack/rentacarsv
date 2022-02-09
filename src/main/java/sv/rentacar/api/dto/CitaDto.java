package sv.rentacar.api.dto;

import java.util.Date;
import java.util.List;

public class CitaDto {
    private String _id;
    private List<String> tags;
    private String content;
    private String author;
    private String authorSlug;
    private Integer lenght;
    private Date dateAdded;
    private Date dateModified;

    public CitaDto() {
    }

    public CitaDto(String _id, List<String> tags, String content, String author, String authorSlug, Integer lenght, Date dateAdded, Date dateModified) {
        this._id = _id;
        this.tags = tags;
        this.content = content;
        this.author = author;
        this.authorSlug = authorSlug;
        this.lenght = lenght;
        this.dateAdded = dateAdded;
        this.dateModified = dateModified;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthorSlug() {
        return authorSlug;
    }

    public void setAuthorSlug(String authorSlug) {
        this.authorSlug = authorSlug;
    }

    public Integer getLenght() {
        return lenght;
    }

    public void setLenght(Integer lenght) {
        this.lenght = lenght;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    public Date getDateModified() {
        return dateModified;
    }

    public void setDateModified(Date dateModified) {
        this.dateModified = dateModified;
    }

    @Override
    public String toString() {
        return "CitaDto{" +
                "_id='" + _id + '\'' +
                ", tags=" + tags +
                '}';
    }
}
