package com.example.main;

import com.example.beans.Vehicle;
import com.example.config.ProjectConfig;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Random;
import java.util.function.Supplier;

public class Example7 {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        /*
        * Sometimes we want to create new instances of an object and add them into the Spring context
        * based on a programming condition.
        * For the same, from Spring 5 version,
        * a new approach is provided to create the beans programmatically
        * by invoking the register Bean() method present inside the context object.
        * */
        Vehicle volkswagen = new Vehicle();
        volkswagen.setName("Volkswagen");
        Supplier<Vehicle> volkswagenSupplier = () -> volkswagen;


        Supplier<Vehicle> audiSupplier = () -> {
            Vehicle audi = new Vehicle();
            audi.setName("Audi");
            return audi;
        };

        Random random = new Random();
        int randomNumber = random.nextInt(10);
        System.out.println("randomNumber = " + randomNumber);

        if((randomNumber% 2) == 0){
            context.registerBean("volkswagen",
                    Vehicle.class,volkswagenSupplier);
        }else{
            context.registerBean("audi",
                    Vehicle.class,audiSupplier);
        }
        Vehicle volksVehicle = null;
        Vehicle audiVehicle = null;
        try {
            volksVehicle = context.getBean("volkswagen",Vehicle.class);
        }catch (NoSuchBeanDefinitionException noSuchBeanDefinitionException){
            System.out.println("Error while creating Volkswagen vehicle");
        }
        try {
            audiVehicle = context.getBean("audi",Vehicle.class);
        }catch (NoSuchBeanDefinitionException noSuchBeanDefinitionException){
            System.out.println("Error while creating Audi vehicle");
        }

        if(null != volksVehicle){
            System.out.println("Programming Vehicle name from Spring Context is: " + volksVehicle.getName());
        }else{
            System.out.println("Programming Vehicle name from Spring Context is: " + audiVehicle.getName());
        }

    }
}
