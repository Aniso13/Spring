package com.example.main;

import com.example.beans.Person;
import com.example.config.ProjectConfig;
import com.example.services.VehicleServices;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Example16 {

    public static void main(String[] args) {

        /*
        * With prototype scope, every time we request a reference of a bean,
        * Spring will create a new object instance and provide the same.
        * Prototype scope is rarely used inside the applications and we can use this scope only in the scenarios
        * where your bean will frequently change the state of the data
        * which will result race conditions inside multi thread environment.
        * Using prototype scope will not create any race conditions.
        * */
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        VehicleServices vehicleServices1 = context.getBean(VehicleServices.class);
        VehicleServices vehicleServices2 = context.getBean("vehicleServices", VehicleServices.class);
        System.out.println("Hashcode of the object vehicleServices1 : " + vehicleServices1.hashCode());
        System.out.println("Hashcode of the object vehicleServices2 : " + vehicleServices2.hashCode());
        if (vehicleServices1 == vehicleServices2) {
            System.out.println("VehicleServices bean is a singleton scoped bean");
        } else {
            System.out.println("VehicleServices bean is a prototype scoped bean");
        }
    }
}
