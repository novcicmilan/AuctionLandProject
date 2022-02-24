package com.antech.consulting.antechauthservice.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class DebugController {

    @GetMapping("/debug")
    String DebugEndPoint(){
        return "Hello from debug endpoint!";
    }
}
