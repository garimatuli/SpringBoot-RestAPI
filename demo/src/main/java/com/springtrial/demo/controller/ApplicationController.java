package com.springtrial.demo.controller;
import com.springtrial.demo.entity.Application;
import com.springtrial.demo.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController

@RequestMapping("/garima")
public class ApplicationController {

    @Autowired
    ApplicationService applicationService;

    @GetMapping("/getApplications")
    public ResponseEntity<List<Application>> getApplications() {
        List<Application> applications = applicationService.getApplications();
        return new ResponseEntity<List<Application>>(applications, HttpStatus.OK);
    }

//    @GetMapping("/applications")
//    public @ResponseBody List<Application> getApplications() {
//        List<Application> applications = applicationService.getApplications();
//        return applications ;
//    }

    @GetMapping("/getApplicationById/{appId}")
    @ResponseBody
    public Optional<Application> getApplicationById(@PathVariable Long appId) {
        Optional<Application> application = applicationService.getApplicationById(appId);
        return application;
    }

    @PostMapping(value = "/addApplications",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.CREATED, value = HttpStatus.CREATED, reason = "Successfully added applications")
    public void postApplication(@Validated @RequestBody List<Application> applications){
        applicationService.postApplications(applications);
    }

    @PutMapping("/updateApplicationById/{id}")
    public ResponseEntity<String> updateApplication(@PathVariable(name = "id") Long appId, @Validated @RequestBody Application appObj){
        boolean check = applicationService.updateApplication(appId,appObj);
        if (check)
            return new ResponseEntity<String>("{\"Msg\": \"Record Successfully updated\"}",HttpStatus.OK);
        else
            return new ResponseEntity<String>("{\"Msg\":\"No such record found\"}",HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/deleteApplicationById/{id}")
    public ResponseEntity<String> deleteApplication(@PathVariable(name = "id") Long appId){
        boolean check = applicationService.deleteApplication(appId);
        if (check)
            return new ResponseEntity<>("{\"Msg\":\"Successfully Deleted Record\"}",HttpStatus.OK);
        else
            return new ResponseEntity<>("{\"Msg\":\"Record not found\"}",HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/deleteAppByName/{appName}")
    @ResponseStatus(code = HttpStatus.OK)
    public @ResponseBody String deleteApplicationByName(@PathVariable(name = "appName") String appName){
        applicationService.deleteApplicationsByName(appName);
        return "Record Deleted Successfully";
    }
}

/*
@RequestMapping(path="/{name}/{age}")
public String getMessage(@PathVariable("name") String name, @PathVariable("age") String age) {

With the @PathVariable annotation, we bind the request URL template path variable to the method variable.
For instance, with the /July/28/ URL, the July value is bind to the name variable, and 28 value to the age variable.
 */

// Comments

/* The @RestController annotation is used to simplify the creation of RESTful web services.
 * It's a convenience annotation that combines @Controller and @ResponseBody.
 * It eliminates the need to annotate every request handling method of the controller class with the @ResponseBody annotation.
 * @RestController indicates that the data returned by each method will be written straight into the response body
 * instead of rendering a template.
 */

/* url structure - path will start with /garima
 * @RequestMapping is used to map web requests to Spring Controller methods.
 * Annotation for mapping web requests onto methods in request-handling classes with flexible method signatures.
 */


/* @Autowired provides a new style of Dependency Injection.
 * This annotation allows Spring to resolve and inject collaborating beans into your bean.
 * Once annotation injection is enabled, autowiring can be used on properties, setters, and constructors.
 * no need to use 'this' keyword
 * It helps auto wiring of ApplicationService with ApplicationController
 */

// using @ResponseBody we can only return the body of response but not status, for returning status as well, we need ResponseEntity

/* ResponseEntity is a class, it represents an HTTP response, including headers, body, and status.
       While @ResponseBody puts the return value into the body of the response,
       ResponseEntity also allows us to add headers and status code. */

/* Attaching path to function
 * @GetMapping is used To make endpoint compatible for get request.
 * @GetMapping is a composed annotation that acts as a shortcut for @RequestMapping(method = RequestMethod.GET)
 * Annotation for mapping HTTP GET requests onto specific handler methods.
 */

/* @ResponseBody: To Generate the response message.
 * using @ResponseBody we can only return the body of response but not status, for that we need ResponseEntity
 */

/* @PathVariable annotation reads an URL template variable and maps it to method Variable
 * You can write @PathVariable("appId") Long appId - this is the best practice
 * Here just @PathVariable("appId") Long appId is also ok as there is only single variable in url so no naming confusion
 */
