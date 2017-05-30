package com.fujitsu.cn.iot.console.service.device.service;

import com.fujitsu.cn.iot.console.service.device.dao.DeviceDao;
import com.fujitsu.cn.iot.console.service.device.entity.Device;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yule on 2017/3/27.
 *
 * Create your own logic here
 */
@Service
public class DeviceService {
    private static final Logger LOG = LoggerFactory.getLogger(DeviceService.class);

    @Autowired
    DeviceDao deviceDao;

    public List<Device> getDeviceList() {
        return deviceDao.findAllDevices();
    }

    public Device getDevice(String id) {
        if (!id.matches("\\d+")) {
            LOG.error("id is not digit");
            return new Device();
        }

        return deviceDao.findDeviceById(id);
    }

}
