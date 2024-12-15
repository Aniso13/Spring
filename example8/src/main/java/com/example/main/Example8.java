package com.example.main;

import com.example.beans.Vehicle;
import com.example.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Example8 {
    public static void main(String[] args) {

        /*
        * In the initial versions of Spring, the bean and other configurations used to be done using XML.
        * But over the time, Spring team brings annotation based configurations to make developers life easy.
        * Today we can see XML configurations only in the older applications built based on initial versions of Spring.
        * It is good to understand on how to create a bean inside Spring context using XML style configurations.
        * So that, it will be useful if ever there is a scenario where you need to work in a project based on initial versions of Spring.
        * */

        var context = new ClassPathXmlApplicationContext("beans.xml");
        Vehicle vehicle = context.getBean(Vehicle.class);
        System.out.println("Vehicle name from Spring Context is: " + vehicle.getName());

    }
}
