package com.mfu.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

/**
 * Created by himanshu dhawan on 01-05-2018.
 */
@Component
public class AMFIScheduledTask {

    private final Logger log = LoggerFactory.getLogger(AMFIScheduledTask.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 25000)
    public void getCurrentData() {
    }
}
