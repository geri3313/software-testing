package selenium.training.tests;

import org.testng.annotations.Test;

import selenium.training.pages.PaymentPage;

public class PaymentTest {
    
    private PaymentPage payment;

    public PaymentTest(){
        payment = new PaymentPage();
    }

    @Test
    public void paymentTest(){
        payment.checkAndContinue();
    }

}
