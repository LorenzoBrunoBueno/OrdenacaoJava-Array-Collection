package Prova;
import java.util.TreeSet;

public class AtividadeAvaliativa {
    public static void main(String[] args){
      int[] arrayExemplo = {100, 11, 55, 1, 4, 2};
      int contagemPasso = 1;

      //Collection
      //Criando a Lista com Collections
      TreeSet<Integer> ListaNumeros = new TreeSet<Integer>();
      //Adicionando os elementos da lista através de um for
      for (int i = 0; i < arrayExemplo.length; i++){
        ListaNumeros.add(arrayExemplo[i]);
      }

      //Array
      for (int i = 0; i < arrayExemplo.length; i++){
        //armazenando indice a ser comparado
        int menorIndex = i;
        //for começando da posição seguinte ao 'i'
        for (int j = i+1; j < arrayExemplo.length; j++ ){
            //verifica se o indíce atual 'j' é menor que o atual menor índice 'menorIndex'
            if (arrayExemplo[j] < arrayExemplo[menorIndex]){
                //Se o index 'j' for menor que o numero da posição 'menorIndex' do arrayExemplo, substitui o valor de 'menorIndex' pela posição 'j' 
                menorIndex = j;
            };
        }
        if (menorIndex != i){
            //trocando os valores de arrayExemplo índice 'i' para arrayExemplo índice 'menorIndex' e vice-versa, utilizando uma variável 'mediador' para armazenar o valor de arrayExemplo[i]
            int mediador = arrayExemplo[i];
            arrayExemplo[i] = arrayExemplo[menorIndex];
            arrayExemplo[menorIndex] = mediador;
        }
        //Print do passo atual com numero do passo e pulando linha
        System.out.println("Passo "+ contagemPasso);
        for (int numero : arrayExemplo){
                System.out.print(numero +" ");
        }
        System.out.println(" ");
        contagemPasso++;
      }
      
      //Imprimindo o Array e a Collection
      System.out.println("Array: ");
      for (int numero : arrayExemplo){
        System.out.print(numero+" ");
      }
      System.out.println("");
      System.out.println("Collection: ");
      for (int numero : ListaNumeros){
         System.out.print(numero+" ");
      }

    }
}
