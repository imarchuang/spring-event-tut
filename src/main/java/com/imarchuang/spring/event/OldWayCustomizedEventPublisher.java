package com.imarchuang.spring.event;

import com.imarchuang.spring.event.source.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

/**
 * Created by mhuang on 8/31/2016.
 */
public class OldWayCustomizedEventPublisher implements ApplicationContextAware {
    private ApplicationContext applicationContext;

    public void createUser(User user) {
        applicationContext.publishEvent(new OldWayCustomizedEvent(user));
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
