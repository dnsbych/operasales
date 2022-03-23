package ru.learnup.vtb.operasales.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.learnup.vtb.operasales.security.MyAuthProvider;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

//    @Autowired
//    private MyAuthProvider authProvider;



    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //super.configure(http);
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/events").permitAll()
                .antMatchers(HttpMethod.POST,"/tickets").hasRole("USER")
                .antMatchers(HttpMethod.POST, "/events").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/events").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/events").hasRole("ADMIN")

                .and()
                .formLogin();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(10);
    }


//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.authenticationProvider(authProvider);
//    }
}
