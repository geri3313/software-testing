package org.example;

public class Generator {

    public static int generateRandomNumber() {
        return 10 - (int)(Math.random() * 30); //[-10, 10]
    }
}