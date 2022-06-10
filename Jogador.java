public class Jogador {
    private String nome;
    private String simbolo;
    
    public Jogador(){
    }

    public Jogador(String nome, String simbolo) {
        this.nome = nome;
        this.simbolo = simbolo; 
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSimbolo() {
        return this.simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }
 
}