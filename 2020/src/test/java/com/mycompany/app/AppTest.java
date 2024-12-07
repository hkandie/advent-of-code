package com.mycompany.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {

    /**
     * Rigorous Test :-)
     * 
     * @throws Exception
     */
    @Test
    public void shouldAnswerWithTrue() throws Exception {
        App app = new App();
        assertEquals(10, app.readFile().size());
    }
}
