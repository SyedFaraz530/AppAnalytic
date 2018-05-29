package com.appanalytic.faraz.appanalytic.bean;

public class ScreenViewBean {
    private String id;
    private String OpenTime;
    private String CloseTime;
    private String AddedOn;
    private String ScreenName;
    private String AppVersion;
    private String TimeSpent;
    private String AppUser;

    public String getAppUser() {
        return AppUser;
    }

    public void setAppUser(String appUser) {
        AppUser = appUser;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOpenTime() {
        return OpenTime;
    }

    public void setOpenTime(String openTime) {
        OpenTime = openTime;
    }

    public String getCloseTime() {
        return CloseTime;
    }

    public void setCloseTime(String closeTime) {
        CloseTime = closeTime;
    }

    public String getAddedOn() {
        return AddedOn;
    }

    public void setAddedOn(String addedOn) {
        AddedOn = addedOn;
    }

    public String getScreenName() {
        return ScreenName;
    }

    public void setScreenName(String screenName) {
        ScreenName = screenName;
    }

    public String getAppVersion() {
        return AppVersion;
    }

    public void setAppVersion(String appVersion) {
        AppVersion = appVersion;
    }

    public String getTimeSpent() {
        return TimeSpent;
    }

    public void setTimeSpent(String TImeSpent) {
        this.TimeSpent = TImeSpent;
    }
}
