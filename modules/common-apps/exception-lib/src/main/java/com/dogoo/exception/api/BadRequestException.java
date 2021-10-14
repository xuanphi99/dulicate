package com.dogoo.exception.api;

import javax.ws.rs.core.Response;

public class BadRequestException extends Exception{
    /**
     * Contains redundantly the HTTP status of the response sent back to the client in case of error, so that
     * the developer does not have to look into the response headers. If null a default
     */
    private Integer status;

    /** detailed error description for developers*/
    private String developerMessage;

    /** application specific error code */
    private String code;

    private String normalMessage;

    private BadRequestException() {}

    public BadRequestException(String code, String message) {
        this.status = Response.Status.BAD_REQUEST.getStatusCode();
        this.code = code;
        this.normalMessage = message;
    }

    public BadRequestException(Integer status, String code, String message) {
        this.status = status;
        this.code = code;
        this.normalMessage = message;
    }

    public BadRequestException(Integer status, String code, String message, String developerMessage) {
        super(developerMessage);
        this.status = status;
        this.code = code;
        this.normalMessage = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDeveloperMessage() {
        return developerMessage;
    }

    public void setDeveloperMessage(String developerMessage) {
        this.developerMessage = developerMessage;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNormalMessage() {
        return normalMessage;
    }

    public void setNormalMessage(String normalMessage) {
        this.normalMessage = normalMessage;
    }

}
