package Files;

import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;

public class ManipuladorArquivo{
    private File arquivo;
    private FileWriter escritor;
    private FileReader leitor;
    private BufferedReader buffer;

    public ManipuladorArquivo(String nomeArquivo){
        this.arquivo = new File(nomeArquivo);
    }

    public static void salvar(String nomeArquivo, String texto) throws IOException{
        FileWriter escritor = new FileWriter(nomeArquivo);
        escritor.write(texto);
        escritor.close();
    }

    public static String ler(String nomeArquivo) throws IOException{
        FileReader leitor = new FileReader(nomeArquivo);
        BufferedReader buffer = new BufferedReader(leitor);
        String texto = "";
        String linha = "";
        while((linha = buffer.readLine()) != null){
            texto += linha;
        }
        leitor.close();
        return texto;
    }

    public void escrever(String texto){
        try{
            this.escritor = new FileWriter(this.arquivo);
            this.escritor.write(texto);
            this.escritor.close();
        }catch(IOException e){
            System.out.println("Erro ao escrever no arquivo");
        }
    }
    public static void criarPasta(String nomePasta){
        File pasta = new File(nomePasta);
        pasta.mkdir();
    }
/*
    public String ler(){
        String texto = "";
        try{
            this.leitor = new FileReader(this.arquivo);
            this.buffer = new BufferedReader(this.leitor);
            String linha = "";
            while((linha = this.buffer.readLine()) != null){
                texto += linha;
            }
            this.leitor.close();
        }catch(IOException e){
            System.out.println("Erro ao ler o arquivo");
        }
        return texto;
    }
  */  
    public static void main(String[] args) throws IOException {
        String nomeArquivo = "teste.txt";
        ManipuladorArquivo manipulador = new ManipuladorArquivo(nomeArquivo);
        String conteudolido = ler("teste.txt");
        manipulador.escrever("Teste de escrita no arquivo");
        System.out.println(conteudolido);
        criarPasta(conteudolido);
    }
}