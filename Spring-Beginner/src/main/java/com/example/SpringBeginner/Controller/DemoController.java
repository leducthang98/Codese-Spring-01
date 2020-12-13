package com.example.SpringBeginner.Controller;

import com.example.SpringBeginner.Model.Book;
import com.example.SpringBeginner.Model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    Book b1;

    @GetMapping("/hello-world")
    public String helloWorld() {
        return "Hello world";
    }

    @GetMapping("/demo-return-ints")
    public int demoReturnInt() {
        return 1;
    }

    @GetMapping("demo-get-student")
    public Student getStudent() {
        Student student = new Student("Le Duc Thang", 22);
        return student;
    }

    @GetMapping("demo-api-with-param")
    public String demoApiWithParam(@RequestParam String param) {
        return "Param ban truyen vao la: " + param;
    }

    @GetMapping("demo-hash-map")
    public HashMap<String, Object> demoHashMap() {
        HashMap<String, Object> returnValue = new HashMap<>();
        returnValue.put("name", "Le Duc Thang");
        returnValue.put("age", 22);
        returnValue.put("isMale", true);
        return returnValue;
    }

    @GetMapping("demo-DI")
    public Book demoDI(){
        b1.name = "DI";
        return b1;
    }

}
