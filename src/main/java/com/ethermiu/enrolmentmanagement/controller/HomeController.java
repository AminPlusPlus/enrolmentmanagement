package com.ethermiu.enrolmentmanagement.controller;

import com.ethermiu.enrolmentmanagement.models.AuthenticationRequest;
import com.ethermiu.enrolmentmanagement.models.AuthenticationResponse;
import com.ethermiu.enrolmentmanagement.service.impl.MyUserDetailsService;
import com.ethermiu.enrolmentmanagement.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    JwtUtil jwtTokenUtil;

    @Autowired
    MyUserDetailsService userDetailsService;


    @GetMapping("/")
    public String home(){
        return ("<h1>Welcome to Enrollment Management</h1>");
    }

    @RequestMapping("/hello")
    public String hello(){
        return "Hello World";
    }

    @RequestMapping(value="/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception{

        try {

            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
        }
        catch (BadCredentialsException e){
            throw new Exception("Incorrect username or password", e);
        }

        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());

        final String jwt = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));

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
