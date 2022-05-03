package com.example.esun.service;

import com.example.esun.domain.request.SearchEsunDataRequest;
import com.example.esun.domain.response.SearchEsunDataResponse;

import java.util.List;

public interface EsunService {

    List<SearchEsunDataResponse> searchEsunData(SearchEsunDataRequest request);
}
