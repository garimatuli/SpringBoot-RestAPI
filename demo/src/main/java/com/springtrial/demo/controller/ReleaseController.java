package com.springtrial.demo.controller;

import com.springtrial.demo.entity.Release;
import com.springtrial.demo.service.ReleaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

@RequestMapping("/garima")
public class ReleaseController {

    @Autowired
    ReleaseService releaseService;

    @GetMapping("/releases")
    @ResponseBody
    public List<Release> getReleases() {
        List<Release> releases = releaseService.getReleases();
        return releases;
    }
}
