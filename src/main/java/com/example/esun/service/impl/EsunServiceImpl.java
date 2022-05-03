package com.example.esun.service.impl;

import com.example.esun.domain.request.SearchEsunDataRequest;
import com.example.esun.domain.response.SearchEsunDataResponse;
import com.example.esun.domain.to.EsunData;
import com.example.esun.service.EsunService;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class EsunServiceImpl implements EsunService {


    private final static String API_URI = "https://www.esunbank.com.tw/bank/Layouts/esunbank/Deposit/DpService.aspx/GetLineChartJson";

    private final static String REFERER = "https://www.esunbank.com.tw/bank/personal/deposit/rate/forex/exchange-rate-chart?Currency=USD/TWD";

    private final static String USER_AGENT= "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/101.0.4951.41 Safari/537.36";

    @Override
    public List<SearchEsunDataResponse> searchEsunData(final SearchEsunDataRequest request){

        final String response = postToEsun(request);

        final JsonArray jsonArray = JsonParser.parseString(response).getAsJsonObject().getAsJsonArray("Rates");

        final ArrayList<SearchEsunDataResponse> responses = new ArrayList<>();

        for (JsonElement searchResponse : jsonArray) {
            final SearchEsunDataResponse dataResponse = new Gson().fromJson(searchResponse, SearchEsunDataResponse.class);
            responses.add(dataResponse);
        }

        log.info(responses.toString());

        return responses;
    }

    private String postToEsun(final SearchEsunDataRequest request){

        final CloseableHttpClient client = HttpClients.createDefault();

        final EsunData esunData = EsunData.builder().data(EsunData.JsonData.builder().Currency(request.getCurrency()).CurrencyTitle(request.getCurrency().getCurrencyTitle())
                .Currencytype(request.getCurrencytype()).Rangetype(request.getRangetype()).Startdate(request.getStartdate()).Enddate(request.getEnddate()).build()).build();

        final String data = new Gson().toJson(esunData);

        final HttpPost httpPost = new HttpPost(API_URI);

        final StringEntity entity = new StringEntity(data, "UTF-8");

        httpPost.setEntity(entity);
        httpPost.setHeader("Content-type", String.valueOf(ContentType.APPLICATION_JSON));
        httpPost.setHeader("User-Agent", USER_AGENT);
        httpPost.setHeader("Referer", REFERER);

        try {
            final CloseableHttpResponse response = client.execute(httpPost);

            return EntityUtils.toString(response.getEntity());

        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return null;
    }
}
