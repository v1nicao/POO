package pacoteFinalPOO;

import java.util.Scanner;
import java.io.IOException;

public class USBMain {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        USBContext usbContext = new USBContext();

        while (true) {
            clearScreen(); // Limpar a tela

            System.out.println("Escolha o modo da USB:");
            System.out.println("1. Modo de Transferência");
            System.out.println("2. Modo de Recebimento");
            System.out.println("3. Modo de Carregamento");
            System.out.println("4. Modo de Inatividade");
            System.out.println("0. Sair");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha pendente
            clearScreen();

            switch (choice) {
                case 1:
                    usbContext.setState(new USBTransferState());
                    break;
                case 2:
                    usbContext.setState(new USBReceivingState());
                    break;
                case 3:
                    usbContext.setState(new USBChargingState());
                    break;
                case 4:
                    usbContext.setState(new USBIdleState());
                    break;
                case 0:
                    System.out.println("Encerrando o programa.");
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    continue;
            }

            String result = usbContext.performAction();
            System.out.println(result);

            System.out.println("Pressione Enter para continuar...");
            scanner.nextLine(); // Aguarda a entrada do usuário antes de limpar a tela novamente
        }
    }

    private static void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
