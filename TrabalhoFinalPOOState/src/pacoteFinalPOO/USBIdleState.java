package pacoteFinalPOO;

public class USBIdleState implements USBBaseState {
    @Override
    public String performAction() {
        return "Modo de inatividade - Nenhuma operação em andamento.";
    }
}
