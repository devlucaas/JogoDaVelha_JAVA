public class Tabuleiro {
    public String matriz[][] = {{"1","2","3"},{"4","5","6"},{"7","8","9"}};

    public Tabuleiro(){
    }

    public Tabuleiro(String[][] matriz) {
        this.matriz = matriz;
    }

    public String[][] getMatriz() {
        return matriz;
    }

    public void setMatriz(String[][] matriz) {
        this.matriz = matriz;
    }  
}
    