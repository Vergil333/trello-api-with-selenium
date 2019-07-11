package com.machava.demo.trelloapiwithselenium.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.machava.demo.trelloapiwithselenium.managers.TrelloManager;

@CrossOrigin("*")
@RestController
@RequestMapping("/trello")
public class TrelloController {

    @Autowired
    private TrelloManager trelloManager;

    @PostMapping("/make-bity-happy")
    public String makeBityHappy() {
        trelloManager.archiveAllLists();
        String idNewList = trelloManager.createDemoList().getId();
        trelloManager.createDemoCard(idNewList);

        return "Yay, you are happy!";
    }
}
