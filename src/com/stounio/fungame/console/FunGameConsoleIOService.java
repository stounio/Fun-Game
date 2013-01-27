package com.stounio.fungame.console;

import java.util.Scanner;

/**
 * Utility service used to print and read messages from the console.
 */
public class FunGameConsoleIOService {

    private static final FunGameConsoleIOService service = new FunGameConsoleIOService();

    private final Scanner Scanner;

    private FunGameConsoleIOService() {
        this.Scanner = new Scanner(System.in);
    }

    public static FunGameConsoleIOService getService() {
        return service;
    }

    public void println(String string) {
        if (System.console() == null) {
            System.out.println(string);
        } else {
            System.console().writer().println(string);
        }
    }

    public String nextLine() {
        return Scanner.nextLine();
    }

}
