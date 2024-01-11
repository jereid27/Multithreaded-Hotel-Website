package edu.wgu.d387_sample_code;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class DisplayPresentation {

    public static String[] retrievePresentation(LocalDateTime futureDateTime) {

        List<String> timeZones = new ArrayList<>();

        ZoneId zEastern = ZoneId.of("America/New_York");
        ZoneId zMountain = ZoneId.of("America/Phoenix");
        ZoneId zUniversal = ZoneId.of("UTC");


        ZonedDateTime zonedDateTimeEastern = ZonedDateTime.of(futureDateTime, ZoneId.systemDefault()).withZoneSameInstant(zEastern);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        String formattedEastern = zonedDateTimeEastern.format(formatter);
        timeZones.add(formattedEastern);

        ZonedDateTime zonedDateTimeMountain = ZonedDateTime.of(futureDateTime, ZoneId.systemDefault()).withZoneSameInstant(zMountain);
        String formattedMountain = zonedDateTimeMountain.format(formatter);
        timeZones.add(formattedMountain);

        ZonedDateTime zonedDateTimeUniversal = ZonedDateTime.of(futureDateTime,  ZoneId.systemDefault()).withZoneSameInstant(zUniversal);
        String formattedUniversal = zonedDateTimeUniversal.format(formatter);
        timeZones.add(formattedUniversal);

        // Print the times for verification
        System.out.println("Eastern Time: " + formattedEastern);
        System.out.println("Mountain Time: " + formattedMountain);
        System.out.println("Universal Time: " + formattedUniversal);

        return timeZones.toArray(new String[3]);


    }
}
