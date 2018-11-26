package com.example.demogridflow.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
