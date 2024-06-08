package com.hodges.fitnessTracker1.repositories;

import com.hodges.fitnessTracker1.models.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends JpaRepository<Tag,Long> {
}
