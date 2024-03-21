package pacoteFinalPOO;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TesteIdleState {

    @Test
    void testPerformAction() {
        USBBaseState idleState = new USBIdleState();
        String result = idleState.performAction();

        assertEquals("Modo de inatividade - Nenhuma operação em andamento.", result);
    }
}
