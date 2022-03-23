package ru.learnup.vtb.operasales.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import ru.learnup.vtb.operasales.model.User;
import ru.learnup.vtb.operasales.repository.interfaces.UserRepository;

@Component
public class MyUserService implements UserDetailsService {

    private UserRepository repository;

    @Autowired
    public MyUserService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User byLogin = repository.findByLogin(username);
        if(byLogin == null){
            throw new UsernameNotFoundException("Не найден пользователь");
        }

        return byLogin;
    }
}
