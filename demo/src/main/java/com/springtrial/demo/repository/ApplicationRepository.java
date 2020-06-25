package com.springtrial.demo.repository;

import com.springtrial.demo.entity.Application;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationRepository extends CrudRepository<Application, Long> {
    /* Repository Name i.e. the type of the entity, Type of Primary Key of Entity - here AppId
     * Now my built in functions like findAll , save will be available to be used in service
     * Can write any other queries also
     */


}
