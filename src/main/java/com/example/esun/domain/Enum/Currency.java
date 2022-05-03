package com.example.esun.domain.Enum;

public enum Currency {
    CNY("人民幣(CNY)"),
    USD("美元(USD)"),
    ZAR("南非幣(ZAR)"),
    NZD("紐西蘭幣(NZD)"),
    EUR("歐元(EUR)"),
    HKD("港幣(HKD)"),
    JPY("日圓(JPY)");

    private final String CurrencyTitle;

    Currency(String CurrencyTitle) {
        this.CurrencyTitle = CurrencyTitle;
    }

    public String getCurrencyTitle() {
        return CurrencyTitle;
    }
}
