package com.ethermiu.enrolmentmanagement.service.impl;

import com.ethermiu.enrolmentmanagement.domain.Person;
import com.ethermiu.enrolmentmanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
       Optional<Person> user = userRepository.findByUsername(userName);
        user.orElseThrow(()-> new UsernameNotFoundException("Not Found " +userName ));
        return user.map(MyUserDetails::new).get();

/*       return new User("admin","admin", new ArrayList<>());*/
    }
}
