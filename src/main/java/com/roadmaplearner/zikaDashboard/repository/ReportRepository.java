package com.roadmaplearner.zikaDashboard.repository;

import com.roadmaplearner.zikaDashboard.model.Report;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public interface ReportRepository extends JpaRepository<Report, Long>{
}
