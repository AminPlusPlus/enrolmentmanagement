package com.ethermiu.enrolmentmanagement.config;

import com.ethermiu.enrolmentmanagement.filter.JwtFilter;
import com.ethermiu.enrolmentmanagement.service.impl.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.sql.DataSource;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Qualifier("myUserDetailsService")
    @Autowired
    MyUserDetailsService myUserDetailsService;

    @Autowired
    JwtFilter jwtRequestFilter;



    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailsService);
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


        http.csrf().disable()
                .authorizeRequests().antMatchers("/authenticate").permitAll()
                .antMatchers("/api/v1/courses").hasAnyRole("STUDENT","ADMIN")
                .antMatchers("/api/v1/offers").hasAnyRole("ADMIN","STUDENT")
                .antMatchers("api/v1/blocks").hasAnyRole("ADMIN","STUDENT","FACULTY")
                .anyRequest().authenticated()
                .and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);


       /*http.authorizeRequests()
                .antMatchers("/admin").hasRole("ADMIN")
                .antMatchers("/faculty").hasAnyRole("FACULTY","ADMIN")
                .antMatchers("/student").hasAnyRole("STUDENT","ADMIN")
                .antMatchers("/user").hasAnyRole("ADMIN","STUDENT","FACULTY","USER")
                .antMatchers("/").permitAll()
                .and().formLogin();
*/
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
