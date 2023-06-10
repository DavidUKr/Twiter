package app.Twiter.advice;

import app.Twiter.advice.exception.DatabaseErrorException;
import app.Twiter.advice.exception.InvalidDataException;
import app.Twiter.advice.exception.PostNotFoundException;
import app.Twiter.advice.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;

@ControllerAdvice
public class UserAdvice {

    @ResponseBody
    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String userNotFoundHandler(UserNotFoundException e){
        return e.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(PostNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String postNotFoundHandler(PostNotFoundException e){
        return e.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(InvalidDataException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    String invalidDataHandler(InvalidDataException e){ return e.getMessage();}

    @ResponseBody
    @ExceptionHandler(DatabaseErrorException.class)
    @ResponseStatus(HttpStatus.BAD_GATEWAY)
    String databaseErrorHandler(DatabaseErrorException e){
        return e.getMessage();
    }
}
