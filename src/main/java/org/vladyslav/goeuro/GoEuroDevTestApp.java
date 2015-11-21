package org.vladyslav.goeuro;

import org.vladyslav.goeuro.csv.CsvStringBuilder;
import org.vladyslav.goeuro.model.Record;
import org.vladyslav.goeuro.utils.GoEuroApi;

public class GoEuroDevTestApp {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Provide a city name as a single parameter to this application.");
            System.exit(-1);
        }

        try {
            String cityName = args[0];
            for (Record record : GoEuroApi.fetchCityRecords(cityName)) {
                System.out.println(CsvStringBuilder.toString(record));
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

}