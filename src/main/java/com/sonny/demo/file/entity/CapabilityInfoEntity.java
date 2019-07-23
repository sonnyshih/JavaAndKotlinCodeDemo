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
import java.util.List;

public class CapabilityInfoEntity implements Serializable {

    @SerializedName("CapabilityInfo")
    private List<DeviceInfoEntity> capabilityInfoList;

    public List<DeviceInfoEntity> getCapabilityInfoList() {
        return capabilityInfoList;
    }

    public void setCapabilityInfoList(List<DeviceInfoEntity> capabilityInfoList) {
        this.capabilityInfoList = capabilityInfoList;
    }
}
