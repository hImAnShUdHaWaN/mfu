package com.mfu.domain.funds;

/**
 * Created by himanshu dhawan on 05-05-2018.
 */
public enum SchemeType {

    OPEN_ENDED("Open Ended"),
    CLOSE_ENDED("Close Ended"),
    INTERVAL_FUND("Interval Fund");

    private String name;

    SchemeType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static SchemeType contains(String test) {
        for (SchemeType c : SchemeType.values()) {
            if (c.getName().equals(test)) {
                return c;
            }
        }
        return null;
    }
}
