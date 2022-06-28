//ALUNOS:
//LUCAS SANTOS E JOYCE AVELINO
import java.util.Random;
import java.util.Scanner;
import javax.swing.*;

public class main {
	
  public static Scanner leitor = new Scanner(System.in);
  public static void main(String[] args) {
		
      Tabuleiro tabuleiro = new Tabuleiro();
      Jogador jogador1 = new Jogador();
      Jogador jogador2 = new Jogador(); 
	  Maquina maquina = new Maquina();
      Jogo jogo = new Jogo();
	  ImageIcon icon = new ImageIcon("jogovelha_img.png");
	  
	  String vencedor = "";
	  String interfaceTabuleiro;
      String posicao;
	  int opc;
	  int valida = 0;
	  int contJogadas = 0;
	  int novamente = 0;
	  String vencedorComMaquina = "";
	  

	  
		do{
		interfaceTabuleiro = jogo.mostrarMatriz(tabuleiro.getMatriz());

		JOptionPane.showMessageDialog(null, interfaceTabuleiro, "JOGO DA VELHA", JOptionPane.INFORMATION_MESSAGE, icon);
			
		jogo.modoJogo();
		
		//new Interface();

		//---CASO ESCOLHIDO SEJA SINGLEPLAYER
		if(jogo.opcao == 1){ 
			
			jogo.playersMaquina(jogador1, maquina);
			System.out.print("--JOGO DA VELHA--\n");
			while(true) {
				
				System.out.println();
				
				//JOptionPane.showMessageDialog(null, jogo.mostrarMatriz(tabuleiro.getMatriz()));
				
				System.out.println();
				
				do {
					posicao = JOptionPane.showInputDialog(null, "Posicão de " + jogador1.getNome() + "(X)");
					//System.out.println("Posição de " + jogador1.getNome() + "(X)");
					//posicao = leitor.nextLine();
					
					while(!jogo.ValidaPosicao(posicao, tabuleiro.getMatriz())) {
						System.out.println("Posição inválida, escolha outra jogada.");
						
						System.out.print("--JOGO DA VELHA--\n");
						System.out.println();
						jogo.mostrarMatriz(tabuleiro.getMatriz());
						System.out.println();
						
						posicao = JOptionPane.showInputDialog(null, "Posicão de " + jogador1.getNome() + "(X)");
						valida = 0;
					}
					jogo.Jogar(posicao, tabuleiro.getMatriz(), jogador1.getSimbolo());
					valida = 1;
					
				}while(valida == 0);
				
				contJogadas ++;
				valida = 0;
				
				vencedorComMaquina = jogo.VencedorComMaquina(contJogadas, tabuleiro.getMatriz(), jogador1, maquina);
				if(!vencedorComMaquina.equals("null")) {
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
				
				if(!vencedorComMaquina.equals("null")) {
					break;
				}
		   }
			System.out.println("GANHADOR: " + vencedorComMaquina );
			System.out.println(vencedorComMaquina +" TEM " + jogo.pontos + " PONTOS(S)" );

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
	    		posicao = JOptionPane.showInputDialog(null, "Posicão de " + jogador1.getNome() + "(X)");
	  
	    		
	    		
	    		while(!jogo.ValidaPosicao(posicao, tabuleiro.getMatriz())) {
	    			
	    			System.out.println("Posição inválida, escolha outra jogada.");
	    			
	    	    	System.out.println();
	    	    	jogo.mostrarMatriz(tabuleiro.getMatriz());
	    	    	System.out.println();
	    	    	
	    			posicao = JOptionPane.showInputDialog(null, "Posicão de " + jogador1.getNome() + "(X)");
		  
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
	    	
			vencedor = jogo.Vencedor(contJogadas, tabuleiro.getMatriz(), jogador1, jogador2);

	    	if(!vencedor.equals("null")) {
	    		break;
	    	}
	    	
	    	////////////////////////////////jogador2////////////////////////////////////////////////
	    	
	    	do {
	    		posicao = JOptionPane.showInputDialog(null, "Posicão de " + jogador2.getNome() + "(X)");
	    		
	    		while(!jogo.ValidaPosicao(posicao, tabuleiro.getMatriz())) {
	    			System.out.println("Posição inválida, escolha outra jogada.");
	    			
	    			
	    	    	System.out.println();
	    	    	jogo.mostrarMatriz(tabuleiro.getMatriz());
	    	    	System.out.println();
	    	    	
	    			posicao = JOptionPane.showInputDialog(null, "Posicão de " + jogador2.getNome() + "(X)");
	    		
		    		valida = 0;
	    		}
	    		jogo.Jogar(posicao, tabuleiro.getMatriz(), jogador2.getSimbolo());
	    		valida = 1;
	    		
	    	}while(valida == 0);
	    	
	    	////////////valida se venceu ou não 
	    	contJogadas ++;
	    	valida = 0;
	    	
	    	if(!vencedor.equals("null")) {
	    		break;
	    	}
	    	
	   }
       
	   JOptionPane.showMessageDialog(null, "GANHADOR: " + vencedor);
	   
	   JOptionPane.showMessageDialog(null, vencedor +" TEM " + jogo.pontos + " PONTOS(S)" );

	   
	   novamente = JOptionPane.showConfirmDialog(null, "Gostaria de jogar novamente? (sim ou nao)");
		}
		
		}while(novamente == 0);
	}

}