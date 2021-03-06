package org.unibl.etf.pisio.trellofa.advices;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.unibl.etf.pisio.trellofa.exceptions.NotFoundException;

@ControllerAdvice
public class GlobalExceptionAdvice
{
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleNotFound()
    {

    }
}
