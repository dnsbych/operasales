package ru.learnup.vtb.operasales.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class NotifyAspect {

    @Pointcut("@annotation(ru.learnup.vtb.operasales.annotations.Notifiable)")
    public void notifyEmail() {
    }

    @After("notifyEmail()")
    public void after(JoinPoint point) {

        String msg = "Выполнен метод";
        String name = point.getSignature().getName();

        send("Выполнен метод " + name);
    }

    public void send(String msg) {
        System.out.println("Отправляем письмо на admin@test.com: " + msg);
    }
}
