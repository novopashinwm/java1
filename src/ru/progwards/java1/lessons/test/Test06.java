package ru.progwards.java1.lessons.test;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

public class Test06 {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        System.out.println(Calendar.MONDAY);
        ZoneId zid1 = ZoneId.of("Europe/Moscow");
        System.out.println(zid1.getRules().getOffset(Instant.now()));
        Date date = new Date();
        //"2020-01-04T13:21:42.173042400Z".
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSSSSSS'Z'");
        System.out.println(format.format(date));

        LocalDateTime ldt2= LocalDateTime.of(2019, 05, 05, 22, 24);
        System.out.println(ldt2);
        Test06 t = new Test06();
        //System.out.println(t.createFolder("test1"));
        System.out.println(Paths.get("").toAbsolutePath());
    }

    String createFolder(String name) {
        File file = new File (name);
        file.mkdir();
        return Paths.get("").toAbsolutePath().getParent().toAbsolutePath().toString();
    }

    boolean replaceF(String name) {
        try {
            String line = Files.readString(Paths.get(name));
            line = line.replaceAll("F","f");
            Files.writeString(Paths.get(name), line);
        } catch (IOException e) {

            return false;
        }
        return true;
    }
}
