package com.fujitsu.cn.iot.console.common.property;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Created by mark on 2017/4/18.
 */

@Component
//加载外部配置文件
//@Configuration
//@PropertySource("classpath:iotconsole.yml")
@ConfigurationProperties(prefix = "mqtt")
public class MqttProperties {

    //@Value("${mqtt.url}")
    private String url;

    //@Value("${mqtt.user}")
    private String user;

    //@Value("${mqtt.password}")
    private String password;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
