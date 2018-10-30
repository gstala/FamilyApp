package com.stala.family.repository;

import com.stala.family.model.Father;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FatherRepository extends JpaRepository<Father, Long> {

    Optional<Father> findByFamilyId(long familyId);
}
