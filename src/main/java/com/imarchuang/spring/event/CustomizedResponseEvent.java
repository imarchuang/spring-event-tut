package com.imarchuang.spring.event;

import com.imarchuang.spring.event.source.User;

/**
 * Created by mhuang on 8/31/2016.
 */
public class CustomizedResponseEvent {

    private final User user;
    private final Status status;


    public CustomizedResponseEvent(User user, Status status) {
        this.user = user;
        this.status = status;
    }

    public enum Status {
        OK,
        FAIL,
        NOT_FOUND
    }

    public User getUser() {
        return user;
    }

    public Status getStatus() {
        return status;
    }
}
