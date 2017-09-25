package com.example.a17231.book;

/**
 * Created by hasee on 2017/9/15.
 */

public class PersonalMessage {

    private String imageID;

    private String petName;

    private String id;

    private String university;

    public PersonalMessage(String imageID, String petName, String id, String university, String school, String major) {
        this.imageID = imageID;
        this.petName = petName;
        this.id = id;
        this.university = university;
        this.school = school;
        this.major = major;
    }

    private String school;

    private String major;

    public String getImageID() {
        return imageID;
    }

    public String getPetName() {
        return petName;
    }

    public String getId() {
        return id;
    }

    public String getUniversity() {
        return university;
    }

    public String getSchool() {
        return school;
    }

    public String getMajor() {
        return major;
    }

    public void setImageID(String imageID) {
        this.imageID = imageID;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public void setMajor(String major) {
        this.major = major;
    }
}
