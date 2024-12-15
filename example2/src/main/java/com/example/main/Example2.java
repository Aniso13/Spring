package com.example.main;

import com.example.beans.Vehicle;
import com.example.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Example2 {
    public static void main(String[] args) {


        /*
        * When we create multiple objects of same type and try to fetch the bean from context by type,
        * then Spring cannot guess which instance you've declared you refer to.
        * This will lead to NoUnique BeanDefinitionException,
        * To avoid NoUnique BeanDefinitionException in these kind of scenarios,
        * we can fetch the bean from the context by mentioning it's name like shown below,
        * */
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        Vehicle veh1 = context.getBean("vehicle1" ,Vehicle.class);
        System.out.println(veh1.getName());

        Vehicle veh2 = context.getBean("vehicle1" ,Vehicle.class);
        System.out.println(veh2.getName());

        Vehicle veh3 = context.getBean("vehicle1" ,Vehicle.class);
        System.out.println(veh3.getName());

    }
}
