package com.Tests;

import com.Main.Main;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void testMainExitOption() {
        // Моделюємо введення "exit"
        String input = "exit\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Зберігаємо стандартний вивід
        PrintStream originalOut = System.out;
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Викликаємо головний метод
        Main.main(null);

        // Перевіряємо, чи було виведено очікуваний текст
        String expectedOutput = "Виберіть опцію: \n1, 2, 3, 4\n";
        assertEquals(expectedOutput, outContent.toString());


    }

    @Test
    public void testMainInvalidOption() {
        // Моделюємо введення "invalidOption exit"
        String input = "invalidOption\nexit\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Зберігаємо стандартний вивід
        PrintStream originalOut = System.out;
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Викликаємо головний метод
        Main.main(null);

        // Перевіряємо, чи було виведено очікуваний текст
        String expectedOutput = "Невідома опція: invalidOption\nВиберіть опцію: \n1, 2, 3, 4\n";
          assertEquals(expectedOutput, outContent.toString());


    }
}

