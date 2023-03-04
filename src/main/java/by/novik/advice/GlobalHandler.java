package by.novik.advice;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.NoSuchElementException;

@Slf4j

@ControllerAdvice
public class GlobalHandler {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoSuchElementException.class)
    public String handleException(HttpServletRequest request, Exception ex) {
        log.info("We have found the error: {} using URI {}, URL {}",ex.getMessage(),

                request.getRequestURI(),request.getRequestURL().toString());
        return "errors.jsp";
    }
}
