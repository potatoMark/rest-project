package com.fujitsu.cn.iot.console.controller;

import com.fujitsu.cn.iot.console.service.device.entity.Device;
import com.fujitsu.cn.iot.console.service.device.service.DeviceService;
import com.fujitsu.cn.iot.console.common.property.MqttProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by yule on 2017/3/24.
 *
 * Focus on request and response,
 * but leave the stuff to service.
 */
@RestController
@RequestMapping(value = "/example")
public class ExampleController {

    @Autowired
    DeviceService deviceService;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    MqttProperties mqttProperties;

    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping(value = "/hello")
    public String sayHello() {

        try{

//            Rest API
//            String s = restTemplate.getForObject("http://localhost:8080/config/opcclient/Meter/meters?Page=0&Num=1", String.class);

            redisTemplate.opsForValue();

            System.out.println("STEP-4");
            System.out.println(mqttProperties.getUrl());


        }catch (Exception e){
            e.printStackTrace();
        }

        return "Hello, world";
    }

    @RequestMapping(value = "/devices", method = RequestMethod.GET)
    public List<Device> getDeviceList() {
        return deviceService.getDeviceList();
    }

    @RequestMapping(value = "/devices/{id}", method = RequestMethod.GET)
    public Device getDevice(@PathVariable("id") String id) {
        
        return deviceService.getDevice(id);
    }

}
