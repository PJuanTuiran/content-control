package com.riwi.workshop.repositories;

import com.riwi.workshop.entities.Class;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ClassRepository extends JpaRepository<Class, Long> {
    Page<Class> findByActiveTrueAndNameContainingAndDescriptionContaining(String name, String description, Pageable pageable);
    Optional<Class> findByIdAndActiveTrue(Long id);
}

