package com.stounio.fungame.console;

import com.stounio.fungame.factory.GamePlayServiceFactory;

/**
 * Starts the fun game in console mode.
 */
public class FunGameConsole {

    public static void main(String[] args) {
        initializeGameService();
        try {
            startGame();
        } catch (Exception e) {
            exitWithErrors(e);
        }
    }

    private static void initializeGameService() {
        GamePlayServiceFactory.getFactory().getInstance();
    }

    private static void startGame() {
        FunGameConsoleController.getController().startGame();
    }

    private static void exitWithErrors(Exception e) {
        FunGameConsoleIOService.getService().println(e.getMessage());
        e.printStackTrace();
        System.exit(-1);
    }
}
