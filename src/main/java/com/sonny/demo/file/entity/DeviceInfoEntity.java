/*******************************************************************
 * Copyright  (C) Newegg Corporation. All rights reserved.
 *
 * Author: Sonny Shih (sonny.h.shih@newegg.com)
 * Create Date: 2019/03/22
 * Usage:
 *
 * RevisionHistory
 * Date    Author    Description
 *
 ********************************************************************/
package com.sonny.demo.file.entity;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class DeviceInfoEntity implements Serializable {

    @SerializedName("CapabilityName")
    private String capabilityName;

    @SerializedName("PlatformName")
    private String platformName;

    @SerializedName("PlatformVersion")
    private String platformVersion;

    @SerializedName("AutomationName")
    private String automationName;

    @SerializedName("DeviceName")
    private String deviceName;

    @SerializedName("AppPackage")
    private String appPackage;

    @SerializedName("AppActivity")
    private String appActivity;

    @SerializedName("UDID")
    private String udid;

    @SerializedName("BundleId")
    private String bundleId;

    @SerializedName("XcodeOrgId")
    private String xcodeOrgId;

    @SerializedName("XcodeSigningId")
    private String xcodeSigningId;

    public String getCapabilityName() {
        return capabilityName;
    }

    public void setCapabilityName(String capabilityName) {
        this.capabilityName = capabilityName;
    }

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    public String getPlatformVersion() {
        return platformVersion;
    }

    public void setPlatformVersion(String platformVersion) {
        this.platformVersion = platformVersion;
    }

    public String getAutomationName() {
        return automationName;
    }

    public void setAutomationName(String automationName) {
        this.automationName = automationName;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getAppPackage() {
        return appPackage;
    }

    public void setAppPackage(String appPackage) {
        this.appPackage = appPackage;
    }

    public String getAppActivity() {
        return appActivity;
    }

    public void setAppActivity(String appActivity) {
        this.appActivity = appActivity;
    }

    public String getUdid() {
        return udid;
    }

    public void setUdid(String udid) {
        this.udid = udid;
    }

    public String getBundleId() {
        return bundleId;
    }

    public void setBundleId(String bundleId) {
        this.bundleId = bundleId;
    }

    public String getXcodeOrgId() {
        return xcodeOrgId;
    }

    public void setXcodeOrgId(String xcodeOrgId) {
        this.xcodeOrgId = xcodeOrgId;
    }

    public String getXcodeSigningId() {
        return xcodeSigningId;
    }

    public void setXcodeSigningId(String xcodeSigningId) {
        this.xcodeSigningId = xcodeSigningId;
    }
}
