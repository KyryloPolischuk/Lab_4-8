package com.Tests;

import com.Client.Client;
import com.Client.ClientManager;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ClientManagerTest {

    @Test
    public void testGetTotalClients() {
        List<Client> clients = createSampleClients();
        ClientManager clientManager = new ClientManager(clients);
        assertEquals(3, clientManager.getTotalClients());
    }

    private List<Client> createSampleClients() {
        List<Client> clients = new ArrayList<>();
        clients.add(new Client("John Doe", null));
        clients.add(new Client("Jane Smith", null));
        clients.add(new Client("Anna Green", null));
        return clients;
    }
}
