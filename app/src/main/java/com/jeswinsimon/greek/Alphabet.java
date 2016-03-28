package com.jeswinsimon.greek;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by jeswinsimon on 27/03/16.
 */
public class Alphabet implements Parcelable {

    public String name = "Undefined";
    public String uppercase = "Undefined";
    public String lowercase = "Undefined";
    public String description = "Undefined";

    public Alphabet(String name, String uppercase, String lowercase, String description) {
        this.name = name;
        this.uppercase = uppercase;
        this.lowercase = lowercase;
        this.description = description;
    }

    public Alphabet(Parcel parcel){
        this.name = parcel.readString();
        this.uppercase = parcel.readString();
        this.lowercase = parcel.readString();
        this.description = parcel.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.uppercase);
        dest.writeString(this.lowercase);
        dest.writeString(this.description);
    }

    public static Parcelable.Creator<Alphabet> CREATOR = new Parcelable.Creator<Alphabet>() {
        public Alphabet createFromParcel(Parcel source){
            return new Alphabet(source);
        }
        public Alphabet[] newArray(int size) {
            return new Alphabet[size];
        }
    };

    //For generating test data only!
    public static ArrayList<Alphabet> getAlphabets() {
        ArrayList<Alphabet> alphabets = new ArrayList<Alphabet>();

        alphabets.add(new Alphabet("Alpha", "A", "a", "First Alphabet"));
        alphabets.add(new Alphabet("Beta", "B", "b", "Second Alphabet"));

        return alphabets;
    }
}
