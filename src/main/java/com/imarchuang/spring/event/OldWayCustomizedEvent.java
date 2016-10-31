package com.imarchuang.spring.event;

import com.imarchuang.spring.event.source.User;
import org.springframework.context.ApplicationEvent;

/**
 * Created by mhuang on 8/31/2016.
 */
public class OldWayCustomizedEvent extends ApplicationEvent {

    public OldWayCustomizedEvent(User user) {
        super(user);
    }

    public User getUser() {
        return (User)getSource();
    }
}