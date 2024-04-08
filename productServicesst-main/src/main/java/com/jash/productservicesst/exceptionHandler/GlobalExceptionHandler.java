package com.jash.productservicesst.exceptionHandler;

import com.jash.productservicesst.dtos.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<ExceptionDto> handleArithmeticException(){
        ExceptionDto dto = new ExceptionDto();
        dto.setMessage("Something went wrong");
        dto.setResolution("ArithmeticException");
        ResponseEntity<ExceptionDto> response = new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
        return response;
    }

    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    public ResponseEntity<ExceptionDto> handleArrayIndexOutOfBondsException(){
        ExceptionDto dto = new ExceptionDto();
        dto.setMessage("Something went wrong");
        dto.setResolution("ArrayIndexOutOfBoundsException");
        ResponseEntity<ExceptionDto> response = new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
        return response;
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionDto> handleGeneralException(){
        ExceptionDto dto = new ExceptionDto();
        dto.setMessage("Something went wrong");
        dto.setResolution("General Exception");
        ResponseEntity<ExceptionDto> response = new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
        return response;
    }
}
