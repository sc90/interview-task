package com.currencyConverter;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.apache.http.client.utils.URIBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;

@RestController
public class CurrencyConverterController {

    public CurrencyConverterController(){}

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path="/currencyConversion", consumes = "application/json", produces = "application/json")
    ConversionDTO transaction(@RequestBody ConversionDTO conversionDTO)  throws Exception {

        //Build request URL
        URIBuilder builder = new URIBuilder();
        builder.setScheme("https");
        builder.setHost("api.exchangeratesapi.io");
        builder.setPath("/latest");
        builder.addParameter("base",conversionDTO.getBaseCurrency());
        final String url = builder.build().toString();

        //Request for conversion rates from API
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);

        //Getting the rate's value after converting response string to json
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode responseJson = objectMapper.readTree(response);
        double currencyConversionRate =
                responseJson.get("rates")
                .get(conversionDTO.getConversionCurrency())
                .asDouble();
        conversionDTO.setConversionRate(currencyConversionRate);

        //Convert base amount according to rate and store in dto
        double conversionResult = conversionDTO.getBaseAmount() * currencyConversionRate;
        conversionDTO.setConversionResult(conversionResult);
        return conversionDTO;
    }
}
