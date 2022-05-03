package com.example.esun.controller;


import com.example.esun.domain.request.SearchEsunDataRequest;
import com.example.esun.domain.response.SearchEsunDataResponse;
import com.example.esun.service.EsunService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/esun")
public class EsunController {

    private final EsunService esunService;

    public EsunController(final EsunService esunService) {
        this.esunService = esunService;
    }

    @PostMapping
    public List<SearchEsunDataResponse> search(@RequestBody final SearchEsunDataRequest request){
        return esunService.searchEsunData(request);
    }
}
