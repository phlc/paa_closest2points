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
import java.lang.Math;

/*
Pontos - Classe que armazena as coordenadas de um ponto e sua posição nas ordenações
         tanto pelo eixo X, quanto pelo eixo Y
*/
class Ponto{
    //atributos
    final private double x;
    final private double y;
    private int ordX;
    private int ordY;


    //Construtor
    public Ponto(double x, double y){
        this.x = x;
        this.y = y;
        this.ordX = this.ordY = -1;
    }

    //Sets & Gets
    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }
    public int getOrdX(){
        return ordX;
    }
    public int getOrdY(){
        return ordY;
    }
    public void setOrdX(int ordX){
        this.ordX = ordX;
    }
    public void setOrdY(int ordY){
        this.ordY = ordY;
    }
}




/*
Classe Principal - PontosMaisProximos
*/
public class PontosMaisProximos{

    /*
    distancia - calcula a distancia entre dois pontos
    @param Ponto a, Ponto b
    @return double distancia
    */
    private static double distancia(Ponto a, Ponto b){
        double distancia = -1;
        double difX = a.getX() - b.getX();
        double difY = a.getY() - b.getY();
        distancia = Math.sqrt(Math.pow(difX, 2) + Math.pow(difY, 2));
        return distancia;
    }

    /*
    algoritmoN2 - Soluciona o problema por força bruta em O(n^2)
    @param Ponto[] - lista de pontos no plano
    @return resposta[] - para de pontos mais próximos
    */
    public static Ponto[] algoritmoN2(Ponto[] lista){
        //Declaracoes
        Ponto[] resposta = new Ponto[2];
        double menorDistancia = Double.POSITIVE_INFINITY;

        //calcular todas as distancias
        for(int i=0; i<lista.length; i++){
            for(int j=i+1; j<lista.length; j++){
                double dist = distancia(lista[i], lista[j]);

                if(dist < menorDistancia){
                    menorDistancia = dist;
                    resposta[0] = lista[i];
                    resposta[1] = lista[j];
                }
            }
        }

        //return
        return resposta;
    }

    /*
    main
    */
    public static void main(String[] args){
        //Declaracoes
        Scanner reader = new Scanner(System.in);
        int quantidade = 0;

        //Ler número de pontos
        quantidade = reader.nextInt();

        //Repetir até entrada == 0
        while(quantidade!=0){
            //Declaracoes
            Ponto[] lista = new Ponto[quantidade]; //lista de pontos

            //Ler pontos
            for(int i=0; i<quantidade; i++){
                double x = reader.nextDouble();
                double y = reader.nextDouble();
                
                //criar e inserir ponto na lista
                lista[i] =  new Ponto(x, y);
            }

            Ponto[] resposta = algoritmoN2(lista);
            System.out.println("P1("+resposta[0].getX()+","+resposta[0].getY()+") P2("+resposta[1].getX()+","+resposta[1].getY()+")");


            //Ler nova entrada
            quantidade = reader.nextInt();
        }

        //Encerramento
        reader.close();

    }  
}