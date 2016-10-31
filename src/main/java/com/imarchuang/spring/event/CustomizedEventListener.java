package com.imarchuang.spring.event;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * Created by mhuang on 8/31/2016.
 */
@Component
public class CustomizedEventListener
        //implements ApplicationContextAware
{
    //Annotation-driven event listener
    /**
     * Relaxed event type hierarchy
     * Historically ApplicationEventPublisher had only an ability to publish objects which inherited after ApplicationEvent.
     * Starting with Spring 4.2 the interface has been extended to support any object type.
     * In that case the object is wrapped in PayloadApplicationEvent and sent through.
     *
     * That change makes publishing events even easier. However, on the other hand without an internal conscientiousness
     * (e.g. with marker interface for all our domain events)
     * it can make event tracking even harder, especially in larger applications.
     * @param customizedEvent
     */
    @EventListener
    public void handleUserCreatedEvent(CustomizedEvent customizedEvent) {
        System.out.println("important="+customizedEvent.isImportant());
        System.out.println(Thread.currentThread()+"~~~"+this.getClass().getSimpleName()+"~~~"+customizedEvent.getUser().toString());
    }

    //Conditional event handling
    @EventListener(condition = "#customizedEvent.important")
    public void handleUserCreatedImportantEvent(CustomizedEvent customizedEvent) {
        System.out.println("important="+customizedEvent.isImportant());
        System.out.println(Thread.currentThread()+"~~~"+this.getClass().getSimpleName()+"~~~"+customizedEvent.getUser().toString());
    }

    //Asynchronous event processing
    @Async
    @EventListener
    public void handleUserCreatedEventAsync(CustomizedEvent customizedEvent) {
        System.out.println("important="+customizedEvent.isImportant());
        System.out.println(Thread.currentThread()+"~~~"+this.getClass().getSimpleName()+"~~~"+customizedEvent.getUser().toString());
    }

    //Publishing Events in Response To
    @EventListener
    public CustomizedResponseEvent blogModifiedWithResponse(CustomizedEvent customizedEvent) {
        //do whatever business logic needed here
        return new CustomizedResponseEvent(
                customizedEvent.getUser(), CustomizedResponseEvent.Status.OK);
    }

    @Async
    @EventListener
    public void handleCustomizedResponseEventAsync(CustomizedResponseEvent customizedResponseEvent) {
        System.out.println("status="+customizedResponseEvent.getStatus());
        System.out.println(Thread.currentThread()+"~~~"+this.getClass().getSimpleName()+"~~~"+"handleCustomizedResponseEventAsync"+"~~~"+customizedResponseEvent.getUser().toString());
    }

    //----------------------------Extra listeners for testing multicaster--------------------
    @Async
    @EventListener
    public void handleUserCreatedEventAsync2(CustomizedEvent customizedEvent) {
        System.out.println("important="+customizedEvent.isImportant());
        System.out.println(Thread.currentThread()+"~~~"+this.getClass().getSimpleName()+"~~~"+customizedEvent.getUser().toString());
    }

    @Async
    @EventListener
    public void handleUserCreatedEventAsync3(CustomizedEvent customizedEvent) {
        System.out.println("important="+customizedEvent.isImportant());
        System.out.println(Thread.currentThread()+"~~~"+this.getClass().getSimpleName()+"~~~"+customizedEvent.getUser().toString());
    }

    @Async
    @EventListener
    public void handleUserCreatedEventAsync4(CustomizedEvent customizedEvent) {
        System.out.println("important="+customizedEvent.isImportant());
        System.out.println(Thread.currentThread()+"~~~"+this.getClass().getSimpleName()+"~~~"+customizedEvent.getUser().toString());
    }

    @Async
    @EventListener
    public void handleUserCreatedEventAsync5(CustomizedEvent customizedEvent) {
        System.out.println("important="+customizedEvent.isImportant());
        System.out.println(Thread.currentThread()+"~~~"+this.getClass().getSimpleName()+"~~~"+customizedEvent.getUser().toString());
    }
}
