package com.imarchuang.spring.event;

import com.imarchuang.spring.event.source.User;
import org.springframework.beans.propertyeditors.StringArrayPropertyEditor;
import org.springframework.context.ApplicationEvent;

/**
 * Created by mhuang on 8/31/2016.
 */
public class CustomizedEvent {

    private final User user;
    private final boolean important;

    public CustomizedEvent(User user) {
        this(user, false);
    }
    public CustomizedEvent(User user, boolean important) {
        this.user = user;
        this.important = important;
    }

    public User getUser() {
        return user;
    }

    public boolean isImportant() {
        return important;
    }
}