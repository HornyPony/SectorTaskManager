package com.example.sectortaskmanager.Intro;

public class IntroItem {
    private int guideImage;
    private String slideNumber;
    private String guideDescription;

    public IntroItem(int guideImage, String slideNumber, String guideDescription) {
        this.guideImage = guideImage;
        this.slideNumber = slideNumber;
        this.guideDescription = guideDescription;
    }

    public int getGuideImage() {
        return guideImage;
    }

    public void setGuideImage(int guideImage) {
        this.guideImage = guideImage;
    }

    public String getSlideNumber() {
        return slideNumber;
    }

    public void setSlideNumber(String slideNumber) {
        this.slideNumber = slideNumber;
    }

    public String getGuideDescription() {
        return guideDescription;
    }

    public void setGuideDescription(String guideDescription) {
        this.guideDescription = guideDescription;
    }
}
