//ALUNOS:
//LUCAS SANTOS E JOYCE AVELINO
import java.util.Random;
import java.util.Scanner;

public class main {
	
  public static Scanner leitor = new Scanner(System.in);
  public static void main(String[] args) {
		
      Tabuleiro tabuleiro = new Tabuleiro();
      Jogador jogador1 = new Jogador();
      Jogador jogador2 = new Jogador(); 
	  Maquina maquina = new Maquina();
      Jogo jogo = new Jogo();

      String posicao;
	  int opc;
	  int valida = 0;
	  int contJogadas = 0;
	  String novamente = "sim";
	  
		
		//jogo.modoJogo();
		//jogo.players(jogador1, jogador2);
		do{
		jogo.modoJogo();

		//---CASO ESCOLHIDO SEJA SINGLEPLAYER
		if(jogo.opcao == 1){ 
			jogo.playersMaquina(jogador1, maquina);
			System.out.print("--JOGO DA VELHA--\n");
			while(true) {
				
				System.out.println();
				jogo.mostrarMatriz(tabuleiro.getMatriz());
				System.out.println();
				
				do {
					System.out.println("Posição de " + jogador1.getNome() + "(X)");
					posicao = leitor.nextLine();
					
					while(!jogo.ValidaPosicao(posicao, tabuleiro.getMatriz())) {
						System.out.println("Posição inválida, escolha outra jogada.");
						
						System.out.print("--JOGO DA VELHA--\n");
						System.out.println();
						jogo.mostrarMatriz(tabuleiro.getMatriz());
						System.out.println();
						
						System.out.println("Posição de " + jogador1.getNome());
						posicao = leitor.nextLine();
						valida = 0;
					}
					jogo.Jogar(posicao, tabuleiro.getMatriz(), jogador1.getSimbolo());
					valida = 1;
					
				}while(valida == 0);
				
				contJogadas ++;
				valida = 0;
				
				if(!jogo.VencedorComMaquina(contJogadas, tabuleiro.getMatriz(), jogador1, maquina).equals("null")) {
					break;
				}
				////////////////////////////////MAQUINA////////////////////////////////////////////////
				do {
					System.out.println("Posição da MÁQUINA (O)");
					Random random = new Random();
					int numero = random.nextInt(9)+1;
			        posicao = String.valueOf(numero);
			        System.out.println(posicao);
					jogo.jogadaAutomaticaN1(posicao,tabuleiro.getMatriz(), maquina.getSimboloMaquina());
					
					while(!jogo.ValidaPosicao(posicao, tabuleiro.getMatriz())) {
						System.out.println("Posição inválida, escolha outra jogada.");
						
				        
						
						System.out.println();
						jogo.mostrarMatriz(tabuleiro.getMatriz());
						System.out.println();
						
						System.out.println("Posição da MÁQUINA (O)");
						numero = random.nextInt(9)+1;
				        posicao = String.valueOf(numero);
				        System.out.println(posicao);
				        
						valida = 0;
					}
					jogo.Jogar(posicao, tabuleiro.getMatriz(), maquina.getSimboloMaquina());
					valida = 1;
					
				}while(valida == 0);
				
				////////////valida se venceu ou n�o 
				contJogadas ++;
				valida = 0;
				
				if(!jogo.VencedorComMaquina(contJogadas, tabuleiro.getMatriz(), jogador1, maquina).equals("null")) {
					break;
				}
		   }
			System.out.println("GANHADOR: " + jogo.VencedorComMaquina(contJogadas, tabuleiro.getMatriz(), jogador1, maquina) );
			System.out.println(jogo.VencedorComMaquina(contJogadas, tabuleiro.getMatriz(), jogador1, maquina)+" TEM " + jogo.pontos + " PONTOS(S)" );

		}

		//----CASO ESCOLHIDO SEJA MULTIPLAYER
	  else if(jogo.opcao == 2){ 
		  
	  jogo.players(jogador1, jogador2);
	  System.out.print("-JOGO DA VELHA-\n");
      while(true) {
			
	    	
	    	System.out.println();
	    	jogo.mostrarMatriz(tabuleiro.getMatriz());
	    	System.out.println();
	    	
	    	do {
	    		System.out.println("Posição de " + jogador1.getNome() + "(X)");
	    		posicao = leitor.nextLine();
	    		
	    		
	    		while(!jogo.ValidaPosicao(posicao, tabuleiro.getMatriz())) {
	    			
	    			System.out.println("Posição inválida, escolha outra jogada.");
	    			
	    	    	System.out.println();
	    	    	jogo.mostrarMatriz(tabuleiro.getMatriz());
	    	    	System.out.println();
	    	    	
	    			System.out.println("Posição de " + jogador1.getNome() + "(X)");
		    		posicao = leitor.nextLine();
		    		valida = 0;
	    		}
	    		jogo.Jogar(posicao, tabuleiro.getMatriz(), jogador1.getSimbolo());
	    		
	    		System.out.println();
	    		jogo.mostrarMatriz(tabuleiro.getMatriz());
	    		System.out.println();
	    		
	    		valida = 1;
	    		
	    	}while(valida == 0);
	    	
	    	contJogadas ++;
	    	valida = 0;
	    	
	    	if(!jogo.Vencedor(contJogadas, tabuleiro.getMatriz(), jogador1, jogador2).equals("null")) {
	    		break;
	    	}
	    	
	    	////////////////////////////////jogador2////////////////////////////////////////////////
	    	
	    	do {
	    		System.out.println("Posição de " + jogador2.getNome() + "(O)");
	    		posicao = leitor.nextLine();
	    		
	    		while(!jogo.ValidaPosicao(posicao, tabuleiro.getMatriz())) {
	    			System.out.println("Posição inválida, escolha outra jogada.");
	    			
	    			
	    	    	System.out.println();
	    	    	jogo.mostrarMatriz(tabuleiro.getMatriz());
	    	    	System.out.println();
	    	    	
	    			System.out.println("Posição de " + jogador2.getNome() + "(O)");
		    		posicao = leitor.nextLine();
		    		valida = 0;
	    		}
	    		jogo.Jogar(posicao, tabuleiro.getMatriz(), jogador2.getSimbolo());
	    		valida = 1;
	    		
	    	}while(valida == 0);
	    	
	    	////////////valida se venceu ou não 
	    	contJogadas ++;
	    	valida = 0;
	    	
	    	if(!jogo.Vencedor(contJogadas, tabuleiro.getMatriz(), jogador1, jogador2).equals("null")) {
	    		break;
	    	}
	    	
	   }
       
	   System.out.println("GANHADOR: " + jogo.Vencedor(contJogadas, tabuleiro.getMatriz(), jogador1, jogador2) );
	   System.out.println(jogo.Vencedor(contJogadas, tabuleiro.getMatriz(), jogador1, jogador2)+" TEM " + jogo.pontos + " PONTOS(S)" );

	   System.out.println("Gostaria de jogar novamente? (sim ou nao)");
	   novamente = leitor.nextLine();
		}
		
		}while(novamente.equalsIgnoreCase("sim"));
	}	
}