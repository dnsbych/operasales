package ru.learnup.vtb.operasales.repository.interfaces;

import ru.learnup.vtb.operasales.model.User;

public interface UserRepository {

    User findByLogin(String login);
}
