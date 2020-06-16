package com.springtrial.demo.service;

import com.springtrial.demo.entity.Application;
import com.springtrial.demo.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// First we make service implementation , then create the service interface
// Right click , refactor , extract interface
// Class implements interface

@Service
public class ApplicationServiceImpl implements ApplicationService {

    // Wiring ApplicationRepository with Service
    @Autowired
    ApplicationRepository applicationRepository;

    @Override
    public List<Application> getApplications(){
        // casting iterable output to List<Application>
        return (List<Application>) applicationRepository.findAll();
    }

}
