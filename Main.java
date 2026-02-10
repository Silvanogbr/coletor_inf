package Logica_Automacao;
import java.util.Random;
@SuppressWarnings("all")

/*
 PROJETO: Coletor de dados de automação.
 OBJETIVO:
  -Exemplificar a coleta;
  -tratamento;
  -validação de dados industriais.
*/
public class Main {
    //O metodo "main" é o ponto de partida, tudo começa aqui!
    public static void main(String[] args) {

    //Exibição do cabeçalho; Simula a inicialização de um sistema de informação.
        System.out.println("\n==============================================================================");
        System.out.println("             Sistema de monitoramento industrial - V01");
        System.out.println("==============================================================================");

    //Criar um laço (loop) para repetir a coleta de dados durante 5 ciclos.
    //Isso é somente uma simulação, na vida real iso rodaria infinitamente para monitorar a maquina.
    for (int i = 1; i <= 5; i++){
        System.out.println("\nLendo os dados do processo - ciclo: " + i + ".");

    //1- Coleca de dados
        double valorTemp = lerSenor("Temperatura_forno_01");


    //2- Tratamento e validação
        validarDadosSeg("Temperatura", valorTemp, 20, 80);

        try{
            Thread.sleep(2000);
        }catch (InterruptedException e){
            System.out.println("Erro no temporizador!");
        }
    }
        System.out.println("\n==============================================================================");
        System.out.println("                           Coleta finalizada");
        System.out.println("==============================================================================");
    }
    //Metodo especial 1
    public static double lerSenor(String tag){
        Random gerador = new Random();

    //Gerar de fato um numero entre 10.0 e 100 para simular a variação de temperatura real do processo
        double valorLido = 10 + (100 - 10) * gerador.nextDouble();
        return valorLido;
    }

    //Metodo especial 2
    public static void validarDadosSeg(String nomeSensor,double valor,double valorMinimo,double valorMaximo){
    //exibir o valor formatado com duas casas decimais
        System.out.printf("sensor: %s | Valor Atual: %.2f°C", nomeSensor, valor);

    //Logica de programação
    if (valor >= valorMinimo && valor <= valorMaximo){
        System.out.println("           >> Operação normal << ");
    }else {
        System.out.println("     >> Fora dos niveis de segurança <<");
    }

    }
}
