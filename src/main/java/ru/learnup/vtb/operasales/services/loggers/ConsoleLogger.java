package ru.learnup.vtb.operasales.services.loggers;

import org.springframework.stereotype.Component;
import ru.learnup.vtb.operasales.services.interfaces.Logger;

@Component
public class ConsoleLogger implements Logger {
    @Override
    public void print(Object object) {
        System.out.println(object);
    }
}
