package Prova;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

public class AtividadeAvaliativa {
    public static void main(String[] args){
      //Criando array através de uma lista
      ArrayList<Integer> arrayExemplo = new ArrayList<Integer>();
      try {
        //Selecionando o arquivo e criando um scanner
        File myObj = new File("Array.txt");
        Scanner myReader = new Scanner(myObj);
      //While para ler cada linha e adicionar na lista 'arrayExemplo'
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        int num = Integer.parseInt(data);
        arrayExemplo.add(num);
      }
        myReader.close();
      } catch (FileNotFoundException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
      }

      
      int contagemPasso = 1;

      //Collection
      //Criando a Lista com Collections
      TreeSet<Integer> ListaNumeros = new TreeSet<Integer>();
      //Adicionando os elementos da lista através de um for
      for (int i = 0; i < arrayExemplo.size(); i++){
        ListaNumeros.add(arrayExemplo.get(i));
      }

      //Array
      for (int i = 0; i < arrayExemplo.size(); i++){
        //armazenando indice a ser comparado
        int menorIndex = i;
        //for começando da posição seguinte ao 'i'
        for (int j = i+1; j < arrayExemplo.size(); j++ ){
            //verifica se o indíce atual 'j' é menor que o atual menor índice 'menorIndex'
            if (arrayExemplo.get(j) < arrayExemplo.get(menorIndex)){
                //Se o index 'j' for menor que o numero da posição 'menorIndex' do arrayExemplo, substitui o valor de 'menorIndex' pela posição 'j' 
                menorIndex = j;
            };
        }
        if (menorIndex != i){
            //trocando os valores de arrayExemplo índice 'i' para arrayExemplo índice 'menorIndex' e vice-versa, utilizando uma variável 'mediador' para armazenar o valor de arrayExemplo[i]
            int mediador = arrayExemplo.get(i);
            arrayExemplo.set(i, arrayExemplo.get(menorIndex));
            arrayExemplo.set(menorIndex, mediador);
        }
        //Print do passo atual com numero do passo e pulando linha
        System.out.println("Passo "+ contagemPasso);
        for (int numero : arrayExemplo){
                System.out.print(numero +" ");
        }
        System.out.println(" ");
        contagemPasso++;
      }

      //Criando novo arquivo
      try {
        File ArquivoResposta = new File("Resposta.txt");
        if (ArquivoResposta.createNewFile()) {
          System.out.println("Arquivo Criado!");
        } else {
          System.out.println("Arquivo já Existe!");
        }
      } catch (IOException e) {
        System.out.println("Erro");
        e.printStackTrace();
        }

      //Escrevendo no arquivo criado
      try {
        //Selecionando o arquivo para escrever
        FileWriter EscritorArquivo = new FileWriter("Resposta.txt");
        //Escrevendo a Lista
        EscritorArquivo.write("Lista Array: ");
        for (int i = 0; i < arrayExemplo.size(); i++){
          String linha = Integer.toString(arrayExemplo.get(i));
          EscritorArquivo.write("\n"+linha);
        }
        //Escrevendo a Collection
        EscritorArquivo.write("\n\nCollection: ");
        for (int numero : ListaNumeros){
          String linha = Integer.toString(numero);
          EscritorArquivo.write("\n"+linha);
        }
        EscritorArquivo.close();
        System.out.println("Resposta Pronta!");
      } catch (IOException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
        }
      
    }
}
