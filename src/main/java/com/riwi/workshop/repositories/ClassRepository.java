package com.riwi.workshop.repositories;

import com.riwi.workshop.entities.Class;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassRepository extends JpaRepository<Class, Long> {
}
