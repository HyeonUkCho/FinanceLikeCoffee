package com.example.FLC.FinanceLikeCoffee.domain.log;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitLogRepository extends JpaRepository<VisitLog, Long> {
}
