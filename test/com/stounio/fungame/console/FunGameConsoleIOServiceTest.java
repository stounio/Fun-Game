package com.stounio.fungame.console;

import java.io.Console;

import org.junit.Test;

public class FunGameConsoleIOServiceTest {

    private static final String A_STRING_TO_PRINT = "A STRING TO PRINT";

    @Test(expected = NullPointerException.class)
    public void should_throw_a_null_pointer_exception_when_not_run_in_a_console() {
        Console console = System.console();
        console.writer();
    }

    @Test
    public void should_not_fail_when_resquested_for_printing_a_message_and_not_run_in_a_console() {
        FunGameConsoleIOService.getService().println(A_STRING_TO_PRINT);
    }

}
