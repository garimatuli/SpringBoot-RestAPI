package com.springtrial.demo.controller;

import com.springtrial.demo.entity.Application;
import com.springtrial.demo.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
// url structure - path will start with /garima
@RequestMapping("/garima")
public class ApplicationController {

    // when autowired no need to use this.
    // Wiring ApplicationService with controller
    @Autowired
    ApplicationService applicationService;

    /* ResponseEntity is a class, it represents an HTTP response, including headers, body, and status.
       While @ResponseBody puts the return value into the body of the response,
       ResponseEntity also allows us to add headers and status code. */

    // Attaching path to function
    @GetMapping("/applications")
    public ResponseEntity<List<Application>> getApplications() {
        List<Application> applications = applicationService.getApplications();
        return new ResponseEntity<List<Application>>(applications, HttpStatus.OK);
    }

//   // using @ResponseBody we can only return the body of response but not status, for that we need ResponseEntity
//    @GetMapping("/applications")
//    public @ResponseBody List<Application> getApplications() {
//        List<Application> applications = applicationService.getApplications();
//        return applications ;
//    }

//   // OR

//   // using @ResponseBody we can only return the body of response but not status, for that we need ResponseEntity
//    @GetMapping("/applications")
//    @ResponseBody
//    public List<Application> getApplications() {
//        List<Application> applications = applicationService.getApplications();
//        return applications ;
//    }


}
