package com.hodges.fitnessTracker1.repositories;

import com.hodges.fitnessTracker1.models.Activity;
import com.hodges.fitnessTracker1.models.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivityRepository extends JpaRepository<Activity,Long> {
    List<Activity> findByTagsContains(Tag tag);
}
