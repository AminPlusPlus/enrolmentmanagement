package com.ethermiu.enrolmentmanagement.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Qualifier("myUserDetailsService")
    @Autowired
    UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
        /*auth.jdbcAuthentication()
                .dataSource(dataSource);
        */        /*.withUser(

                        User.withUsername("user")
                        .password("pass")
                        .roles("USER")
                )
                .withUser(
                        User.withUsername("admin")
                        .password("admin")
                        .roles("ADMIN")
                );
*/


       /* auth.inMemoryAuthentication()
                .withUser("admin2")
                .password("admin2")
                .roles("ADMIN")
                .and()
                .withUser("student1")
                .password("student1")
                .roles("STUDENT")
                .and()
                .withUser("faculty1")
                .password("faculty1")
                .roles("FACULTY");*/
    }

    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/admin").hasRole("ADMIN")
                .antMatchers("/faculty").hasAnyRole("FACULTY","ADMIN")
                .antMatchers("/student").hasAnyRole("STUDENT","ADMIN")
                .antMatchers("/user").hasAnyRole("ADMIN","STUDENT","FACULTY","USER")
                .antMatchers("/").permitAll()
                .and().formLogin();
    }
}
