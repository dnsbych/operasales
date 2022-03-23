package ru.learnup.vtb.operasales.security;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

//@Component
public class MyAuthProvider implements AuthenticationProvider {

    private Map<String, String> users = new HashMap<>();

    @PostConstruct
    public void init(){
        users.put("user", "user123");
        users.put("admin", "admin");
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String login = authentication.getName();
        String password = String.valueOf(authentication.getCredentials());

        String passwordInDb = users.get(login);
        if(password.equals(passwordInDb)){
            Collection<SimpleGrantedAuthority> roles = new ArrayList<SimpleGrantedAuthority>(){{
                add(new SimpleGrantedAuthority("ROLE_USER"));
                add(new SimpleGrantedAuthority("ROLE_ADMIN"));
            }};

            return new UsernamePasswordAuthenticationToken(login, password, roles);
        }
        else{
            throw new BadCredentialsException("Incorrect Credentials");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }
}
