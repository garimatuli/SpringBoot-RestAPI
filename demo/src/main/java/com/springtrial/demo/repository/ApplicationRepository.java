package com.springtrial.demo.repository;

import com.springtrial.demo.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {

}

/* Repository Name i.e. the type of the entity, Type of Primary Key of Entity - here AppId
 * Now my built in functions like findAll , save will be available to be used in service
 * Can write any other queries also
 */

/* we can also do ApplicationRepository extends CRUDRepository but using JpaRepository gives us more in-built methods
 * As JpaRepository extends CrudRepository and PagingAndSorting repository so we will get methods of both
 */
