package com.Menu;

import com.Tariff.TariffList;

import java.util.Scanner;

public class SortTariffsCommand implements Command {

    private final TariffList tariffList;

    public SortTariffsCommand(TariffList tariffList) {
        this.tariffList = tariffList;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Оберіть порядок сортування:");
        System.out.println("1. За абонентською платою в порядку зростання");
        System.out.println("2. За абонентською платою в порядку спадання");
        System.out.println("3. За назвою в алфавітному порядку");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                tariffList.sortTariffsByPriceAscending();
                System.out.println("Тарифи відсортовано за абонентською платою в порядку зростання.");
                break;
            case 2:
                tariffList.sortTariffsByPriceDescending();
                System.out.println("Тарифи відсортовано за абонентською платою в порядку спадання.");
                break;
            case 3:
                tariffList.sortTariffsAlphabetically();
                System.out.println("Тарифи відсортовано за назвою в алфавітному порядку.");
                break;
            default:
                System.out.println("Невірний вибір.");
        }
    }
}
