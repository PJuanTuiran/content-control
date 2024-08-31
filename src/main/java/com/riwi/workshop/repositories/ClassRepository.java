package com.riwi.workshop.repositories;

import com.riwi.workshop.entities.Class;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface ClassRepository extends JpaRepository<Class, Long> {
    Set<Class> findAllById(Set<Long> ids);
}
