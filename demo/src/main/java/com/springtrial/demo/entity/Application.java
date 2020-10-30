package com.springtrial.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

/* @Entity is a JPA annotation to make this object ready for storage in a JPA-based data store.
 * @Id indicate a column as the primary key and automatically populated by the JPA provider.
 */
@Entity
public class Application {

    @Id
    @Column(name = "application_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long appId;

    @Column(name = "description")
    private String appDescription;

    @Column(name = "app_name")
    private String appName;

    @Column(name = "owner")
    private String appOwner;

    @ManyToMany(mappedBy = "applications",fetch = FetchType.LAZY,cascade = CascadeType.ALL) // *this applications is same as applications in Developer @ManyToMany
    @JsonIgnoreProperties({"applications","hibernateLazyInitializer","handler"}) // to solve serialization problem ie nested data
    private List<Developer> developers;


    public Application() {
    }

    public Application(String appDescription, String appName, String appOwner) {
        this.appDescription = appDescription;
        this.appName = appName;
        this.appOwner = appOwner;
    }

    public Long getAppId() {
        return appId;
    }

    public void setAppId(Long appId) {
        this.appId = appId;
    }

    public String getAppDescription() {
        return appDescription;
    }

    public void setAppDescription(String appDescription) {
        this.appDescription = appDescription;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppOwner() {
        return appOwner;
    }

    public void setAppOwner(String appOwner) {
        this.appOwner = appOwner;
    }

    public List<Developer> getDevelopers() {
        return developers;
    }

    public void setDevelopers(List<Developer> developers) {
        this.developers = developers;
    }
}
