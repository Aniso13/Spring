package com.example.beans;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class Vehicle {

    private String name;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    /*
    * We have seen that when we are using stereotype annotations,
    * we don't have control while creating a bean.
    * But what if we want to execute some instructions post Spring creates the bean.
    * For the same, we can use @PostConstruct annotation.
    * We can define a method in the component class and annotate that method with @PostConstruct,
    * which instructs Spring to execute that method after it finishes creating the bean.
    * Spring borrows the @PostConstruct annotation from Java EE.
    * */
    @PostConstruct
    public void initialize(){
        this.name = "Honda";
    }

    /*
    * @PreDestory annotation can be used on top of the methods.
    * Spring will make sure to call this method just before clearing and destroying the context.
    * This can be used in the scenarios where we want to close any IO resources,
    * Database connections etc.
    * Spring borrows the @PreDestory annotation also from Java EE.
    * */
    @PreDestroy
    public void destroy() {
        System.out.println(
                "Destroying Vehicle Bean");
    }

    public void printHello() {
        System.out.println("Printing Hello from Component Vehicle Bean");
    }

}
