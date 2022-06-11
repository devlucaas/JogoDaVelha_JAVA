public class Jogo{

    Jogador jogador1 = new Jogador();
    Jogador jogador2 = new Jogador();
    
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

    public String Vencedor(int numeroDeJogadas, String matriz[][]){
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
                    ganhador = "Primeiro Jogador Ganhou!!";
                }
                else if(vetor[i].equalsIgnoreCase("OOO")) {
                    ganhador = "Segundo Jogador Ganhou";
                }
            
            }
        }
        return ganhador;
    }
}