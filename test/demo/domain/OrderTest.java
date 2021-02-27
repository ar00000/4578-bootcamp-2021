package demo.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {
    private Order order=new Order(10,"Some",55.0);

    @Test
    void shouldGetQuantity() {
        //given
        final int EXPECTED=15;

        //when
        order.setQuantity(EXPECTED);

        //then
        assertEquals(EXPECTED,order.getQuantity());
    }

    @Test
    void shouldSetQuantity() {
        //given
        final int EXPECTED=30;

        //when
        order.setQuantity(EXPECTED);

        //then
        assertEquals(EXPECTED,order.getQuantity());
    }

    @Test
    void shouldGetItemName() {
        //given
        final String EXPECTED="Something";

        //when
        order.setItemName(EXPECTED);

        //then
        assertEquals(EXPECTED,order.getItemName());
    }

    @Test
    void shouldSetItemName() {
        //given
        final String EXPECTED="Different Thing";

        //when
        order.setItemName(EXPECTED);

        //then
        assertEquals(EXPECTED,order.getItemName());
    }

    @Test
    void shouldGetPrice() {
        //given
        final double EXPECTED= 50.0;

        //when
        order.setPrice(EXPECTED);

        //then
        assertEquals(EXPECTED,order.getPrice());
    }

    @Test
    void shouldSetPrice() {
        //given
        final double EXPECTED=80.0;

        //when
        order.setPrice(EXPECTED);

        //then
        assertEquals(EXPECTED,order.getPrice());
    }

    @Test
    void shouldGetPriceWithTax() {
        //given
        final double EXPECTED =90.0;

        //when
        order.setPriceWithTax(EXPECTED);

        //then
        assertEquals(EXPECTED,order.getPriceWithTax());
    }

    @Test
    void shouldSetPriceWithTax() {
        //given
        final double EXPECTED =85.5;

        //when
        order.setPriceWithTax(EXPECTED);

        //then
        assertEquals(EXPECTED,order.getPriceWithTax());
    }
}