package com.currencyConverter;

/**
 *  Conversion Transaction Data Transfer Object
 **/
public class ConversionDTO {
    private double baseAmount;
    private String baseCurrency;
    private String conversionCurrency;
    private double conversionResult;
    private double conversionRate;

    /**
     * Constructor
     **/
    public ConversionDTO(){
        super();
    }

    /**
     * Overriding Constructor for setting base currency and conversion currency.
     **/
    public ConversionDTO(final String baseCurrency, final String conversionCurrency){
        super();
        this.baseCurrency = baseCurrency;
        this.conversionCurrency = conversionCurrency;
    }

    /**
     * Base Currency Setter.
     **/
    public void setBaseCurrency(final String baseCurrency){
        this.baseCurrency = baseCurrency;
    }

    /**
     * Base Currency Getter.
     **/
    public String getBaseCurrency(){
        return baseCurrency;
    }

    /**
     * Conversion Currency Setter.
     **/
    public void setConversionCurrency(final String conversionCurrency){
        this.conversionCurrency = conversionCurrency;
    }

    /**
     * Conversion Currency Getter.
     **/
    public String getConversionCurrency(){
        return conversionCurrency;
    }

    /**
     * Conversion Result Setter.
     **/
    public void setConversionResult(final double conversionResult){
        this.conversionResult = conversionResult;
    }

    /**
     * Conversion Result Getter.
     **/
    public double getConversionResult(){
        return conversionResult;
    }

    /**
     * Conversion Rate Setter.
     **/
    public void setConversionRate(final double conversionRate){
        this.conversionRate = conversionRate;
    }

    /**
     * Conversion Rate Getter.
     **/
    public double getConversionRate(){
        return conversionRate;
    }

    /**
     * Base Amount Setter.
     **/
    public void setBaseAmount(final double baseAmount){
        this.baseAmount = baseAmount;
    }

    /**
     * Base Amount Getter.
     **/
    public double getBaseAmount(){
        return baseAmount;
    }
}
