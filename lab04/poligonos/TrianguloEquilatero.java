package poligonos;

public class TrianguloEquilatero extends Triangulo {
    public TrianguloEquilatero(double face1, double face2, double face3) {
        super(face1, face2, face3);       
    }

    @Override
    public void imprimeTipoPoligono() {
        System.out.println("Triangulo Equilatero");
    }

    @Override
    public double calculaArea() {
        return (Math.sqrt(3) / 4) * Math.pow(getFace1(), 2);
    }
}