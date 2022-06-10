import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        Tabuleiro tabuleiro = new Tabuleiro();
        Jogador jogador1 = new Jogador();
        Jogador jogador2 = new Jogador(); 
        Jogo jogo = new Jogo();

        String posicao;
		int valida = 0;
		int contJogadas = 0;

            System.out.println("Jogador 1 digite seu nome:");
            jogador1.setNome(leitor.nextLine());

            System.out.println("Jogador 2 digite seu nome:");
            jogador2.setNome(leitor.nextLine());
            
            jogador1.setSimbolo("X");
            jogador2.setSimbolo("O");

        while(true) {
	    	System.out.print("--JOGO DA VELHA--\n");
	    	System.out.println();
	    	jogo.mostrarMatriz(tabuleiro.getMatriz());
	    	System.out.println();
	    	
	    	do {
	    		System.out.println("Posição de " + jogador1.getNome());
	    		posicao = leitor.nextLine();
	    		
	    		while(!jogo.ValidaPosicao(posicao, tabuleiro.getMatriz())) {
	    			System.out.println("Posição inválida, escolha outra jogada.");
	    			
	    			System.out.print("--JOGO DA VELHA--\n");
	    	    	System.out.println();
	    	    	jogo.mostrarMatriz(tabuleiro.getMatriz());
	    	    	System.out.println();
	    	    	
	    			System.out.println("Posição jogador 1: ");
		    		posicao = leitor.nextLine();
		    		valida = 0;
	    		}
	    		jogo.Jogar(posicao, tabuleiro.getMatriz(), jogador1.getSimbolo());
	    		valida = 1;
	    		
	    	}while(valida == 0);
	    	
	    	contJogadas ++;
	    	valida = 0;
	    	
	    	if(!jogo.Vencedor(contJogadas, tabuleiro.getMatriz()).equals("null")) {
	    		break;
	    	}
	    	////////////////////////////////jogador2////////////////////////////////////////////////
	    	do {
	    		System.out.println("Posição de " + jogador2.getNome());
	    		posicao = leitor.nextLine();
	    		
	    		while(!jogo.ValidaPosicao(posicao, tabuleiro.getMatriz())) {
	    			System.out.println("Posição inválida, escolha outra jogada.");
	    			
	    			System.out.print("--JOGO DA VELHA--\n");
	    	    	System.out.println();
	    	    	jogo.mostrarMatriz(tabuleiro.getMatriz());
	    	    	System.out.println();
	    	    	
	    			System.out.println("Posição de " + jogador2.getNome());
		    		posicao = leitor.nextLine();
		    		valida = 0;
	    		}
	    		jogo.Jogar(posicao, tabuleiro.getMatriz(), jogador2.getSimbolo());
	    		valida = 1;
	    		
	    	}while(valida == 0);
	    	
	    	////////////valida se venceu ou não 
	    	contJogadas ++;
	    	valida = 0;
	    	
	    	if(!jogo.Vencedor(contJogadas, tabuleiro.getMatriz()).equals("null")) {
	    		break;
	    	}
	   }
	   System.out.println("RESULTADO DO JOGO: " + jogo.Vencedor(contJogadas, tabuleiro.getMatriz()) );

	}

}

