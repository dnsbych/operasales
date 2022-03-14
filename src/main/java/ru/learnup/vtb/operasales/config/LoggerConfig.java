package ru.learnup.vtb.operasales.config;

import org.springframework.context.annotation.Bean;
import ru.learnup.vtb.operasales.services.loggers.ConsoleLogger;
import ru.learnup.vtb.operasales.services.interfaces.Logger;

//@Configuration
public class LoggerConfig {
    @Bean
    public Logger logger() {
        return new ConsoleLogger();
    }
}
