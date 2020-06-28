package com.springtrial.demo.service;
import com.springtrial.demo.entity.Application;
import com.springtrial.demo.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

/* First we make service implementation , then create the service interface
 * Right click , refactor , extract interface
 * Class implements interface
 */

//  Spring Service annotation can be applied only to classes. It is used to mark the class as a service provider.
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

    @Override
    public Optional<Application> getApplicationById(Long id)
    {
        // The findById() method is used to retrieves an entity by its id and it is available in CrudRepository interface.
        return applicationRepository.findById(id);
    }

    @Override
    public String postApplications(List<Application> applications){
        for (Application application: applications) {
            // checking if any app name already exists in database, if it does then don't insert any record
            Application existingApp = applicationRepository.checkAppName(application.getAppName());
            if (existingApp != null)
                return "App NAme already Exists";
        }
        applicationRepository.saveAll(applications);
        return "Records successfully added";
    }

    @Override
    public boolean updateApplication(Long appId, Application appObj){
        Optional<Application> OptionalApp = applicationRepository.findById(appId);
        boolean check = OptionalApp.isPresent();
        if (check){
            Application foundApplication = OptionalApp.get();
            foundApplication.setAppName(appObj.getAppName());
            foundApplication.setAppDescription(appObj.getAppDescription());
            foundApplication.setAppOwner(appObj.getAppOwner());
            applicationRepository.save(foundApplication);
        }
        return  check;
    }

    @Override
    public boolean deleteApplication(Long appId){
        Optional<Application> application = applicationRepository.findById(appId);
        boolean check = application.isPresent(); // as application above might be null or have an application if id exists
        if (check){
            // extracting application object from optional wrapper
            Application foundApplication = application.get();
            applicationRepository.delete(foundApplication);
        }
        return check;
    }

    @Override
    public void deleteApplicationsByName(String appName){
        applicationRepository.deleteAppsByName(appName);
    }
}

/* The @Override annotation indicates that the child class method is over-writing its base class method.
 * Also used here to implement method defined in the interface.
 * The @Override annotation can be useful for two reasons.
 * It extracts a warning from the compiler if the annotated method doesn't actually override anything.
 * It can improve the readability of the source code.
 */

/* Spring Data JPA is a library/framework that adds an extra layer of abstraction on the top of our JPA provider (like Hibernate).
 * JpaRepository is JPA specific extension of Repository. It contains the full API of CrudRepository and PagingAndSortingRepository.
 * So it contains API for basic CRUD operations and also API for pagination and sorting.
 *
 * It provides us methods like save(), findById(), findAll(), and deleteById().
 */
