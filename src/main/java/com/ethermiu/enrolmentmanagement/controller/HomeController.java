package com.ethermiu.enrolmentmanagement.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home(){
        return ("<h1>Welcome to Enrollment Management</h1>");
    }

    @GetMapping("/admin")
    public String admin(){
        return ("<h1>Welcome Admin!</h1>");
    }

    @GetMapping("/user")
    public String user(){
        return ("<h1>Welcome user!</h1>");
    }

    @GetMapping("/student")
    public String student(){
        return ("<h1>Welcome student!</h1>");
    }


    @GetMapping("/faculty")
    public String faculty(){
        return ("<h1>Welcome Faculty!</h1>");
    }

}
