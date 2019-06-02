package com.machava.demo.trelloapiwithselenium.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.machava.demo.trelloapiwithselenium.dto.CardDto;
import com.machava.demo.trelloapiwithselenium.dto.ListDto;
import com.machava.demo.trelloapiwithselenium.manager.TrelloManager;

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

    // List
    @GetMapping("/get-all-lists")
    public List<ListDto> getAllLists() {
        return trelloManager.getAllLists();
    }

    @GetMapping("/get-demo-list")
    public ListDto getDemoList() {
        return trelloManager.getDemoList();
    }

    @PostMapping("/archive-all-lists")
    public String archiveAllLists() {

        return trelloManager.archiveAllLists(); // do try&catch
    }

    // Card
    @GetMapping("/get-demo-cards")
    public List<CardDto> getAllCardsInDemoList() {
        return trelloManager.getAllCardsInDemoList();
    }
}
