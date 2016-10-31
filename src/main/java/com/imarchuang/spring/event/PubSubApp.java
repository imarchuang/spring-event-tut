package com.imarchuang.spring.event;

import com.imarchuang.spring.event.source.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class PubSubApp
{
    public static void main( String[] args )
    {

        AnnotationConfigApplicationContext annotationConfigApplicationContext = null;
        ClassPathXmlApplicationContext xmlContext = null;

        try{
            annotationConfigApplicationContext = new AnnotationConfigApplicationContext(PubSubAppConfig.class);
            System.out.println(Arrays.toString(annotationConfigApplicationContext.getBeanDefinitionNames()));

            CustomizedEventPublisher publisher = (CustomizedEventPublisher) annotationConfigApplicationContext.getBean("customizedEventPublisher");

            publisher.createUser(new User(1, "Dummy", "Dummy"));



            xmlContext  = new ClassPathXmlApplicationContext("META-INF/applicationContext.xml");

            System.out.println(Arrays.toString(xmlContext.getBeanDefinitionNames()));

            OldWayCustomizedEventPublisher oldwayPublisher = (OldWayCustomizedEventPublisher) xmlContext.getBean("oldEventPublisher");

            oldwayPublisher.createUser(new User(2, "Dummy2", "Dummy2"));
        } catch (Exception e){

        } finally {

            annotationConfigApplicationContext.close();
            xmlContext.close();

        }


    }
}
