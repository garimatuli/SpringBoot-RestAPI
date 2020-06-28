package com.springtrial.demo.service;
import com.springtrial.demo.entity.Application;
import java.util.List;
import java.util.Optional;

public interface ApplicationService {
    List<Application> getApplications();
    Optional<Application> getApplicationById(Long id);
    String postApplications(List<Application> applications);
    boolean updateApplication(Long appId,Application appObj);
    boolean deleteApplication(Long appId);
    void deleteApplicationsByName(String appName); //Delete application by application name
}

// https://www.javaguides.net/2019/07/spring-boot-save-findbyid-findall.html

// https://docs.spring.io/spring-data/jpa/docs/current/api/org/springframework/data/jpa/repository/JpaRepository.html

/* Optional<T> is a container object which may or may not contain a non-null value.
 * If a value is present, isPresent() returns true and get() returns the value.
 * The ifPresent() invokes the specified method if the value is present; otherwise nothing is done.
 * It saves us from nul pointer exception in case there is no such id present in the database.
 */
