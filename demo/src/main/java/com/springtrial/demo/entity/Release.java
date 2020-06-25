package com.springtrial.demo.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Release {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long releaseId;

    @Column(name = "description")
    private String releaseDescription;

    @Column(name = "release_date")
    private Date releaseDate;


    public Release() {
    }

    public Release(Long releaseId, String releaseDescription, Date releaseDate) {
        this.releaseId = releaseId;
        this.releaseDescription = releaseDescription;
        this.releaseDate = releaseDate;
    }

    public Long getReleaseId() {
        return releaseId;
    }

    public void setReleaseId(Long releaseId) {
        this.releaseId = releaseId;
    }

    public String getReleaseDescription() {
        return releaseDescription;
    }

    public void setReleaseDescription(String releaseDescription) {
        this.releaseDescription = releaseDescription;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }





}
