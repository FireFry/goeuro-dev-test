package org.vladyslav.goeuro.utils;

import com.google.api.client.http.GenericUrl;
import org.vladyslav.goeuro.model.Record;

import java.io.IOException;

public class GoEuroApi {

    public static final String GET_CITY_RECORDS_PREFIX = "http://api.goeuro.com/api/v2/position/suggest/en/";

    private GoEuroApi() {}

    public static Record[] fetchCityRecords(String city) throws IOException {
        return HttpUtils.executeJsonGetRequest(cityRecordsUrl(city), Record[].class);
    }

    public static GenericUrl cityRecordsUrl(String city) {
        return new GenericUrl(GET_CITY_RECORDS_PREFIX + city);
    }

}
