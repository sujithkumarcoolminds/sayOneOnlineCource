package com.sayone.online.modal;

import com.sayone.online.utils.Constants;

public class Response<T> {

    private int status;
    private String message;
    private String messageDetails;
    private T data;

    public Response(int status, String message, String messageDetails, T data) {
        this.status = status;
        this.message = message;
        this.messageDetails = messageDetails;
        this.data = data;
    }


    public Response(int status, String messageDetails) {
        this.status = status;
        this.message = Constants.ERROR;
        this.messageDetails = messageDetails;
        this.data = null;
    }

    public Response(int status, T data) {
        this.status = status;
        this.message = Constants.SUCCESS;
        this.messageDetails = null;
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessageDetails() {
        return messageDetails;
    }

    public void setMessageDetails(String messageDetails) {
        this.messageDetails = messageDetails;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


}