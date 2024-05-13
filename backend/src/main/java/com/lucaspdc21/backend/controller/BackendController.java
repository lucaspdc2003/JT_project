package com.lucaspdc21.backend.controller;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class BackendController {
    @GetMapping
    public String get(){
        return "ho!";
    }
}
