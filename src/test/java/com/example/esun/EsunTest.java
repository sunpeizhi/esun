package com.example.esun;

import com.example.esun.domain.Enum.Currency;
import com.example.esun.domain.request.SearchEsunDataRequest;
import com.example.esun.domain.response.SearchEsunDataResponse;
import com.example.esun.service.EsunService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class EsunTest {

    private final  EsunService esunService;

    public EsunTest(final EsunService esunService) {
        this.esunService = esunService;
    }

    @Test
    void testApi(){

        final SearchEsunDataRequest request = SearchEsunDataRequest.builder().Currency(Currency.CNY).Currencytype(0).Rangetype(3)
                .Startdate("2021-04-30").Enddate("2022-04-30").build();

        final List<SearchEsunDataResponse> responses = esunService.searchEsunData(request);
        Assertions.assertTrue(responses.size() > 0);
        System.out.println(responses);
    }
}
