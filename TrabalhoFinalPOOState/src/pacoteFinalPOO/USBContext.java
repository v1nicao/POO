package pacoteFinalPOO;

import java.util.Random;

public class USBContext {
    private USBBaseState currentState;
    String [] devicesNames = {"Iphone 8", "Iphone 11 max", "Moto G20", "Samsung A50", "Note 12s max"};
    String connectedDevice;

    public USBContext() {
        this.currentState = new USBIdleState();
        chooseRandomDevice();
    }

    public void setState(USBBaseState newState) {
        this.currentState = newState;
    }

    public String performAction(){
        return currentState.performAction();
    }

    private void chooseRandomDevice() {
        Random random = new Random();
        connectedDevice = devicesNames[random.nextInt(devicesNames.length)];
        System.out.println(connectedDevice + " conectado com sucesso ao computador.");
    }

    public String getConnectedDevice() {
        return connectedDevice;
    }
}
