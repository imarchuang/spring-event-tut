package com.imarchuang.spring.event;

import org.springframework.context.ApplicationListener;

/**
 * Created by mhuang on 8/31/2016.
 */
public class OldWayCustomizedEventListener implements ApplicationListener<OldWayCustomizedEvent> {

    public void onApplicationEvent(OldWayCustomizedEvent oldWayCustomizedEvent) {
        System.out.println(Thread.currentThread()+"~~~"+this.getClass().getSimpleName()+"~~~"+oldWayCustomizedEvent.getUser().toString());
    }
}
