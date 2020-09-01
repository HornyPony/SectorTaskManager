package com.example.sectortaskmanager.Intro;

import android.os.Parcel;
import android.os.Parcelable;

public class IntroItem implements Parcelable {
    private int guideImage;
    private String guideDescription;

    public IntroItem(int guideImage, String guideDescription) {
        this.guideImage = guideImage;
        this.guideDescription = guideDescription;
    }

    public int getGuideImage() {
        return guideImage;
    }

    public void setGuideImage(int guideImage) {
        this.guideImage = guideImage;
    }

    public String getGuideDescription() {
        return guideDescription;
    }

    public void setGuideDescription(String guideDescription) {
        this.guideDescription = guideDescription;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

    }
}
