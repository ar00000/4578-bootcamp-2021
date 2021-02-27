package demo.service;

import demo.domain.Order;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class EmailServiceTest {
    private EmailService instance;
    private Order order;

    @BeforeEach
    void setUp() {
        this.instance=new EmailService();
        this.order=new Order(15,"Table",500.0);
    }

    @Test
    void shouldGetInstance() {
        EmailService instance = EmailService.getInstance();
        assertTrue(instance instanceof EmailService);
    }

    @Test
    void showThrowExceptionSendEmail() {
        Executable executable=() -> instance.sendEmail(order);
        assertThrows(RuntimeException.class,executable);
    }

    @Test
    void shouldSendEmail() {
        assertTrue(instance.sendEmail(order,"someone"));
    }
}