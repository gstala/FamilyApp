package com.stala.family.repository;

import com.stala.family.model.Child;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChildRepository extends JpaRepository<Child, Long>, JpaSpecificationExecutor<Child> {

    List<Child> findByFirstNameLike(String firstName);

    List<Child> findAllByFamilyId(long familyId);
}
