package com.fujitsu.cn.iot.console.service.device.entity;

/**
 * Created by yule on 2017/3/27.
 */
public class Device {
    private String deviceId;
    private String name;
    private String type;
    private Company owner;

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Company getOwner() {
        return owner;
    }

    public void setOwner(Company owner) {
        this.owner = owner;
    }

    /*
     * Implement method 'toString()' for debugging.
     */
    @Override
    public String toString() {
        return "Device{" +
                "name='" + name + '\'' +
                ", deviceId='" + deviceId + '\'' +
                ", type='" + type + '\'' +
                ", owner=" + owner +
                '}';
    }
}
