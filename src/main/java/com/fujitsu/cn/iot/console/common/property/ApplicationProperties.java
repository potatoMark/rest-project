package com.fujitsu.cn.iot.console.common.property;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by mark on 2017/4/18.
 */

@Component
public class ApplicationProperties {

    @Value("${session.timout}")
    private long sessionTimeout;

    public long getSessionTimeout() {
        return sessionTimeout;
    }

    public void setSessionTimeout(long sessionTimeout) {
        this.sessionTimeout = sessionTimeout;
    }
}
