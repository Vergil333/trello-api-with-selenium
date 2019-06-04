package com.machava.demo.trelloapiwithselenium.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.machava.demo.trelloapiwithselenium.dtos.CardDto;
import com.machava.demo.trelloapiwithselenium.dtos.ListDto;
import com.machava.demo.trelloapiwithselenium.managers.TrelloManager;

@CrossOrigin("*")
@RestController
@RequestMapping("/trello")
public class TrelloController {

    @Autowired
    private TrelloManager trelloManager;

    // Testing
    @GetMapping("/test")
    public String testApi() {
        return "API is working!";
    }

    @PostMapping("/archive-all-lists")
    public List<List<Object>> archiveAllLists() {
        return trelloManager.archiveAllLists();
    }

    // List
    @GetMapping("/get-all-lists")
    public List<ListDto> getAllLists() {
        return trelloManager.getAllLists();
    }

    @GetMapping("/get-demo-list")
    public ListDto getDemoList() {
        return trelloManager.getDemoList();
    }

    // Card
    @GetMapping("/get-demo-cards")
    public List<CardDto> getAllCardsInDemoList() {
        return trelloManager.getAllCardsInDemoList();
    }
}
