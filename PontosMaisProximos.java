/*
Pucminas - Ciência da Computação - Coração Eucarístico
PAA - Manhã
Nome: Pedro Henrique Lima Carvalho
Matricula: 651230

Trabalho Pontos Mais Próximos:
    Dado diversos pontos em um plano, encontrar os dois mais próximos.

    Abordagem: Divisão e Conquista
*/

//Dependencias 
import java.util.Scanner;


/*
Classe Principal - PontosMaisProximos
*/
public class PontosMaisProximos{


    /*
    main
    */
    public static void main(String[] args){
        //Declaracoes
        Scanner reader = new Scanner(System.in);
        int pontos = 0;

        //Ler número de pontos
        pontos = reader.nextInt();

        //Repetir até entrada == 0
        while(pontos!=0){
            //Declaracoes
            double[] posX = new double[pontos];
            double[] posY = new double[pontos];

            //Ler pontos
            for(int i=0; i<pontos; i++){
                posX[i] = reader.nextDouble();
                posY[i] = reader.nextDouble();
            }

            System.out.println(pontos);
            for(int i=0; i<pontos; i++){
                System.out.println(posX[i]+" "+posY[i]);
            }

            //Ler nova entrada
            pontos = reader.nextInt();
        }

        //Encerramento
        reader.close();

    }  
}