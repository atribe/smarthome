package com.tribe3k.smarthome.storage;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "influxdb")
public class InfluxDbProperties {
    String dbName;
    String password;
    String url;
    String username;
}
