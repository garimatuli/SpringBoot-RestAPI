package com.springtrial.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name="developers")
public class Developer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long developerId;
    private String developerName;

    @ManyToMany
    @JsonIgnoreProperties({"developers","hibernateLazyInitializer","handler"}) // to solve serialization problem ie nested data
    @JoinTable(
            name = "developer_applications",
            joinColumns = @JoinColumn(name = "developerId"),
            inverseJoinColumns = @JoinColumn(name = "application_id")
    )
    private List<Application> applications; // *this applications is same as applications in Application @ManyToMany

    public Long getDeveloperId() {
        return developerId;
    }

    public void setDeveloperId(Long developerId) {
        this.developerId = developerId;
    }

    public String getDeveloperName() {
        return developerName;
    }

    public void setDeveloperName(String developerName) {
        this.developerName = developerName;
    }

    public List<Application> getApplications() {
        return applications;
    }

    public void setApplications(List<Application> applications) {
        this.applications = applications;
    }



}
