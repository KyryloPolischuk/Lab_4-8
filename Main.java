package com.Main;


import com.Client.Client;
import com.Client.ClientManager;
import com.Menu.*;
import com.Tariff.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Створення тестових об'єктів
        TariffList tariffList = createSampleTariffList();
        ClientManager clientManager = createSampleClientManager();

        // Створення меню
        Menu menu = createMenu(clientManager, tariffList);

        // Використання меню
        Scanner scanner = new Scanner(System.in);
        while (true) {
            menu.display();
            System.out.print("Введіть опцію (або 'exit' для виходу): ");
            String option = scanner.nextLine();

            if (option.equals("exit")) {
                break;
            }

            menu.executeCommand(option);
        }
    }

    private static TariffList createSampleTariffList() {
        TariffList tariffList = new TariffList();
        tariffList.addTariff(new Tariff("Simple", 10.0));
        tariffList.addTariff(new Tariff("Basic", 20.0));
        tariffList.addTariff(new Tariff("Pro", 30.0));
        tariffList.addTariff(new Tariff("Premium", 40.0));
        tariffList.addTariff(new Tariff("Ultimate", 50.0));
        return tariffList;
    }

    private static ClientManager createSampleClientManager() {
        List<Client> clients = new ArrayList<>();
        clients.add(new Client("John Doe", new Tariff("Basic", 20.0)));
        clients.add(new Client("Jane Smith", new Tariff("Premium", 30.0)));
        clients.add(new Client ("Anna Green", new Tariff("Ultimate", 50.0)));
        return new ClientManager(clients);
    }

    private static Menu createMenu(ClientManager clientManager, TariffList tariffList) {
        Menu menu = new Menu(clientManager, tariffList);
        menu.addCommand("1", new CountClientsCommand(clientManager));
        menu.addCommand("2", new ViewTariffsCommand(tariffList));
        menu.addCommand("3", new SortTariffsCommand(tariffList));
        menu.addCommand("4", new FindTariffsCommand(tariffList));
        return menu;
    }
}

