package com.MatthewEtnyre.rubiksTimer.service;

import java.util.Optional;

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

    public ResponseEntity<String> PlusTwoLastSolve(){
        Optional<TimeRecord> optional_timerecord= TR.findTopByOrderByIdDesc();
        if(optional_timerecord.isEmpty()){
            return ResponseEntity.badRequest().body("Time not found");
        }
        
        TimeRecord time = optional_timerecord.get();
        int t = Integer.parseInt(time.getTime());
        t += 2000;
        time.setTime(String.valueOf(t));
        TR.save(time);

        return ResponseEntity.ok().body("updated time");
    }

    public ResponseEntity<String> DNFSolve(){
        Optional<TimeRecord> optional_timerecord = TR.findTopByOrderByIdDesc();
        if(optional_timerecord.isEmpty()){
            return ResponseEntity.badRequest().body("Time not found");
        }

        TimeRecord time = optional_timerecord.get();
        time.setTime("DNF");
        TR.save(time);

        return ResponseEntity.ok().body("updated time");
    }

    public ResponseEntity<String> DeleteLast(){
        Optional<TimeRecord> optional_timerecord = TR.findTopByOrderByIdDesc();
        if(optional_timerecord.isEmpty()){
            return ResponseEntity.badRequest().body("Time not found");
        }

        TimeRecord time = optional_timerecord.get();
        Long id = time.getId();
        TR.deleteById(id);

        return ResponseEntity.ok().body("updated time");
    }

    public ResponseEntity<String> DeleteAll(){
        TR.deleteAll();
        return ResponseEntity.ok().body("everything has been deleted");
    }
}