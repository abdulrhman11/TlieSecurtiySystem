package saud.abdulrhman.tliesecurtiysystem;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by PCD on 11/16/2017.
 */

public class arteList implements Parcelable {

    private String alert;
    private String time;

    public arteList(String head, String time) {
        this.alert = head;
        this.time = time;
    }


    protected arteList(Parcel in) {
        alert = in.readString();
        time = in.readString();
    }

    public static final Creator<arteList> CREATOR = new Creator<arteList>() {
        @Override
        public arteList createFromParcel(Parcel in) {
            return new arteList(in);
        }

        @Override
        public arteList[] newArray(int size) {
            return new arteList[size];
        }
    };

    public String getHead() {
        return alert;
    }

    public String getTime() {
        return time;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(alert);
        dest.writeString(time);
    }
}
