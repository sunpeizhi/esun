package com.example.esun.domain.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SearchEsunDataResponse {

    @JsonProperty("Time")
    private String Time;

    @JsonProperty("BuyRate")
    private double BuyRate;

    @JsonProperty("SellRate")
    private double SellRate;

}
