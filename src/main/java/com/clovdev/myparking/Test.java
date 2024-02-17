package com.clovdev.myparking;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Test {
    private static String getlocalDateTime(){
        String date;
        LocalDateTime localDateTime=LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy   HH:mm");
        date=localDateTime.format(formatter);


        return date;
    }
    public static void main(String[] args) {
        System.out.println(getlocalDateTime());
    }
}
