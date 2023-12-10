package com.Tests;

import com.Tariff.Tariff;
import org.junit.Test;

import static org.junit.Assert.*;

public class TariffTest {

    @Test
    public void testGetters() {
        Tariff tariff = new Tariff("Basic", 20.0);
        assertEquals("Basic", tariff.getName());
        assertEquals(20.0, tariff.getSubscriptionFee(), 0.001);
    }
}

