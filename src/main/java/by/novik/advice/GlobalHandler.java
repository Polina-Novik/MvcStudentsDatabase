package by.novik.advice;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.NoSuchElementException;

@Slf4j
//способ глобально ловить все ошибки, сам попул
@ControllerAdvice
public class GlobalHandler { //перенесли сюда из user controller, здесь на ВСЕ ошибки
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoSuchElementException.class)
    public String handleException(HttpServletRequest request, Exception ex) {
        log.info("We have found the error: {} using URI {}, URL {}",ex.getMessage(),
                //URI короткий путь внутри прилож, URL полный путь для всех
                request.getRequestURI(),request.getRequestURL().toString()); //здесь ошибки по сути можно не показывать пометителяям сайта :)
        return "errors.jsp";
    }
}
