package com.springtrial.demo.service;

import com.springtrial.demo.entity.Release;

import java.util.List;
import java.util.Optional;

public interface ReleaseService {
     List<Release> getReleases();
     Optional<Release> getReleaseById(Long releaseId);
     void saveRelease(List<Release> releases);
     boolean updateReleaseById(Long releaseId, Release releaseObj);
     void deleteAllReleases(); // delete all releases
     void deleteSomeReleases(List<Release> releases); // delete releases passed as request data in the request body
}

// findAll() will return a list of releases

// Optional<Release> as findById() takes an Id to find and always return an Optional<Release>
// ie may be find that id , may be not but it will not throw null pointer exception

// inserting/saving list of releases using saveAll()
// saveAll() is not returning anything so void

// it takes id to pass in findById() and check if that id is present
// if present, details from request body is set/updated in to the object got from database by findById()
// updated object is saved to database using save() - does'nt return anything
// returning boolean here just to check if release.isPresent() which returns a boolean
// above is required as findById() always return an Optional<Release> instead of just the found Release
