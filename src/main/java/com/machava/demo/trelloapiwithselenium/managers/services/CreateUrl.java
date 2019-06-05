package com.machava.demo.trelloapiwithselenium.managers.services;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.machava.demo.trelloapiwithselenium.config.ApplicationProperties;
import com.machava.demo.trelloapiwithselenium.managers.CreateParameters;

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
        CreateParameters params = new CreateParameters("key", applicationProperties.trelloKey);
        params.add("token", applicationProperties.token);

        credentials = "?" + params;
    }

    public String lists() {
        return apiUrlBoard + applicationProperties.demoBoard + "/lists" + credentials;
    }

    public List<String> archiveList(List<String> idLists) {
        List<String> url = new ArrayList<>();
        idLists.forEach(idList -> {
            url.add(apiUrlLists + "/" + idList + "/closed" + credentials + "&value=true");
        });

        return url;
    }

    public String createDemoList() {
        CreateParameters params = new CreateParameters("name", "Demo List");
        params.add("idBoard", applicationProperties.getDemoBoard());
        return apiUrlLists + credentials + "&" + params;
    }

   public String createDemoCard(String idNewList) {
        CreateParameters params = new CreateParameters("name", "Demo Card");
        params.add("idList", idNewList);
        params.add("idBoard", applicationProperties.getDemoBoard());

        return apiUrlCards + credentials + "&" + params;
    }

}
