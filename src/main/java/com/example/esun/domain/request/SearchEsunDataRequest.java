package com.example.esun.domain.request;

import lombok.Builder;
import lombok.Data;
import com.example.esun.domain.Enum.Currency;

@Data
@Builder
public class SearchEsunDataRequest {

    private Currency Currency;

    private Integer Currencytype;

    private Integer Rangetype;

    private String Startdate;

    private String Enddate;

}
