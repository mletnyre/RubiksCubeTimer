package com.MatthewEtnyre.rubiksTimer.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.MatthewEtnyre.rubiksTimer.service.TimerService;

import jakarta.persistence.Table;

@Controller
@Table(name = "time_record")
public class TimerConroller{

     private final TimerService TS ; 

    TimerConroller(TimerService TS){
        this.TS = TS;
    }
    
    @PostMapping("/save/{time}")
    public ResponseEntity<String> saveTime(@PathVariable String time){
        return TS.saveTime(time);
    }

    @PutMapping("/plus2")
    public ResponseEntity<String> plusTwo(){
        return TS.PlusTwoLastSolve();
    }

    @PutMapping("/DNF")
    public ResponseEntity<String> DNF(){
        return TS.DNFSolve();
    }

    @DeleteMapping("/DeleteLast")
    public ResponseEntity<String> DeleteLast(){
        return TS.DeleteLast();
    }
}