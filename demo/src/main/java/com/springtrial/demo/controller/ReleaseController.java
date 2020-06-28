package com.springtrial.demo.controller;
import com.springtrial.demo.entity.Release;
import com.springtrial.demo.service.ReleaseService;
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
public class ReleaseController {

    @Autowired
    ReleaseService releaseService;

    // Aggregate root
    @GetMapping("/getReleases")
    public @ResponseBody List<Release> getReleases() {
        List<Release> releases = releaseService.getReleases();
        return releases;
    }

//    @PostMapping(value = "/releases",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseStatus(HttpStatus.OK)
//    public void postReleases(@Validated @RequestBody List<Release> releases){
//        releaseService.saveRelease(releases);
//    }

    @PostMapping(value = "/addReleases")
    public ResponseEntity<String> postReleases(@Validated @RequestBody List<Release> releases){
        releaseService.saveRelease(releases);
        return new ResponseEntity<String>("{\"Response\":\"Successfully Posted Data\"}",HttpStatus.OK);
    }

    // Single item
    @GetMapping("/getReleaseById/{releaseId}")
    public ResponseEntity<Optional<Release>> getReleaseById(@PathVariable(name = "releaseId") Long releaseId){
        Optional<Release> release = releaseService.getReleaseById(releaseId);
        return  new ResponseEntity<>(release,HttpStatus.OK);
    }

    // Equivalent to @RequestMapping(value="/orders{id}", method=RequestMethod.PUT)
    @PutMapping("/updateReleaseById/{id}")
    public ResponseEntity<String> updateReleaseById(@PathVariable(name = "id") Long releaseId,@Validated @RequestBody Release releaseObj){
        boolean check = releaseService.updateReleaseById(releaseId,releaseObj);
        if (check) {
            return new ResponseEntity<String>("{\"Response\":\"Record updated successfully\"}", HttpStatus.OK);
        }
        return new ResponseEntity<String>("{\"Response\":\"No record exists with this id\"}", HttpStatus.NOT_FOUND);
    }
}

// Comments
// https://www.javaguides.net/2018/11/spring-getmapping-postmapping-putmapping-deletemapping-patchmapping.html

/* @PostMapping Annotation is for mapping HTTP POST requests onto specific handler methods.
 * It is a composed annotation that acts as a shortcut for @RequestMapping(method = RequestMethod.POST).
 */

/*
 * @RequestBody is used in the method parameter and the body of the http request will be mapped to that method parameter releases.
 * @Validated tells Spring to pass the object to a Validator before doing anything else.
 * When we post/insert data, in case of a successful operation, we just want to return a message (string) & the status in the response entity
 */

/*
 * Extract id from url using @PathVariable and mapping it to releaseId
 * Extracting details from request body and mapping to releaseObj
 * If successfully updated, return success string message & success status both in a ResponseEntity
 * If not updated, return not a success string message & NOT FOUND status both in a ResponseEntity
 */

//    @DeleteMapping("/release/{id}")
//    // Equivalent to @RequestMapping(value="/orders{id}", method=RequestMethod.DELETE)

//    @PatchMapping("/release/{id}")
//    // Equivalent to @RequestMapping(value="/orders{id}", method=RequestMethod.PATCH)
