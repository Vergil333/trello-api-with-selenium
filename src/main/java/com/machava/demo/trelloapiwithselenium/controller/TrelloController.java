package com.machava.demo.trelloapiwithselenium.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.machava.demo.trelloapiwithselenium.dto.TrelloBoardDto;

@CrossOrigin("*")
@RestController
@RequestMapping("/trello")
public class TrelloController {

    @GetMapping("/test")
    public String testApi() {
        return "API is working";
    }

    @GetMapping("/get-info")
    public TrelloBoardDto getData() {
        return null;
    }
}
