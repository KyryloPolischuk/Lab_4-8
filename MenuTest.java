package com.Tests;

import com.Menu.Command;
import com.Menu.Menu;
import com.Client.ClientManager;
import com.Tariff.TariffList;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


import static org.junit.Assert.*;

public class MenuTest {

    @Test
    public void testAddCommand() {
        Menu menu = createSampleMenu();
        menu.addCommand("5", new TestCommand());
        assertTrue(menu.executeCommand("5"));
    }

    @Test
    public void testExecuteCommand() {
        Menu menu = createSampleMenu();
        TestCommand testCommand = new TestCommand();
        menu.addCommand("5", testCommand);


        menu.executeCommand("5");
        assertTrue(testCommand.isExecuted());
    }

    private Menu createSampleMenu() {
        ClientManager clientManager = new ClientManager(null);
        TariffList tariffList = new TariffList();
        return new Menu(clientManager, tariffList);
    }

    // Допоміжний клас для тестування виклику команди
    private static class TestCommand implements Command {
        private boolean executed = false;

        @Override
        public void execute() {
            executed = true;
        }

        public boolean isExecuted() {
            return executed;
        }
    }
}

