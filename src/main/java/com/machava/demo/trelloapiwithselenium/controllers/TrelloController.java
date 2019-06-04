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

    @PostMapping("/create-demo-list")
    public ListDto createDemoList() {
        return trelloManager.createDemoList();
    }

    @PostMapping("/create-demo-card")
    public CardDto createDemoCard(String idList) {
        return trelloManager.createDemoCard(idList);
    }

    @PostMapping("/make-bity-happy")
    public String makeBityHappy() {
        trelloManager.archiveAllLists();
        String idNewList = trelloManager.createDemoList().getId();
        trelloManager.createDemoCard(idNewList);

        return "Yay, you are happy!";
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

}
