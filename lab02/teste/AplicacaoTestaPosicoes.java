package teste;
import java.util.ArrayList;
import java.util.Scanner;

import posicoes.PosicaoMapa4x4;

public class AplicacaoTestaPosicoes {
    private static int MAP_WIDTH = 4;
    private static int MAP_HEIGHT = 4;

    private static PosicaoMapa4x4 criaPonto(String p_num) {
        PosicaoMapa4x4 p = new PosicaoMapa4x4();
        Scanner kbd = new Scanner(System.in);
        int x, y;
        boolean firstExec = false;

        do {
            if(firstExec) {
                System.out.println( String.format("({0})> Erro: números não aceitáveis para X e Y.", p_num) );
                System.out.println(
                    String.format(
                        "({0})> Por favor digite números entre 0~{1} para x e 0~{2} para y.\n", 
                        p_num, MAP_WIDTH, MAP_HEIGHT
                    )
                );
            } else { firstExec = true; }

            System.out.print( String.format("({0})> Digite x: ", p_num) );
            x = kbd.nextInt();

            System.out.print( String.format("({0})> Digite y: ", p_num) );
            y = kbd.nextInt();

        } while( !(p.setX(x) && p.setY(y)) );

        p.imprime();
        kbd.close();

        return p;
    }

    private static String respostaSN(boolean teste) { return teste ? "sim" : "não"; }

    public static void main(String[] args) {
        PosicaoMapa4x4 p1 = criaPonto("P1");
        PosicaoMapa4x4 p2 = criaPonto("P2");

        final int distancia = p1.distancia(p2);
        System.out.println( String.format("Distância de P1 à P2 é de {0} blocos.", distancia) );

        PosicaoMapa4x4 p3 = p1.copy();

        System.out.println("P1 e P2 sobrepostos? " + respostaSN(PosicaoMapa4x4.estaoMesmaPosicao(p1, p2)));
        System.out.println("P2 e P3 sobrepostos? " + respostaSN(PosicaoMapa4x4.estaoMesmaPosicao(p2, p3)));
        System.out.println("P1 e P3 sobrepostos? " + respostaSN(PosicaoMapa4x4.estaoMesmaPosicao(p1, p3)));
    }

    private static void imprimeMapa(ArrayList<PosicaoMapa4x4> posm4x4) {

    }
}
