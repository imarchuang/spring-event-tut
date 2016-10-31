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
@Component
public class CustomizedEventPublisher
        //implements ApplicationContextAware
{
    private final ApplicationEventPublisher publisher;

    @Autowired
    public CustomizedEventPublisher(ApplicationEventPublisher publisher){
        this.publisher = publisher;
    }

    public void createUser(User user) {
        this.publisher.publishEvent(new CustomizedEvent(user));
    }
}
