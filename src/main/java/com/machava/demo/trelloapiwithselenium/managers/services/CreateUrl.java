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
    private String apiUrlLists = "https://api.trello.com/1/lists/";
    private String credentials;

    @PostConstruct
    public void init() {
        credentials = "?key=" + applicationProperties.trelloKey + "&token=" + applicationProperties.token;
    }

    public String lists() {
        return apiUrlBoard + applicationProperties.demoBoard + "/lists" + credentials;
    }

    public String cards() {
        return apiUrlBoard + applicationProperties.demoBoard + "/cards" + credentials;
    }

    public List<String> archiveList(List<String> idLists) {
        List<String> url = new ArrayList<>();
        idLists.forEach(idList -> {
            url.add(apiUrlLists + idList + "/closed" + credentials +"&value=true");
        });

        return url;
    }

}
