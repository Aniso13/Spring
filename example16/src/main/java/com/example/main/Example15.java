package com.example.main;

import com.example.beans.Person;
import com.example.beans.Vehicle;
import com.example.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Example15 {

    public static void main(String[] args) {


        /*
        * By default Spring will create all the singleton beans eagerly
        * during the startup of the application itself.
        * This is called Eager instantiation.
        * We can change the default behavior to initialize the singleton beans lazily
        * only when the application is trying to refer to the bean.
        * This approach is called Lazy instantiation.
        *
        * */
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        System.out.println("Before retrieving the Person bean from the Spring Context");
        Person person = context.getBean(Person.class);
        System.out.println("After retrieving the Person bean from the Spring Context");
    }
}
