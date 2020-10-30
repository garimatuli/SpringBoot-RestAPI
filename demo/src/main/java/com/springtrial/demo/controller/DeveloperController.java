package com.springtrial.demo.controller;

import com.springtrial.demo.entity.Developer;
import com.springtrial.demo.repository.DeveloperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/garima")
public class DeveloperController {
    @Autowired
    private DeveloperRepository developerRepository;

    @GetMapping("/getDevelopers")
    public List<Developer> getDevelopers(){
        return developerRepository.findAll();
    }

    @GetMapping("/getDevelopers/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Developer getDeveloper(@PathVariable Long id){
        return developerRepository.getOne(id);
    }

    @PostMapping("/postDeveloper")
    @ResponseStatus(HttpStatus.CREATED)
    public Developer createDeveloper(@RequestBody final Developer developer){
        return developerRepository.saveAndFlush(developer);
    }

    @RequestMapping(value = {"id"},method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id){
        developerRepository.deleteById(id);
    }

}
