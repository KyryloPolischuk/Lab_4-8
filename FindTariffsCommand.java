package com.Menu;

import com.Tariff.Tariff;
import com.Tariff.TariffList;

import java.util.List;
import java.util.Scanner;

public class FindTariffsCommand implements Command {

    private final TariffList tariffList;

    public FindTariffsCommand(TariffList tariffList) {
        this.tariffList = tariffList;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть мінімальну ціну: ");
        double minPrice = scanner.nextDouble();

        System.out.print("Введіть максимальну ціну: ");
        double maxPrice = scanner.nextDouble();

        List<Tariff> foundTariffs = tariffList.findTariffsInPriceRange(minPrice, maxPrice);

        if (foundTariffs.isEmpty()) {
            System.out.println("Тарифи в заданому діапазоні не знайдено.");
        } else {
            System.out.println("Тарифи в заданому діапазоні:");
            for (Tariff tariff : foundTariffs) {
                System.out.println("Назва: " + tariff.getName() + ", Абонентська плата: " + tariff.getSubscriptionFee());
            }
        }
    }
}
