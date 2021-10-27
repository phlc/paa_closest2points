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
    final private double x; //abscissas
    final private double y; //ordenadas
    private int ordX; //posição na ordenação pelo eixo X
    private int ordY; //posição na ordenação pelo eixo Y


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
    Pequenas funções de suporte ao heapSort para simplificação no uso de arranjo começando em 0
    */
    private static int esq(int n){
        return ((n+1)*2)-1;
    }
    private static int dir(int n){
        return (n+1)*2;
    }

    /*
    heapify - Reorganiza o heap a partir de um elemento em direção aos seus filhos
    @param Ponto[] listap; int i, tamanho; boolean x: lista pontos, indice, tamanho, ordenacao eixo X ou eixo Y
    */
    private static void heapify(Ponto[] lista, int i, int tamanho, boolean x){
        int e = esq(i);
        int d = dir(i);
        int maior = -1;

        //heapify pelo eixo X
        if(x){
            if(e<tamanho && lista[e].getX()>lista[i].getX())
                maior = e;
            else 
                maior = i;
            
            if(d<tamanho && lista[d].getX()>lista[maior].getX())
                maior = d;
        }
        //heapify pelo eixo Y
        else{
            if(e<tamanho && lista[e].getY()>lista[i].getY())
                maior = e;
            else 
                maior = i;
            
            if(d<tamanho && lista[d].getY()>lista[maior].getY())
                maior = d;
        }

        if(maior != i){
            //trocar maior por i
            Ponto buffer = lista[i];
            lista[i] = lista[maior];
            lista[maior] =  buffer;

            //heapify posicao que era maior e contem i
            heapify(lista, maior, tamanho, x);
        }
    } 
    
    /*
    heapSort - HeapSort para pontos
    @param Ponto[], boolean x -> lista de pontos e referencia para ordenacao eixo X ou eixo Y
    @return Ponto[]
    */
    public static Ponto[] heapSort(Ponto[] lista, boolean x){
        //Declaracoes
        Ponto[] resposta = new Ponto[lista.length];
        
        //Copiar lista pra resposta
        for(int i=0; i<lista.length; i++){
            resposta[i] = lista[i];
        }

        //Construir heap
        for(int i=resposta.length/2; i>=0; i--){
            heapify(resposta, i, resposta.length, x);
        }

        //ordenar
        for(int i=resposta.length-1; i>0; i--){
            //trocar 0 com último
            Ponto buffer = resposta[0];
            resposta[0] = resposta[i];
            resposta[i] =  buffer;

            //heapify resposta[0]
            heapify(resposta, 0, i, x);
        }

        return resposta;
    }


    /*
    algoritmoNLogN - Soluciona o problema por divisão e conquista em O(n Log n)
    @param Ponto[] - lista de pontos no plano
    @return resposta[] - para de pontos mais próximos
    */
    public static Ponto[] algoritmoNLogN(Ponto[] Lista){
        Ponto[] resposta = new Ponto[2];



        return resposta;
    }

    /*
    main
            A entrada teste contém conjuntos de pontos sendo que cada conjunto é precedido por um
            inteiro n, denotando o numero de pontos, na primeira linha, seguido de n pontos separados 
            por linha, sendo as coordenadas X e Y separadas por espaço em branco.
            O final do arquivo é identificado por n = 0.
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

            //Solucao O(n^2)
            Ponto[] resposta = algoritmoN2(lista);
            System.out.println("Algoritmo O(n^2):");
            System.out.println("P1("+resposta[0].getX()+","+resposta[0].getY()+") P2("+resposta[1].getX()+","+resposta[1].getY()+")");
            System.out.println();

            //Solucao O(n log n)
            resposta = algoritmoNLogN(lista);
            System.out.println("Algoritmo O(n log n):");
            System.out.println("P1("+resposta[0].getX()+","+resposta[0].getY()+") P2("+resposta[1].getX()+","+resposta[1].getY()+")");
            System.out.println();

            //Ler nova entrada
            quantidade = reader.nextInt();
        }

        //Encerramento
        reader.close();

    }  
}