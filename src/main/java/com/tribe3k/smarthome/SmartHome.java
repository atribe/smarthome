package com.tribe3k.smarthome;

import com.tribe3k.smarthome.storage.InfluxDbStorage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SmartHome {
    private final InfluxDbStorage influxDbStorage;

    void start() {
        influxDbStorage.test();
    }
}
