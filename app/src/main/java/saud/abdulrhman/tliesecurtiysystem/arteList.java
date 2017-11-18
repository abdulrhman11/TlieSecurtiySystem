package saud.abdulrhman.tliesecurtiysystem;

import java.sql.Time;

/**
 * Created by PCD on 11/16/2017.
 */

public class arteList {

    private static String alert;
    private  static String time;

    public arteList(String head, String time) {
        this.alert = head;
        this.time = time;
    }

    public arteList(){}

    public static String getHead() {
        return alert;
    }

    public static String getTime() {
        return time;
    }
}
