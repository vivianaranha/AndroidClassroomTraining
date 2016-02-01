package com.vivianaranha.yqlapp;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by vivianaranha on 1/24/16.
 */
public class Results implements Parcelable {
    String title;
    String address;
    String city;
    String state;
    String phone;
    double longitude;
    double latitude;
    String disance;
    String businessURL;


    public Results(String title, String address, String city, String state, String phone, double longitude, double latitude, String disance, String businessURL) {
        this.title = title;
        this.address = address;
        this.city = city;
        this.state = state;
        this.phone = phone;
        this.longitude = longitude;
        this.latitude = latitude;
        this.disance = disance;
        this.businessURL = businessURL;
    }

    protected Results(Parcel in) {
        title = in.readString();
        address = in.readString();
        city = in.readString();
        state = in.readString();
        phone = in.readString();
        longitude = in.readDouble();
        latitude = in.readDouble();
        disance = in.readString();
        businessURL = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(address);
        dest.writeString(city);
        dest.writeString(state);
        dest.writeString(phone);
        dest.writeDouble(longitude);
        dest.writeDouble(latitude);
        dest.writeString(disance);
        dest.writeString(businessURL);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Results> CREATOR = new Parcelable.Creator<Results>() {
        @Override
        public Results createFromParcel(Parcel in) {
            return new Results(in);
        }

        @Override
        public Results[] newArray(int size) {
            return new Results[size];
        }
    };
}
