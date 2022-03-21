package org.studying.couchdb.couchdbdemo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.time.LocalDateTime;

@JsonInclude(content = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class APIErrorDto implements Serializable {

    private LocalDateTime currentTime;
    private String errorCode;
    private String message;

    public APIErrorDto(String errorCode, String message){
        super();
        this.errorCode = errorCode;
        this.message = message;
        this.currentTime = LocalDateTime.now();
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getCurrentTime() {
        return currentTime;
    }
}
