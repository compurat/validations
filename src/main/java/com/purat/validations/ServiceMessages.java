package com.purat.validations;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by compurat on 5-5-15.
 */
@Component
 public class ServiceMessages<T>  {

    private T bean;
    private List<String> errorMessages = new ArrayList<String>();
     T getMessageInputBean() {
        return bean;
    }

    void setMessageInputBean(T bean) {
        this.bean = bean;
    }


    public List<String> getErrorMessages() {
        return errorMessages;
    }

     void addErrorMessages(String errorMessages) {
        this.errorMessages.add(errorMessages);
    }


}
