package com.MatthewEtnyre.rubiksTimer.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.MatthewEtnyre.rubiksTimer.service.TimerService;

@Controller
public class TimerConroller{

     private final TimerService TS ; 

    TimerConroller(TimerService TS){
        this.TS = TS;
    }
    
    @PostMapping("/save/{time}")
    public ResponseEntity<String> saveTime(@PathVariable String time){
        return TS.saveTime(time);
    }
}