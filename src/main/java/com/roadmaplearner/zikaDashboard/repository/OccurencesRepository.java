package com.roadmaplearner.zikaDashboard.repository;

import com.roadmaplearner.zikaDashboard.model.Occurences;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public interface OccurencesRepository extends JpaRepository<Occurences, Long>{
}
