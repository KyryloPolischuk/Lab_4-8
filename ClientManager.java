package com.Client;

import java.util.List;

public class ClientManager {
    private List<Client> clients;

    public ClientManager(List<Client> clients) {
        this.clients = clients;
    }

    public int getTotalClients() {
        return clients.size();
    }

}
