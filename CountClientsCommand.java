package com.Menu;

import com.Client.Client;
import com.Client.ClientManager;

public class CountClientsCommand implements Command {

    private final ClientManager clientManager;

    public CountClientsCommand(ClientManager clientManager) {
        this.clientManager = clientManager;
    }

    @Override
    public void execute() {
        int totalClients = clientManager.getTotalClients();
        System.out.println("Загальна кількість клієнтів: " + totalClients);
    }
}

