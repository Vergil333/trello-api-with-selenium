package com.machava.demo.trelloapiwithselenium.manager;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.machava.demo.trelloapiwithselenium.dto.CardDto;
import com.machava.demo.trelloapiwithselenium.dto.ListDto;
import com.machava.demo.trelloapiwithselenium.manager.services.CreateUrl;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class TrelloManager {

    @Autowired
    private CreateUrl createUrl;

    @Autowired
    private RestTemplate restTemplate;

    public List<ListDto> getAllLists() {

        String apiUrl = createUrl.lists();

        ResponseEntity<List<ListDto>> response = restTemplate.exchange(
                apiUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<ListDto>>(){});
        List<ListDto> responseList = response.getBody();

        return responseList;
    }

    public ListDto getDemoList() {

        List<ListDto> allLists = this.getAllLists();

        ListDto demoList = allLists.stream()
                .filter(p -> p.getName().equals("Demo List"))
                .findFirst().orElse(null);

        return demoList;
    }

    public List<CardDto> getAllCards() {

        String apiUrl = createUrl.cards();

        ResponseEntity<List<CardDto>> response = restTemplate.exchange(
                apiUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<CardDto>>(){});
        List<CardDto> responseList = response.getBody();

        return responseList;
    }

    public List<CardDto> getAllCardsInDemoList() {

        String demoListId = this.getDemoList().getId();

        return null;
    }

    public String archiveAllLists() {

        List<String> idLists = this.getAllLists()
                .stream().map(ListDto::getId).collect(Collectors.toList());

        return null; // just for now

    }

}
