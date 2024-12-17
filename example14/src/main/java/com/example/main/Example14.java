package com.example.main;

import com.example.config.ProjectConfig;
import com.example.services.VehicleServices;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Example14 {

    public static void main(String[] args) {
        /*
         * Singleton is the default scope of a bean in Spring.
         * In this scope, for a single bean we always get a same instance when you refer or autowire inside your application.
         * Unlike Singleton design pattern where we have only 1 instance in entire app,
         * inside Singleton scope Spring will make sure to have only 1 instance per unique bean.
         * For example, if you have multiple beans of same type,
         * then Spring Singleton scope will maintain 1 instance per each bean declared of same type
         * */
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        VehicleServices vehicleServices1 =context.getBean(VehicleServices.class);
        VehicleServices vehicleServices2 =context.getBean("vehicleServices",VehicleServices.class);
        System.out.println(vehicleServices1.hashCode());
        System.out.println(vehicleServices2.hashCode());
        System.out.println(vehicleServices1==vehicleServices2);
    }
}
