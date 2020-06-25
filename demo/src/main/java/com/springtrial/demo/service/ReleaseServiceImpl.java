package com.springtrial.demo.service;

import com.springtrial.demo.entity.Release;
import com.springtrial.demo.repository.ReleaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReleaseServiceImpl implements ReleaseService {

    @Autowired
    ReleaseRepository releaseRepository;

    @Override
    public List<Release> getReleases() {
        return (List<Release>) releaseRepository.findAll();
    }
}
