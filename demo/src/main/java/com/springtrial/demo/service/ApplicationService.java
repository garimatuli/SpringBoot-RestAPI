package com.springtrial.demo.service;

import com.springtrial.demo.entity.Application;

import java.util.List;
import java.util.Optional;

public interface ApplicationService {
    List<Application> getApplications();
    Optional<Application> getApplicationById(Long id);
}

// https://www.javaguides.net/2019/07/spring-boot-save-findbyid-findall.html

// https://docs.spring.io/spring-data/jpa/docs/current/api/org/springframework/data/jpa/repository/JpaRepository.html

