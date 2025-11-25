package com.MatthewEtnyre.rubiksTimer.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MatthewEtnyre.rubiksTimer.entity.TimeRecord;

@Repository
public interface TimeRepository extends JpaRepository<TimeRecord, Long> {
   Optional<TimeRecord> findTopByOrderByIdDesc();
}
