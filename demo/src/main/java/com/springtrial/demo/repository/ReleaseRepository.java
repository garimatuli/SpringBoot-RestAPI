package com.springtrial.demo.repository;

import com.springtrial.demo.entity.Release;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReleaseRepository extends CrudRepository<Release,Long> {



}

