package org.vladyslav.goeuro.model;

import com.google.api.client.util.Key;
import org.vladyslav.goeuro.csv.CsvCompatible;
import org.vladyslav.goeuro.csv.CsvStringBuilder;

public class Record implements CsvCompatible {
    @Key("_id")
    private long id;

    @Key("name")
    private String name;

    @Key("type")
    private String type;

    @Key("geo_position")
    private GeoPosition geoPosition;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public GeoPosition getGeoPosition() {
        return geoPosition;
    }

    @Override
    public String toString() {
        return "Record{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", geoPosition=" + geoPosition +
                '}';
    }

    @Override
    public void appendTo(CsvStringBuilder builder) {
        builder.append(id).append(name).append(type).csvAppend(geoPosition);
    }
}
