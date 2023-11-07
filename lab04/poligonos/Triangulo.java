package poligonos;

public abstract class Triangulo implements Poligono {
    private double base;
    private double altura;
    private double[] face = {0.0f, 0.0f, 0.0f};

    public Triangulo() {
        resetBaseAltura();
    }

    public Triangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    public Triangulo(double face1, double face2, double face3) {
        face[0] = face1;
        face[1] = face2;
        face[2] = face3;
        resetBaseAltura();
    }

    private void resetBaseAltura() { this.base = this.altura = 0.0f; }

    public double calculaArea() {
        return (this.base * this.altura) / 2;
    }

    public static double calculaArea(double base, double altura) {
        return (base * altura) / 2;
    }

    public abstract void imprimeTipoPoligono();

    public void setBase(double value) { this.base = value; }
    public void setAltura(double value) { this.altura = value; }
    public void setFace1(double value) { this.face[0] = value; }
    public void setFace2(double value) { this.face[1] = value; }
    public void setFace3(double value) { this.face[2] = value; }

    public double getBase() { return this.base; }
    public double getAltura() { return this.altura; }
    public double getFace1() { return this.face[0]; }
    public double getFace2() { return this.face[1]; }
    public double getFace3() { return this.face[2]; }
}