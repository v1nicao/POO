package Files;

import java.io.File;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;

public class LeituradeArquivo {
    public static String lerArquivo(String caminho) throws IOException {
        StringBuilder conteudo = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                conteudo.append(linha).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return conteudo.toString();
    }

    public static void main(String[] args) throws IOException {
        String caminhodoArquivo = "c:\\Users\\vinicius\\Documents\\DocumentoTeste.txt";
        String conteudo = lerArquivo(caminhodoArquivo);
        //System.out.println(conteudo);

        int inicio = conteudo.indexOf("Teste 2");
        int fim = conteudo.indexOf("fim");

        if (inicio != -1 && fim != -1) {
            //fim+= "fim".length(); //Ajustar o fim para pegar o tamanho da string
            String substring = conteudo.substring(inicio, fim);
            System.out.println(substring);
        } else {
            System.out.println("Substring not found");
        }
    }
}
