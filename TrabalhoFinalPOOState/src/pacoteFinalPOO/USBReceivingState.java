package pacoteFinalPOO;

import java.util.Random;
import java.util.Scanner;

public class USBReceivingState implements USBBaseState {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public String performAction() {
        System.out.println("Modo de recebimento de dados");

        System.out.print("Qual o tipo de dados deseja receber: ");
        String tipoDados = scanner.nextLine();

        System.out.print("Digite a quantidade de itens que deseja receber (1 para arquivo único, 2 para pasta): ");
        int quantidadeItens = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Digite o local onde se encontram os itens: ");
        String localItens = scanner.nextLine();

        String nomeEspecifico = "";
        if (quantidadeItens == 1) {
            System.out.print("Digite o nome específico do arquivo: ");
            nomeEspecifico = scanner.nextLine();
        }

        System.out.print("Digite o local no celular para salvar os itens: ");
        String localNoCelular = scanner.nextLine();

        Random random = new Random();
        int tamanhoDados = random.nextInt(1000) + 1;

        String mensagemSucesso = concluirRecebimento(tipoDados, quantidadeItens, localItens, localNoCelular, 
            nomeEspecifico, tamanhoDados);

        return mensagemSucesso;
    }

    private String concluirRecebimento(String tipoDados, int quantidadeItens, String localItens, 
        String localNoCelular, String nomeEspecifico, int tamanhoDados) {
        String tipoItem;

        switch (quantidadeItens) {
            case 1:
                tipoItem = "o arquivo " + nomeEspecifico + " localizado no computador em: ";
                break;
            default:
                tipoItem = "a pasta localizada no computador em: ";
                break;
        }

        return "Recebimento concluído: " + tipoItem + " foi salvo no celular em: " + localNoCelular +
               "\nTamanho dos dados recebidos: " + tamanhoDados + " MB";
    }
}
