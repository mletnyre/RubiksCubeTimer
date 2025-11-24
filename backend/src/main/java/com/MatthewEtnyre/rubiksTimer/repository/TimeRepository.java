package com.MatthewEtnyre.rubiksTimer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MatthewEtnyre.rubiksTimer.entity.TimeRecord;

@Repository
public interface TimeRepository extends JpaRepository<TimeRecord, Long> {}
