package com.purat.validations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by compurat on 11/30/15.
 */
    @Component
    public class ServiceBeanValidator<T> {


    @Autowired
    private ServiceMessages<T> messages;



        private Set<ConstraintViolation<T>> errorMessages = new HashSet<ConstraintViolation<T>>();


        public boolean verify(final T bean) {
            ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
            javax.validation.Validator validator = factory.getValidator();
            errorMessages = validator.validate(bean);
            messages.setMessageInputBean(bean);
            boolean verified = errorMessages.size()==0;
            return  verified;

        }

        public ServiceMessages getMessages() {
            List<ConstraintViolation<T>> constraintViolations = new ArrayList<ConstraintViolation<T>>();
            constraintViolations.addAll(errorMessages);
            for (ConstraintViolation<T> constraintViolation : constraintViolations ){
                String message = constraintViolation.getMessage();
                messages.addErrorMessages(message);
            }
            return messages;
        }

        public void addMessage(String message) {
            messages.addErrorMessages(message);
        }
}
