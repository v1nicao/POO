package pacoteFinalPOO;

import java.util.Random;
import java.util.Scanner;

public class USBChargingState implements USBBaseState {
    
    private static final int MAX_BATTERY_LEVEL = 100;
    private int batteryLevel;

    private boolean stopCharging = false;
    private Scanner scanner = new Scanner(System.in);

    public USBChargingState() {
        Random random = new Random();
        batteryLevel = random.nextInt(30) + 1;
    }

    @Override
    public String performAction() {
        StringBuilder message = new StringBuilder("Modo de carregamento\n");

        Thread userInputThread = new Thread(() -> {
            Scanner scanner = new Scanner(System.in);
            while (!stopCharging) {
                String userInput = scanner.nextLine();
                if ("stop".equalsIgnoreCase(userInput)) {
                    stopCharging = true;
                }
            }
        });

        userInputThread.start();

        while (batteryLevel < MAX_BATTERY_LEVEL && !stopCharging) {
            batteryLevel ++;

            if (batteryLevel > MAX_BATTERY_LEVEL) {
                batteryLevel = MAX_BATTERY_LEVEL;
            }

            message.append("Bateria: ").append(batteryLevel).append("% - Carregando\n");
            System.out.println(message);
            System.out.println("Digite stop caso queira interromper o processo.\n");

            int randomInterval = new Random().nextInt(2) + 15; 
            try {
                Thread.sleep(randomInterval * 1000); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        message.append("Bateria: ").append(batteryLevel).append("% - Carregamento ");
        if (stopCharging) {
            message.append("interrompido.");
        } else {
            message.append("concluído.");
        }

        userInputThread.interrupt();

        return message.toString();
    }
}

