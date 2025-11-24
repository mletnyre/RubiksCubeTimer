package com.MatthewEtnyre.rubiksTimer.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.MatthewEtnyre.rubiksTimer.entity.TimeRecord;
import com.MatthewEtnyre.rubiksTimer.repository.TimeRepository;


@Service
public class TimerService{

    private final TimeRepository TR; 

    TimerService(TimeRepository TR){
        this.TR = TR;
    }

    public ResponseEntity<String> saveTime(String time){
        
        TimeRecord t = new TimeRecord(time);
        TR.save(t);
        return ResponseEntity.ok().body("Saved");
    }
}