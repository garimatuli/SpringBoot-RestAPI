package com.springtrial.demo.entity;

import javax.persistence.*;

@Entity
public class Application {

    @Id
    @Column(name = "application_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long appId;

    @Column(name = "description")
    private String appDescription;

    @Column(name = "app_name")
    private String appName;

    @Column(name = "owner")
    private String appOwner;

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

}
