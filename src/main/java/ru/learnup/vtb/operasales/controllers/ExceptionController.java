package ru.learnup.vtb.operasales.controllers;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.learnup.vtb.operasales.controllers.dto.ExceptionDto;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler({
            Exception.class
    })
    @ResponseBody
    public ExceptionDto handler(Exception err){
        return new ExceptionDto(123, "Что то пошло не так", err.getMessage());
    }

}
