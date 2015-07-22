package model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SleepyLee on 7/22/15.
 */
public class Survey implements Parcelable{
    private String mId;
    private String mName;
    private String mDescription;
    private String mImageUrl;

    public Survey() {
    }

    public static List<Survey> getTestSurveyList(){
        //For testing:
        List<Survey> result = new ArrayList<>();
        result.add(new Survey("123","Bangkok", "Here is in Bangkok", "https://dhdbhh0jsld0o.cloudfront.net/m/b10685ce58b89ecbeef2_"));
        result.add(new Survey("123","Kuala Lumpur", "Here is in Malaysia", "https://dhdbhh0jsld0o.cloudfront.net/m/c806ddde8a6b5568d8b0_"));
        result.add(new Survey("123","Ha Noi", "Here is in Viet Nam", "https://dhdbhh0jsld0o.cloudfront.net/m/46a221353a05dea53407_"));
        result.add(new Survey("123","Saigon", "Here is in Viet Nam", "https://dhdbhh0jsld0o.cloudfront.net/m/180eb37474277c7b2625_"));
        return result;

    }

    public Survey(String mId, String mName, String mDescription, String mImageUrl) {
        this.mId = mId;
        this.mName = mName;
        this.mDescription = mDescription;
        this.mImageUrl = mImageUrl;
    }

    public String getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }

    public String getDescription() {
        return mDescription;
    }

    public String getImageUrl() {
        return mImageUrl;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mId);
        dest.writeString(mName);
        dest.writeString(mDescription);
        dest.writeString(mImageUrl);
    }

    private Survey(Parcel in){
        this.mId = in.readString();
        this.mName = in.readString();
        this.mDescription = in.readString();
        this.mImageUrl = in.readString();
    }

    @Override
    public String toString() {
        return "Survey{" +
                "mId='" + mId + '\'' +
                ", mName='" + mName + '\'' +
                ", mDescription='" + mDescription + '\'' +
                ", mImageUrl='" + mImageUrl + '\'' +
                '}';
    }
}
