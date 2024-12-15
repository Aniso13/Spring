package com.example.main;

import com.example.beans.Vehicle;
import com.example.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Example4 {
    public static void main(String[] args) {
        /*
            When you have multiple beans of the same kind inside the Spring context,
            you can make one of them primary by using @Primary annotation. Primary bean is
            the one which Spring will choose if it has multiple options and you don’t specify a name.
            In other words, it is the default bean that Spring Context will consider in case of
            confusion due to multiple beans present of same type.
    * */
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        Vehicle vehicle = context.getBean(Vehicle.class);
        System.out.println("Primary Vehicle name from Spring Context is: " + vehicle.getName());


    }
}
