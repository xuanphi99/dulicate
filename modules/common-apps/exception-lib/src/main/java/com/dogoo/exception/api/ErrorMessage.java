package com.dogoo.exception.api;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "status",
        "code",
        "message",
        "developerMessage"
})
@XmlRootElement(name = "RefreshToken")
public class ErrorMessage {
    /** contains the same HTTP Status code returned by the server */
    private int status;

    /** application specific error code */
    private String code;

    /** message describing the error*/
    private String message;

    /** extra information that might useful for developers */
    private String developerMessage;

    private ErrorMessage() {}

    public ErrorMessage(UnAuthenticationException e) {
        this.setStatus(e.getStatus());
        this.setCode(e.getCode());
        this.setMessage(e.getNormalMessage());
        this.setDeveloperMessage(e.getMessage());
    }

    public ErrorMessage(BadRequestException e) {
        this.setStatus(e.getStatus());
        this.setCode(e.getCode());
        this.setMessage(e.getNormalMessage());
        this.setDeveloperMessage(e.getMessage());
    }

    public ErrorMessage(TokenRefreshException e) {
        this.setStatus(e.getStatus());
        this.setCode(e.getCode());
        this.setMessage(e.getNormalMessage());
        this.setDeveloperMessage(e.getMessage());
    }

    public ErrorMessage(NotFoundException e) {
        this.setStatus(e.getStatus());
        this.setCode(e.getCode());
        this.setMessage(e.getNormalMessage());
        this.setDeveloperMessage(e.getMessage());
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDeveloperMessage() {
        return developerMessage;
    }

    public void setDeveloperMessage(String developerMessage) {
        this.developerMessage = developerMessage;
    }
}
