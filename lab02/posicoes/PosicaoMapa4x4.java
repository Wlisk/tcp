package posicoes;

import java.lang.Math;

public class PosicaoMapa4x4 {
    private int x, y;
    private static int numPosicoesOcupadas;

    //--------------------------------------------------------------------
    public PosicaoMapa4x4() {
        this.reset();
        ++numPosicoesOcupadas;
    }

    public PosicaoMapa4x4(int x, int y) {
        this.x = x;
        this.y = y;
        ++numPosicoesOcupadas;
    }

    //--------------------------------------------------------------------
    private boolean estaNoSet(int pos) { return (pos >= 0 && pos < 4); }

    private void reset() { this.x = this.y = 0; }

    //--------------------------------------------------------------------
    public int getX() { return this.x; }

    public int getY() { return this.y; }

    public boolean setX(int x) { 
        if( this.estaNoSet(x) ) {
            this.x = x;
            return true;
        }
        this.reset();
        return false;
    }

    public boolean setY(int y) { 
        if( this.estaNoSet(y) ) {
            this.y = y;
            return true;
        }
        this.reset();
        return false;
    }

    //--------------------------------------------------------------------
    public PosicaoMapa4x4 copy() { return new PosicaoMapa4x4(this.x, this.y); }

    public void imprime() {
        System.out.println(String.format("({0}, {1})", this.x, this.y));
    }

    public int distancia(PosicaoMapa4x4 p) { 
        final int dis_x = this.x - p.getX();
        final int dis_y = this.y - p.getY();

        return Math.abs(dis_x) + Math.abs(dis_y);
    }

    //--------------------------------------------------------------------
    public static int getNumPosicoesOcupadas() { return numPosicoesOcupadas; }

    public static boolean estaoMesmaPosicao(PosicaoMapa4x4 p1, PosicaoMapa4x4 p2) { 
        return (p1.x == p2.x && p1.y == p2.y);
    }

}
