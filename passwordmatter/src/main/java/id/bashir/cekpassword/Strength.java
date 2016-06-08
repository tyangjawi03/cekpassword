package id.bashir.cekpassword;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Bashir on 08/06/2016.
 */
public class Strength implements Parcelable {

    private int strength;
    private String Description;

    public Strength() {
    }

    public Strength(int strength, String description) {
        this.strength = strength;
        Description = description;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.strength);
        dest.writeString(this.Description);
    }

    protected Strength(Parcel in) {
        this.strength = in.readInt();
        this.Description = in.readString();
    }

    public static final Parcelable.Creator<Strength> CREATOR = new Parcelable.Creator<Strength>() {
        @Override
        public Strength createFromParcel(Parcel source) {
            return new Strength(source);
        }

        @Override
        public Strength[] newArray(int size) {
            return new Strength[size];
        }
    };
}
