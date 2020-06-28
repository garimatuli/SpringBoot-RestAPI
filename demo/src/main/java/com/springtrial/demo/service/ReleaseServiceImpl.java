package com.springtrial.demo.service;

import com.springtrial.demo.entity.Release;
import com.springtrial.demo.repository.ReleaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ReleaseServiceImpl implements ReleaseService {

    @Autowired
    ReleaseRepository releaseRepository;

    @Override
    public List<Release> getReleases() {
        return (List<Release>) releaseRepository.findAll();
    }

    @Override
    public Optional<Release> getReleaseById(Long releaseId){
        return releaseRepository.findById(releaseId);
    }

    @Override
    public void saveRelease(List<Release> releases) {
         releaseRepository.saveAll(releases);
    }

    @Override
    public boolean updateReleaseById(Long releaseId, Release releaseObj){
        Optional<Release> release = releaseRepository.findById(releaseId);
        if (release.isPresent()){
            Release tobeUpdatedRelease = release.get();
            tobeUpdatedRelease.setReleaseDescription(releaseObj.getReleaseDescription());
            tobeUpdatedRelease.setReleaseDate(releaseObj.getReleaseDate());
            releaseRepository.save(tobeUpdatedRelease);
            return true;
        }
        return false;
    }

    @Override
    public void deleteAllReleases(){
        releaseRepository.deleteAll();
    }

    @Override
    public void deleteSomeReleases(List<Release> releases){
        releaseRepository.deleteAll(releases);
    }

}
