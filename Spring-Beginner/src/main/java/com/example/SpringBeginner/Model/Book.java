package com.example.SpringBeginner.Model;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public class Book {
    public String name;

    @Bean
    public Student createBeanStudent(){
        Student beanStudent = new Student();
        beanStudent.setName("Thang");
        beanStudent.setAge(22);
        return beanStudent;
    }
}

// Book book = new Book => set context Spring