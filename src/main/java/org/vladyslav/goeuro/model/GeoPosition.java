package org.vladyslav.goeuro.model;

import com.google.api.client.util.Key;
import org.vladyslav.goeuro.csv.CsvCompatible;
import org.vladyslav.goeuro.csv.CsvStringBuilder;

public class GeoPosition implements CsvCompatible {
    @Key("latitude")
    private double latitude;

    @Key("longitude")
    private double longitude;

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    @Override
    public String toString() {
        return "GeoPosition{" + "latitude=" + latitude + ", longitude=" + longitude + '}';
    }

    @Override
    public void appendTo(CsvStringBuilder builder) {
        builder.append(latitude).append(longitude);
    }
}
