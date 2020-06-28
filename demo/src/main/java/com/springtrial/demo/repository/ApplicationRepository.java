package com.springtrial.demo.repository;

import com.springtrial.demo.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {

    // delete record with a specific appName
    @Transactional
    @Modifying
    @Query("DELETE from Application where appName = :appName")
    void deleteAppsByName(@Param("appName") String appName);

    // checking if any app name already exists in database, if it does then don't insert any record
    @Query("SELECT a from Application a where a.appName =:appName")
    Application checkAppName(@Param("appName") String appName);

}

/* Repository Name i.e. the type of the entity, Type of Primary Key of Entity - here AppId
 * Now my built in functions like findAll , save will be available to be used in service
 * Can write any other queries also
 */

/* we can also do ApplicationRepository extends CRUDRepository but using JpaRepository gives us more in-built methods
 * As JpaRepository extends CrudRepository and PagingAndSorting repository so we will get methods of both
 */
