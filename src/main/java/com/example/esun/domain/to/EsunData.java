package com.example.esun.domain.to;

import com.example.esun.domain.Enum.Currency;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EsunData {

    private JsonData data;

    @Data
    @Builder
    public static class JsonData {

        private Currency Currency;

        private Integer Currencytype;

        private Integer Rangetype;

        private String Startdate;

        private String Enddate;

        private String CurrencyTitle;
    }
}
