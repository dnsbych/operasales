package ru.learnup.vtb.operasales.services.loggers;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import ru.learnup.vtb.operasales.services.interfaces.Logger;

@Component
@Profile("Email")
public class EmailLogger implements Logger {
    @Override
    public void print(Object object) {
        System.out.println("Отправка на email: " + object);
    }
}
