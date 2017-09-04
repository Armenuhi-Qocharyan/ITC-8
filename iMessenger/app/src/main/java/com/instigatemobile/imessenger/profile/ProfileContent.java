package com.instigatemobile.imessenger.profile;


public class ProfileContent {
    private int count;
    private String elementName;
    private int imagePath;

    public ProfileContent(String elementName, int count, int imagePath) {
        this.elementName = elementName;
        this.count = count;
        this.imagePath = imagePath;
    }

    public int getCount() {
        return count;
    }

    public String getElementName() {
        return elementName;
    }

    public int getImagePath() {
        return imagePath;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setElementName(String elementName) {
        this.elementName = elementName;
    }

    public void setImagePath(int imagePath) {
        this.imagePath = imagePath;
    }
}
