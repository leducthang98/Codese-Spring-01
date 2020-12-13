package com.example.SpringBeginner;

import com.example.SpringBeginner.Controller.DemoController;
import com.example.SpringBeginner.Model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.HashMap;

@SpringBootApplication
public class SpringBeginnerApplication {



    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringBeginnerApplication.class, args);

        //DemoController demoController = store.getBean(DemoController.class);

        Book book = (Book) context.getBean(Book.class);
        book.name = "sach A";
        System.out.println(book.name);

//        Student student = (Student) context.getBean(Student.class);
//        student.setName("Thang");
//        System.out.println(student.getName());

        Girl uniGirl = new Girl(new Uniform()); // loosly coupled
        Girl bikiniGirl = new Girl(new Bikini());

        // @Component @Bean @Service
        // IoC
        // DI
    }

}
