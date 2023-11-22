package src.main;

public class Calculator {
    public int add(int a, int b) {
        while (b != 0) {
            int carry = a & b;      // Calcula os bits de carry
            a = a ^ b;              // Soma sem considerar o carry
            b = carry << 1;         // Desloca o carry para a esquerda
        }
        return a;
    }

    public int divide(int a, int b) {
        return a / b;
    }
}