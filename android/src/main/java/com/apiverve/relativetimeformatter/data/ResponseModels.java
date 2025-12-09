// Converter.java

// To use this code, add the following Maven dependency to your project:
//
//
//     com.fasterxml.jackson.core     : jackson-databind          : 2.9.0
//     com.fasterxml.jackson.datatype : jackson-datatype-jsr310   : 2.9.0
//
// Import this package:
//
//     import com.apiverve.data.Converter;
//
// Then you can deserialize a JSON string with
//
//     RelativeTimeFormatterData data = Converter.fromJsonString(jsonString);

package com.apiverve.relativetimeformatter.data;

import java.io.IOException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.*;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

public class Converter {
    // Date-time helpers

    private static final DateTimeFormatter DATE_TIME_FORMATTER = new DateTimeFormatterBuilder()
            .appendOptional(DateTimeFormatter.ISO_DATE_TIME)
            .appendOptional(DateTimeFormatter.ISO_OFFSET_DATE_TIME)
            .appendOptional(DateTimeFormatter.ISO_INSTANT)
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SX"))
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ssX"))
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
            .toFormatter()
            .withZone(ZoneOffset.UTC);

    public static OffsetDateTime parseDateTimeString(String str) {
        return ZonedDateTime.from(Converter.DATE_TIME_FORMATTER.parse(str)).toOffsetDateTime();
    }

    private static final DateTimeFormatter TIME_FORMATTER = new DateTimeFormatterBuilder()
            .appendOptional(DateTimeFormatter.ISO_TIME)
            .appendOptional(DateTimeFormatter.ISO_OFFSET_TIME)
            .parseDefaulting(ChronoField.YEAR, 2020)
            .parseDefaulting(ChronoField.MONTH_OF_YEAR, 1)
            .parseDefaulting(ChronoField.DAY_OF_MONTH, 1)
            .toFormatter()
            .withZone(ZoneOffset.UTC);

    public static OffsetTime parseTimeString(String str) {
        return ZonedDateTime.from(Converter.TIME_FORMATTER.parse(str)).toOffsetDateTime().toOffsetTime();
    }
    // Serialize/deserialize helpers

    public static RelativeTimeFormatterData fromJsonString(String json) throws IOException {
        return getObjectReader().readValue(json);
    }

    public static String toJsonString(RelativeTimeFormatterData obj) throws JsonProcessingException {
        return getObjectWriter().writeValueAsString(obj);
    }

    private static ObjectReader reader;
    private static ObjectWriter writer;

    private static void instantiateMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        SimpleModule module = new SimpleModule();
        module.addDeserializer(OffsetDateTime.class, new JsonDeserializer<OffsetDateTime>() {
            @Override
            public OffsetDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
                String value = jsonParser.getText();
                return Converter.parseDateTimeString(value);
            }
        });
        mapper.registerModule(module);
        reader = mapper.readerFor(RelativeTimeFormatterData.class);
        writer = mapper.writerFor(RelativeTimeFormatterData.class);
    }

    private static ObjectReader getObjectReader() {
        if (reader == null) instantiateMapper();
        return reader;
    }

    private static ObjectWriter getObjectWriter() {
        if (writer == null) instantiateMapper();
        return writer;
    }
}

// RelativeTimeFormatterData.java

package com.apiverve.relativetimeformatter.data;

import com.fasterxml.jackson.annotation.*;
import java.time.OffsetDateTime;

public class RelativeTimeFormatterData {
    private OffsetDateTime targetDate;
    private OffsetDateTime referenceDate;
    private String relativeTime;
    private boolean isPast;
    private boolean isFuture;
    private long differenceMS;
    private String primaryUnit;
    private long primaryValue;
    private AllUnits allUnits;
    private String style;

    @JsonProperty("target_date")
    public OffsetDateTime getTargetDate() { return targetDate; }
    @JsonProperty("target_date")
    public void setTargetDate(OffsetDateTime value) { this.targetDate = value; }

    @JsonProperty("reference_date")
    public OffsetDateTime getReferenceDate() { return referenceDate; }
    @JsonProperty("reference_date")
    public void setReferenceDate(OffsetDateTime value) { this.referenceDate = value; }

    @JsonProperty("relative_time")
    public String getRelativeTime() { return relativeTime; }
    @JsonProperty("relative_time")
    public void setRelativeTime(String value) { this.relativeTime = value; }

    @JsonProperty("is_past")
    public boolean getIsPast() { return isPast; }
    @JsonProperty("is_past")
    public void setIsPast(boolean value) { this.isPast = value; }

    @JsonProperty("is_future")
    public boolean getIsFuture() { return isFuture; }
    @JsonProperty("is_future")
    public void setIsFuture(boolean value) { this.isFuture = value; }

    @JsonProperty("difference_ms")
    public long getDifferenceMS() { return differenceMS; }
    @JsonProperty("difference_ms")
    public void setDifferenceMS(long value) { this.differenceMS = value; }

    @JsonProperty("primary_unit")
    public String getPrimaryUnit() { return primaryUnit; }
    @JsonProperty("primary_unit")
    public void setPrimaryUnit(String value) { this.primaryUnit = value; }

    @JsonProperty("primary_value")
    public long getPrimaryValue() { return primaryValue; }
    @JsonProperty("primary_value")
    public void setPrimaryValue(long value) { this.primaryValue = value; }

    @JsonProperty("all_units")
    public AllUnits getAllUnits() { return allUnits; }
    @JsonProperty("all_units")
    public void setAllUnits(AllUnits value) { this.allUnits = value; }

    @JsonProperty("style")
    public String getStyle() { return style; }
    @JsonProperty("style")
    public void setStyle(String value) { this.style = value; }
}

// AllUnits.java

package com.apiverve.relativetimeformatter.data;

import com.fasterxml.jackson.annotation.*;

public class AllUnits {
    private long years;
    private long months;
    private long weeks;
    private long days;
    private long hours;
    private long minutes;
    private long seconds;
    private long milliseconds;

    @JsonProperty("years")
    public long getYears() { return years; }
    @JsonProperty("years")
    public void setYears(long value) { this.years = value; }

    @JsonProperty("months")
    public long getMonths() { return months; }
    @JsonProperty("months")
    public void setMonths(long value) { this.months = value; }

    @JsonProperty("weeks")
    public long getWeeks() { return weeks; }
    @JsonProperty("weeks")
    public void setWeeks(long value) { this.weeks = value; }

    @JsonProperty("days")
    public long getDays() { return days; }
    @JsonProperty("days")
    public void setDays(long value) { this.days = value; }

    @JsonProperty("hours")
    public long getHours() { return hours; }
    @JsonProperty("hours")
    public void setHours(long value) { this.hours = value; }

    @JsonProperty("minutes")
    public long getMinutes() { return minutes; }
    @JsonProperty("minutes")
    public void setMinutes(long value) { this.minutes = value; }

    @JsonProperty("seconds")
    public long getSeconds() { return seconds; }
    @JsonProperty("seconds")
    public void setSeconds(long value) { this.seconds = value; }

    @JsonProperty("milliseconds")
    public long getMilliseconds() { return milliseconds; }
    @JsonProperty("milliseconds")
    public void setMilliseconds(long value) { this.milliseconds = value; }
}