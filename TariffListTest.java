package com.Tests;

import com.Tariff.TariffList;
import com.Tariff.Tariff;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.List;

import static com.Main.Main.createSampleTariffList;
import static org.junit.Assert.*;

public class TariffListTest {

    @Test
    public void testAddTariff() {
        TariffList tariffList = new TariffList();
        Tariff tariff = new Tariff("TestTariff", 25.0);
        tariffList.addTariff(tariff);
        List<Tariff> tariffs = getTariffs(tariffList);
        assertEquals(1, tariffs.size());
        assertEquals("TestTariff", tariffs.get(0).getName());
    }

    @Test
    public void testSortTariffsAlphabetically() {
        TariffList tariffList = createSampleTariffList();
        tariffList.sortTariffsAlphabetically();
        List<Tariff> tariffs = getTariffs(tariffList);
        assertEquals("Basic", tariffs.get(0).getName());
        assertEquals("Premium", tariffs.get(4).getName());
        assertEquals("Pro", tariffs.get(2).getName());
        assertEquals("Simple", tariffs.get(1).getName());
        assertEquals("Ultimate", tariffs.get(3).getName());
    }

    @Test
    public void testSortTariffsByPriceDescending() {
        TariffList tariffList = createSampleTariffList();
        tariffList.sortTariffsByPriceDescending();
        List<Tariff> tariffs = getTariffs(tariffList);
        assertEquals(50.0, tariffs.get(0).getSubscriptionFee(), 0.001);
        assertEquals(40.0, tariffs.get(1).getSubscriptionFee(), 0.001);
        assertEquals(30.0, tariffs.get(2).getSubscriptionFee(), 0.001);
        assertEquals(20.0, tariffs.get(3).getSubscriptionFee(), 0.001);
        assertEquals(10.0, tariffs.get(4).getSubscriptionFee(), 0.001);
    }

    @Test
    public void testSortTariffsByPriceAscending() {
        TariffList tariffList = createSampleTariffList();
        tariffList.sortTariffsByPriceAscending();
        List<Tariff> tariffs = getTariffs(tariffList);
        assertEquals(10.0, tariffs.get(0).getSubscriptionFee(), 0.001);
        assertEquals(20.0, tariffs.get(1).getSubscriptionFee(), 0.001);
        assertEquals(30.0, tariffs.get(2).getSubscriptionFee(), 0.001);
        assertEquals(40.0, tariffs.get(3).getSubscriptionFee(), 0.001);
        assertEquals(50.0, tariffs.get(4).getSubscriptionFee(), 0.001);
    }

    @Test
    public void testFindTariffsInPriceRange() {
        TariffList tariffList = createSampleTariffList();
        List<Tariff> foundTariffs = tariffList.findTariffsInPriceRange(20.0, 40.0);
        assertEquals(3, foundTariffs.size());
        // Перевірки для інших сценаріїв
        assertEquals("Basic", foundTariffs.get(0).getName());
        assertEquals("Pro", foundTariffs.get(1).getName());
        assertEquals("Premium", foundTariffs.get(2).getName());
    }


    private List<Tariff> getTariffs(TariffList tariffList) {
        try {
            Field field = TariffList.class.getDeclaredField("tariffs");
            field.setAccessible(true);
            return (List<Tariff>) field.get(tariffList);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace(); // Обробка винятків для демонстрації; зазвичай обробляється адекватно
            return null;
        }
    }
}
