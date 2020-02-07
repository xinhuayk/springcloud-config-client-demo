package com.example.springconfigclient.task;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyApplicationEvent extends ApplicationEvent {
    private ApplicationContext applicationContext;


    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public MyApplicationEvent(Object source,ApplicationContext applicationContext) {
        super(source);
        this.applicationContext= applicationContext;

    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext();

        applicationContext.addApplicationListener(new ApplicationListener<ApplicationEvent>() {
            @Override
            public void onApplicationEvent(ApplicationEvent event) {
                System.out.println(11151+""+event.getSource());
            }
        });
        applicationContext.refresh();
        applicationContext.publishEvent(new MyApplicationEvent("33",applicationContext));

    }
}
