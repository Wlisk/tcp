package poligonos;

public class TrianguloIsosceles extends Triangulo {
    public TrianguloIsosceles(double face1, double face2, double face3) {
        super(face1, face2, face3);     
    }

    @Override
    public void imprimeTipoPoligono() {
        System.out.println("Triangulo Isosceles");
    }

    @Override
    public double calculaArea() {
        double base = getMaiorFace();
        double altura = calculaAltura();

        return (base * altura) / 2;
    }

    private double calculaAltura() {
        double maiorFace = getMaiorFace();
        double menorFace = getMenorFace();

        // menor^2 - (maior / 2)^2
        return Math.sqrt(Math.pow(menorFace, 2) - Math.pow(maiorFace / 2, 2));
    }

    private double getMaiorFace() { return Math.max(getFace1(), Math.max(getFace2(), getFace3())); }
    private double getMenorFace() { return Math.min(getFace1(), Math.max(getFace2(), getFace3())); }
}