package com.purat.validations;

import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Created by compurat on 11/30/15.
 */
@RunWith(MockitoJUnitRunner.class)
public class ServiceBeanValidatorTest {

    @Spy
    private ServiceMessages<TestBeanValidations> serviceMessages;
    @InjectMocks
    ServiceBeanValidator<TestBeanValidations> serviceBeanValidator;

    @Test
    public void testVerifyNoMessages() {
        TestBeanValidations testBeanValidations = new TestBeanValidations();
        testBeanValidations.setTestAge(20);
        testBeanValidations.setTestEmail("test@test.com");
        serviceBeanValidator.verify(testBeanValidations);
        ServiceMessages<TestBeanValidations> serviceMessages = serviceBeanValidator.getMessages();
        Assert.assertEquals(0,serviceMessages.getErrorMessages().size());
    }

    @Test
    public void testVerifyEmailNull() {
        TestBeanValidations testBeanValidations = new TestBeanValidations();
        testBeanValidations.setTestAge(20);
        testBeanValidations.setTestEmail(null);
        serviceBeanValidator.verify(testBeanValidations);
        ServiceMessages<TestBeanValidations> serviceMessages = serviceBeanValidator.getMessages();
        Assert.assertTrue("The email cannot be null".equals(serviceMessages.getErrorMessages().get(0)));
    }
    @Test
    public void testVerifyEmailWrong() {
        TestBeanValidations testBeanValidations = new TestBeanValidations();
        testBeanValidations.setTestAge(20);
        testBeanValidations.setTestEmail("testtestcom");
        serviceBeanValidator.verify(testBeanValidations);
        ServiceMessages<TestBeanValidations> serviceMessages = serviceBeanValidator.getMessages();
        Assert.assertTrue("Wrong email address.".equals(serviceMessages.getErrorMessages().get(0)));
    }
    @Test
    public void testVerifyAgeToSmall() {
        TestBeanValidations testBeanValidations = new TestBeanValidations();
        testBeanValidations.setTestAge(10);
        testBeanValidations.setTestEmail(null);
        serviceBeanValidator.verify(testBeanValidations);
        ServiceMessages<TestBeanValidations> serviceMessages = serviceBeanValidator.getMessages();
        Assert.assertTrue("You need to be 18.".equals(serviceMessages.getErrorMessages().get(0)));
    }
}
