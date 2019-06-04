package com.machava.demo.trelloapiwithselenium.managers.services;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.machava.demo.trelloapiwithselenium.config.ApplicationProperties;

@Service
public class CreateUrl {

    @Autowired
    private ApplicationProperties applicationProperties;

    private String apiUrlBoard = "https://api.trello.com/1/boards/";
    private String apiUrlLists = "https://api.trello.com/1/lists";
    private String apiUrlCards = "https://api.trello.com/1/cards";
    private String credentials;

    @PostConstruct
    public void init() {
        credentials = "?key=" + applicationProperties.trelloKey + "&token=" + applicationProperties.token;
    }

    public String lists() {
        return apiUrlBoard + applicationProperties.demoBoard + "/lists" + credentials;
    }

    public List<String> archiveList(List<String> idLists) {
        List<String> url = new ArrayList<>();
        idLists.forEach(idList -> {
            url.add(apiUrlLists + idList + "/closed" + credentials +"&value=true");
        });

        return url;
    }

    public String createDemoList() {
        return apiUrlLists + credentials + "&name=Demo List&idBoard=" + applicationProperties.getDemoBoard();
    }

    // 'https://api.trello.com/1/cards?name=Demo%20Card&idList=idNewList&keepFromSource=all&key=77c295ce5af4dcf6e1878306ace9d3ca&token=1405f79b5546bdd3261f0c025266aea51fb61824fce5c0523bf5fa69b1fb5378'
    public String createDemoCard(String idNewList) {
        return apiUrlCards + credentials + "&name=Demo Card&idList=" + idNewList + "&idBoard=" + applicationProperties.getDemoBoard();
    }

}
