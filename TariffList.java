package com.Tariff;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TariffList {
    private List<Tariff> tariffs;

    public TariffList() {
        tariffs = new ArrayList<>();
    }

    public void addTariff(Tariff tariff) {
        tariffs.add(tariff);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Список тарифів:\n");
        for (Tariff tariff : tariffs) {
            sb.append("Назва: ").append(tariff.getName()).append(", Абонентська плата: ").append(tariff.getSubscriptionFee()).append("\n");
        }
        return sb.toString();
    }

    public List<Tariff> findTariffsInPriceRange(double minPrice, double maxPrice) {
        List<Tariff> result = new ArrayList<>();

        for (Tariff tariff : tariffs) {
            double tariffPrice = tariff.getSubscriptionFee();
            if (tariffPrice >= minPrice && tariffPrice <= maxPrice) {
                result.add(tariff);
            }
        }

        return result;
    }

    public void sortTariffsAlphabetically() {
        tariffs.sort(Comparator.comparing(Tariff::getName));
    }

    public void sortTariffsByPriceDescending() {
        tariffs.sort(Comparator.comparing(Tariff::getSubscriptionFee).reversed());
    }

    public void sortTariffsByPriceAscending() {
        tariffs.sort(Comparator.comparing(Tariff::getSubscriptionFee));
    }

}