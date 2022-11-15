package com.irubio.researchManagement.Model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;

@Entity
public class Paper {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String[] authors;
    private String title;
    private int year;
    private String source;

    private LocalDate addedDate;
    private String[] tags;

    private String paperCode;

    public Paper() {
    }

    public Paper(String[] authors, String title, int year, String source, LocalDate addedDate, String[] tags) {
        this.authors = authors;
        this.title = title;
        this.year = year;
        this.source = source;
        this.addedDate = addedDate;
        this.tags = tags;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String[] getAuthors() {
        return authors;
    }

    public void setAuthors(String[] authors) {
        this.authors = authors;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public LocalDate getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(LocalDate addedDate) {
        this.addedDate = java.time.LocalDate.now();
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public String getPaperCode() {
        return paperCode;
    }

    public void setPaperCode(String paperCode) {
        this.paperCode = paperCode;
    }

    @Override
    public String toString() {
        return "Paper{" +
                "id=" + id +
                ", authors=" + Arrays.toString(authors) +
                ", title='" + title + '\'' +
                ", year=" + year +
                ", source='" + source + '\'' +
                ", addedDate=" + addedDate +
                ", tags=" + Arrays.toString(tags) +
                ", paperCode='" + paperCode + '\'' +
                '}';
    }
}
