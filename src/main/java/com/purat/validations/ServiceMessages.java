package com.purat.validations;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by compurat on 5-5-15.
 */
@Component
 public class ServiceMessages<T>  {

    private List<String> errorMessages = new ArrayList<String>();

    public List<String> getErrorMessages() {
        return errorMessages;
    }

    public void addErrorMessages(String errorMessages) {
        this.errorMessages.add(errorMessages);
    }


}
