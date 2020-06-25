package com.springtrial.demo.controller;

import com.springtrial.demo.entity.Application;
import com.springtrial.demo.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/* The @RestController annotation is used to simplify the creation of RESTful web services.
 * It's a convenience annotation that combines @Controller and @ResponseBody.
 * It eliminates the need to annotate every request handling method of the controller class with the @ResponseBody annotation.
 * @RestController indicates that the data returned by each method will be written straight into the response body
 * instead of rendering a template.
 */
@RestController

/* url structure - path will start with /garima
 * @RequestMapping is used to map web requests to Spring Controller methods.
 * Annotation for mapping web requests onto methods in request-handling classes with flexible method signatures.
 */
@RequestMapping("/garima")

public class ApplicationController {

    /* @Autowired provides a new style of Dependency Injection.
     * This annotation allows Spring to resolve and inject collaborating beans into your bean.
     * Once annotation injection is enabled, autowiring can be used on properties, setters, and constructors.
     * no need to use 'this' keyword
     * It helps auto wiring of ApplicationService with ApplicationController
     */
    @Autowired
    ApplicationService applicationService;

    /* ResponseEntity is a class, it represents an HTTP response, including headers, body, and status.
       While @ResponseBody puts the return value into the body of the response,
       ResponseEntity also allows us to add headers and status code. */

    /* Attaching path to function
     * @GetMapping is used To make endpoint compatible for get request.
     * @GetMapping is a composed annotation that acts as a shortcut for @RequestMapping(method = RequestMethod.GET)
     * Annotation for mapping HTTP GET requests onto specific handler methods.
     */
    @GetMapping("/applications")
    public ResponseEntity<List<Application>> getApplications() {
        List<Application> applications = applicationService.getApplications();
        return new ResponseEntity<List<Application>>(applications, HttpStatus.OK);
    }


//    /* @ResponseBody: To Generate the response message.
//     * using @ResponseBody we can only return the body of response but not status, for that we need ResponseEntity
//     */
//    @GetMapping("/applications")
//    public @ResponseBody List<Application> getApplications() {
//        List<Application> applications = applicationService.getApplications();
//        return applications ;
//    }
//
//   // OR
//
//   // using @ResponseBody we can only return the body of response but not status, for that we need ResponseEntity
//    @GetMapping("/applications")
//    @ResponseBody
//    public List<Application> getApplications() {
//        List<Application> applications = applicationService.getApplications();
//        return applications ;
//    }

    @GetMapping("/application/{appId}")
    public @ResponseBody
    Optional<Application> getApplicationById(@PathVariable Long appId) {
        Optional<Application> application = applicationService.getApplicationById(appId);
        return  application;
    }

}
