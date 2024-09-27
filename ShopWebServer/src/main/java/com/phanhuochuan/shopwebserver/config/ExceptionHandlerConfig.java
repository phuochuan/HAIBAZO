package com.phanhuochuan.shopwebserver.config;

import com.phanhuochuan.shopwebserver.dto.BaseResponse;
import org.apache.coyote.BadRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class ExceptionHandlerConfig {
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<?> handleBadRequestException(final Exception ex){
        return ResponseEntity.badRequest().body(BaseResponse.builder().message(ex.getMessage()).build());
    }
    @ExceptionHandler(ServerErrorException.class)
    public ResponseEntity<?> handleRuntimeException(final Exception ex){
        return ResponseEntity.internalServerError().body(BaseResponse.builder().message(ex.getMessage()).build());
    }
}
