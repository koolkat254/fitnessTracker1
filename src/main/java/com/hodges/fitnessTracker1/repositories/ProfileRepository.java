package com.hodges.fitnessTracker1.repositories;

import com.hodges.fitnessTracker1.models.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface ProfileRepository extends JpaRepository<Profile,Long> {
    Set<Profile> findByUserId(Long user);
}
