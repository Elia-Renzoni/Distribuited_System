/*
 *  @author Elia Renzoni
 *  @date 14/10/2023
 *  @brief Fibonacci Class
 */

public class Fibonacci {
    private int limiteSuccessione;
    private int nuovoNumero;

    public Fibonacci(int limite) {
        this.limiteSuccessione = limite;
    }

    public void fibonacci(int penultimo, int ultimo) {
        this.nuovoNumero = penultimo + ultimo;
        if (this.nuovoNumero < this.limiteSuccessione) {
            fibonacci(ultimo, this.nuovoNumero);
        }
    }

    public int getFibonacciNum() {
        return this.nuovoNumero;
    }
}
