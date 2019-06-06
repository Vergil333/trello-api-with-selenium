package com.machava.demo.trelloapiwithselenium.managers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.machava.demo.trelloapiwithselenium.dtos.CardDto;
import com.machava.demo.trelloapiwithselenium.dtos.ListDto;
import com.machava.demo.trelloapiwithselenium.managers.services.CreateUrl;

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

    public List<List<Object>> archiveAllLists() {

        List<String> idLists = this.getAllLists()
                .stream().map(ListDto::getId).collect(Collectors.toList());

        List<String> apiUrls = new ArrayList<>();
        apiUrls.addAll(createUrl.archiveList(idLists));

        List<List<Object>> resultList = new ArrayList<>();

        apiUrls.forEach(url->{
            ResponseEntity<ListDto> response = restTemplate.exchange(
                    url,
                    HttpMethod.PUT,
                    null,
                    new ParameterizedTypeReference<>(){});

            List<Object> tempList = new ArrayList<Object>();
            tempList.add(response.getBody());
            tempList.add("Status Code: " + response.getStatusCodeValue());

            resultList.add(tempList);
        });

        return resultList;
    }

    public ListDto createDemoList() {

        String apiUrl = createUrl.createDemoList();

        ResponseEntity<ListDto> response = restTemplate.exchange(
                apiUrl,
                HttpMethod.POST,
                null,
                new ParameterizedTypeReference<ListDto>() {});

        return response.getBody();
    }

    public CardDto createDemoCard(String idNewList) {

        if (idNewList == null) {
            return new CardDto();
        }

        String apiUrl = createUrl.createDemoCard(idNewList);

        ResponseEntity<CardDto> response = restTemplate.exchange(
                apiUrl,
                HttpMethod.POST,
                null,
                new ParameterizedTypeReference<CardDto>() {});

        return response.getBody();
    }

}
