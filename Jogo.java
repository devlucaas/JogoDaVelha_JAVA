import java.util.Random;
import java.util.Scanner;
public class Jogo{
    

    Maquina maquina = new Maquina();
    Tabuleiro tabuleiro = new Tabuleiro();
    Random random = new Random();

    int pontos = 0;
    int opcao = 0;
    int numero;
    Scanner entrada = new Scanner(System.in);
    
    public String name;
    
    public String mostrarMatriz(String matriz[][]){
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                System.out.print(matriz[i][j]);
                System.out.print (" | ");
             }
              System.out.println();
         }
         return null;
    }

    public boolean ValidaPosicao(String posicao, String matriz[][]){
		for(int i=0; i<3; i++) {
		   for(int j=0; j<3; j++) {
			   if(matriz[i][j].equals(posicao)) {
				   return true;
			   }
		   }
		}
		return false;
	}
    
    public int modoJogo(){
        
        do{
            System.out.println("---------------------------------------");
			System.out.println("      ESCOLHA SEU MODO DE JOGO:");
            System.out.println("---------------------------------------");
			System.out.println("1 - SINGLEPLAYER");
			System.out.println("2 - MULTIPLAYER");
			opcao = entrada.nextInt();
            
            if(opcao != 1 && opcao != 2)
                System.out.println("Opção inválida! Tente novamente");
        }while(opcao != 1 && opcao != 2);

        return opcao;
    }
    
    public void players(Jogador jogador1, Jogador jogador2){
        if(opcao == 1){
            System.out.println("Jogador 1 digite seu nome:");
            entrada.nextLine();
            jogador1.setNome(entrada.nextLine());

            jogador1.setSimbolo("X");
            maquina.setSimboloMaquina("O");
        }
        else if(opcao == 2){

            System.out.println("Jogador 1 digite seu nome:");
            entrada.nextLine();
            jogador1.setNome(entrada.nextLine());

            System.out.println("Jogador 2 digite seu nome:");

            jogador2.setNome(entrada.nextLine());
            
            jogador1.setSimbolo("X");
            jogador2.setSimbolo("O");
        }
    }
    public void playersMaquina(Jogador jogador1, Maquina maquina){
      
            System.out.println("Jogador 1 digite seu nome:");
            entrada.nextLine();
            jogador1.setNome(entrada.nextLine());

            jogador1.setSimbolo("X");
            maquina.setSimboloMaquina("O");
       
    }

    public void Jogar(String posicao, String matriz[][], String simboloJogador) {
        if(posicao.equals("1")) {
            matriz[0][0] = simboloJogador;
        }
        else if(posicao.equals("2")) {
            matriz[0][1] = simboloJogador;
        }
        else if (posicao.equals("3")) {
            matriz[0][2] = simboloJogador;
        }
        else if (posicao.equals("4")) {
            matriz[1][0] = simboloJogador;
        }
        else if (posicao.equals("5")) {
            matriz[1][1] = simboloJogador;
        }
        else if (posicao.equals("6")) {
            matriz[1][2] = simboloJogador;
        }
        else if (posicao.equals("7")) {
            matriz[2][0] = simboloJogador;
        }
        else if (posicao.equals("8")) {
            matriz[2][1] = simboloJogador;
        }
        else if (posicao.equals("9")) {
            matriz[2][2] = simboloJogador;
        }
    }
    
    public void jogadaAutomaticaN1(String posicao, String matriz[][], String simboloMaquina){
        

        if(posicao == "1"){
            matriz[0][0] = simboloMaquina;
        }
        else if(posicao == "2"){
            matriz[0][1] = simboloMaquina;
        }
        else if(posicao == "3"){
            matriz[0][2] = simboloMaquina;
        }
        else if(posicao == "4"){
            matriz[1][0] = simboloMaquina;
        }
        else if(posicao == "5"){
            matriz[1][1] = simboloMaquina;
        }
        else if(posicao == "6"){
            matriz[1][2] = simboloMaquina;
        }
        else if(posicao == "7"){
            matriz[2][0] = simboloMaquina;
        }
        else if(posicao == "8"){
            matriz[2][1] = simboloMaquina;
        }
        else if(posicao == "9"){
            matriz[2][2] = simboloMaquina;
        }
    }

    public String jogadaAutomaticaN2(String matriz[][], String simboloMaquina){
        String vetor[] = new String[8];
        //linhas 
        vetor[0] = matriz[0][0] + matriz[0][1];
        vetor[1] = matriz[1][0] + matriz[1][1];
        vetor[2] = matriz[2][0] + matriz[2][1];
        //colunas
        vetor[3] = matriz[0][0] + matriz[1][0];
        vetor[4] = matriz[0][1] + matriz[1][1];
        vetor[5] = matriz[0][2] + matriz[1][2];
        //diagonais
        vetor[6] = matriz[0][0] + matriz[1][1];
        vetor[7] = matriz[0][2] + matriz[1][1];
        
            //TESTE COM SIMBOLO X
            if(vetor[0].equalsIgnoreCase("XX")){
                matriz[0][2] = "O";
            }
            else if(vetor[1].equalsIgnoreCase("XX")) {
                matriz[1][2] = "O";
            }
            else if(vetor[2].equalsIgnoreCase("XX")) {
                matriz[2][2] = "O";
            }
            else if(vetor[3].equalsIgnoreCase("XX")) {
                matriz[1][1] = "O";
            }
            else if(vetor[4].equalsIgnoreCase("XX")) {
                matriz[1][2] = "O";
            }
            else if(vetor[5].equalsIgnoreCase("XX")) {
                matriz[2][2] = "O";
            }
            else if(vetor[6].equalsIgnoreCase("XX")) {
                matriz[2][2] = "O";
            }
            else if(vetor[7].equalsIgnoreCase("XX")) {
                matriz[1][2] = "O";
            }
            
            return jogadaAutomaticaN2(matriz, simboloMaquina);
        
        }
            
    

    public String Vencedor(int numeroDeJogadas, String matriz[][], Jogador jogador1, Jogador jogador2){
        
        String vetor[] = new String[8];
        String ganhador = "null";
        if (numeroDeJogadas == 9) {
            ganhador = "O jogo empatou";
        }
        else {
        
            //linhas 
            vetor[0] = matriz[0][0] + matriz[0][1] + matriz[0][2];
            vetor[1] = matriz[1][0] + matriz[1][1] + matriz[1][2];
            vetor[2] = matriz[2][0] + matriz[2][1] + matriz[2][2];
            //colunas
            vetor[3] = matriz[0][0] + matriz[1][0] + matriz[2][0];
            vetor[4] = matriz[0][1] + matriz[1][1] + matriz[2][1];
            vetor[5] = matriz[0][2] + matriz[1][2] + matriz[2][2];
            //diagonais
            vetor[6] = matriz[0][0] + matriz[1][1] + matriz[2][2];
            vetor[7] = matriz[0][2] + matriz[1][1] + matriz[2][0];
            
            for(int i = 0; i<vetor.length; i++) {
                if(vetor[i].equalsIgnoreCase("XXX")) {
                    ganhador = jogador1.getNome().toUpperCase();
                    
                    pontos +=1;
                    System.out.println(pontos);
                }
                else if(vetor[i].equalsIgnoreCase("OOO")) {
                    ganhador = jogador2.getNome().toUpperCase();
                    pontos +=1;
                    System.out.println(pontos);
                }
            }
        }
        return ganhador;
    }
    
    
    public String VencedorComMaquina(int numeroDeJogadas, String matriz[][], Jogador jogador1, Maquina maquina){
        
        String vetor[] = new String[8];
        String ganhador = "null";
        if (numeroDeJogadas == 10) {
            ganhador = "O jogo empatou";
        }
        else {
        
            //linhas 
            vetor[0] = matriz[0][0] + matriz[0][1] + matriz[0][2];
            vetor[1] = matriz[1][0] + matriz[1][1] + matriz[1][2];
            vetor[2] = matriz[2][0] + matriz[2][1] + matriz[2][2];
            //colunas
            vetor[3] = matriz[0][0] + matriz[1][0] + matriz[2][0];
            vetor[4] = matriz[0][1] + matriz[1][1] + matriz[2][1];
            vetor[5] = matriz[0][2] + matriz[1][2] + matriz[2][2];
            //diagonais
            vetor[6] = matriz[0][0] + matriz[1][1] + matriz[2][2];
            vetor[7] = matriz[0][2] + matriz[1][1] + matriz[2][0];
            
            for(int i = 0; i<vetor.length; i++) {
                if(vetor[i].equalsIgnoreCase("XXX")) {
                    ganhador = jogador1.getNome().toUpperCase();
                    pontos +=1;
                    System.out.println(pontos);
                }
                else if(vetor[i].equalsIgnoreCase("OOO")) {
                    ganhador ="computador".toUpperCase();
                    pontos +=1;
                    System.out.println(pontos);
                    
                }
            }
        }
        return ganhador;
    }
}