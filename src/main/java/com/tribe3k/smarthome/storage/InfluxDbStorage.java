package com.tribe3k.smarthome.storage;

import org.influxdb.BatchOptions;
import org.influxdb.InfluxDB;
import org.influxdb.InfluxDBFactory;
import org.springframework.stereotype.Service;

@Service
public class InfluxDbStorage {
    private final InfluxDbProperties influxDbProperties;

    public InfluxDbStorage(InfluxDbProperties influxDbProperties) {
        this.influxDbProperties = influxDbProperties;
        InfluxDB influxDB = InfluxDBFactory.connect(influxDbProperties.getUrl(), influxDbProperties.getUsername(), influxDbProperties.getPassword());
        influxDB.createDatabase(influxDbProperties.getDbName());
        influxDB.setDatabase(influxDbProperties.getDbName());
        String rpName = "aRetentionPolicy";
        influxDB.createRetentionPolicy(rpName, influxDbProperties.getDbName(), "30d", "30m", 2, true);
        influxDB.setRetentionPolicy(rpName);

        influxDB.enableBatch(BatchOptions.DEFAULTS);

//        influxDB.write(Point.measurement("cpu")
//                               .time(System.currentTimeMillis(), TimeUnit.MILLISECONDS)
//                               .addField("idle", 90L)
//                               .addField("user", 9L)
//                               .addField("system", 1L)
//                               .build());
    }
}
