package pacoteFinalPOO;

import java.util.Scanner;

public class USBTransferState implements USBBaseState{
    private Scanner scanner = new Scanner(System.in);

    @Override
    public String performAction() {
        System.out.println("Modo de transferencia de dados");

        System.out.print("Qual o tipo de dados deseja transferir: ");
        String tipoDados = scanner.nextLine();

        System.out.print("Digite a quantidade de itens que deseja transferir (1 para arquivo único, 2 para pasta): ");
        int quantidadeItens = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Digite o local onde se encontram os itens: ");
        String localItens = scanner.nextLine();

        String nomeEspecifico = "";
        if (quantidadeItens == 1) {
            System.out.print("Digite o nome específico do arquivo: ");
            nomeEspecifico = scanner.nextLine();
        }

        String mensagemSucesso = concluirTransferencia(tipoDados, quantidadeItens, localItens, nomeEspecifico);

        return mensagemSucesso;
    }

    private String concluirTransferencia(String tipoDados, int quantidadeItens, String localItens, String nomeEspecifico) {
        String tipoItem;
        switch (quantidadeItens) {
            case 1:
                tipoItem = "o arquivo " + nomeEspecifico + " localizado em: ";
                break;
            default:
                tipoItem = "a pasta localizada em: ";
                break;
        }
        
        return "Transferência concluída: " + tipoItem + localItens + "foi enviado ao computador com sucesso";
    }

}
