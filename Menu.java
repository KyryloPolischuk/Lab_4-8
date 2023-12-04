package com.Menu;

import java.util.Map;
import java.util.HashMap;
import com.Client.ClientManager;
import com.Tariff.*;

public class Menu {
    private final ClientManager clientManager;
    private final TariffList tariffList;
    private final Map<String, Command> commands;

    public Menu(ClientManager clientManager, TariffList tariffList) {
        this.clientManager = clientManager;
        this.tariffList = tariffList;
        this.commands = new HashMap<>();
        initializeCommands();
    }

    private void initializeCommands() {
        commands.put("1", new CountClientsCommand(clientManager));
        commands.put("2", new ViewTariffsCommand(tariffList));
        commands.put("3", new SortTariffsCommand(tariffList));
        commands.put("4", new FindTariffsCommand(tariffList));
    }

    public void addCommand(String option, Command command) {
        commands.put(option, command);
    }

    public void executeCommand(String option) {
        if (commands.containsKey(option)) {
            Command command = commands.get(option);
            if (command != null) {
                command.execute();
            }
        } else {
            System.out.println("Невідома опція: " + option);
        }
    }

    public void display() {
        System.out.println("Виберіть опцію: ");
        for (String option : commands.keySet()) {
            System.out.println(option);
        }
    }
}
