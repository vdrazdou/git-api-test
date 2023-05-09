package org.space.vc.web.handler;

import lombok.extern.slf4j.Slf4j;
import org.space.vc.dto.ErrorMessageDto;
import org.space.vc.exception.IllegalFilterStateException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolationException;

@Slf4j
@ControllerAdvice
public class GlobalErrorHandler {

    @ResponseBody
    @ExceptionHandler(IllegalFilterStateException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorMessageDto handleIllegalPositionException(IllegalFilterStateException e) {
        log.error("IllegalFilterStateException exception handled", e);
        return new ErrorMessageDto(e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorMessageDto constraintViolationException(ConstraintViolationException e) {
        log.error("ConstraintViolationException exception handled", e);
        return new ErrorMessageDto(e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorMessageDto handleGlobalException(Exception e) {
        log.error("Global exception has occurred", e);
        return new ErrorMessageDto("Global exception has occurred");
    }
}
