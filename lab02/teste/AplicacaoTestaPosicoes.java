package teste;
import java.util.ArrayList;
import java.util.Scanner;

import posicoes.PosicaoMapa4x4;

public class AplicacaoTestaPosicoes {
    private static final int MAP_WIDTH = 4;
    private static final int MAP_HEIGHT = 4;
    private static final Scanner kbd = new Scanner(System.in);
    private static final int DASHS = 50;

    //-----------------------------------------------------------------------------------------------------------------------------
    public static void dashLine() {
        System.out.print("\n");
        for(int i = 0; i < DASHS; ++i) {
            System.out.print("-");
        }
        System.out.print("\n\n");
    }

    //-----------------------------------------------------------------------------------------------------------------------------
    private static PosicaoMapa4x4 criaPonto(String pname) {
        final PosicaoMapa4x4 p = new PosicaoMapa4x4();
        int x, y;
        boolean firstExec = false;

        p.setName(pname);

        do {
            //-----------------------------------------------------------------------------------------------------------------------------
            if(firstExec) {
                System.out.println( String.format("(%s)> Erro: números não aceitáveis para X e Y.", p.getName()) );
                System.out.println(
                    String.format(
                        "(%s)> Por favor digite números entre 0~%s para x e 0~{2} para y.\n", 
                        p.getName(), MAP_WIDTH, MAP_HEIGHT
                    )
                );
            } else { firstExec = true; }

            //-----------------------------------------------------------------------------------------------------------------------------
            System.out.print( String.format("(%s)> Digite x: ", p.getName()) );
            x = kbd.nextInt();

            System.out.print( String.format("(%s)> Digite y: ", p.getName()) );
            y = kbd.nextInt();

            //-----------------------------------------------------------------------------------------------------------------------------
        } while( !(p.setX(x) && p.setY(y)) );

        p.imprime();

        return p;
    }

    //-----------------------------------------------------------------------------------------------------------------------------
    private static String checkDronesOnPos(ArrayList<PosicaoMapa4x4> drones, int x, int y) {
        int dronesOnPosCount = 0;
        String dronesOnPosName = null;

        for(int droneCnt = 0; droneCnt < drones.size(); ++droneCnt) {
            PosicaoMapa4x4 drone = drones.get(droneCnt);

            if(drone.getX() == x && drone.getY() == y)  {
                ++dronesOnPosCount;
                dronesOnPosName = drone.getName();
            } 
        }

        return (dronesOnPosCount > 1) ? "XX" : dronesOnPosName;
    }

    //-----------------------------------------------------------------------------------------------------------------------------
    private static void imprimeMapa(ArrayList<PosicaoMapa4x4> posm4x4) {
        for(int i = 0; i < MAP_HEIGHT; ++i) {
            for(int j = 0; j < MAP_WIDTH; ++j) {
                String name = checkDronesOnPos(posm4x4, i, j);

                if(name != null) System.out.print( String.format("[ %s ]", name) );
                else System.out.print("[    ]");
            }
            System.out.print("\n");
        }
    }

    //-----------------------------------------------------------------------------------------------------------------------------
    private static String respostaSN(boolean teste) { return teste ? "sim" : "não"; }

    private static String pStringSobrepostos(PosicaoMapa4x4 p1, PosicaoMapa4x4 p2) {
        return String.format("%s e %s sobrepostos? ", p1.getName(), p2.getName());
    }

    //-----------------------------------------------------------------------------------------------------------------------------
    public static void main(String[] args) {
        PosicaoMapa4x4 p1 = criaPonto("P1");
        dashLine();

        PosicaoMapa4x4 p2 = criaPonto("P2");
        dashLine();

        kbd.close();

        //-----------------------------------------------------------------------------------------------------------------------------
        final int distancia_p1p2 = p1.distancia(p2);
        System.out.println( String.format("Distância de %s à %s é de %d blocos.", p1.getName(), p2.getName(), distancia_p1p2 ) );
        
        PosicaoMapa4x4 p3 = p1.copy();
        p3.setName("P3");

        final int distancia_p1p3 = p1.distancia(p3);
        System.out.println( String.format("Distância de %s à %s é de %d blocos.", p1.getName(), p3.getName(), distancia_p1p3 ) );
        dashLine();

        //-----------------------------------------------------------------------------------------------------------------------------
        System.out.println(pStringSobrepostos(p1, p2) + respostaSN(PosicaoMapa4x4.estaoMesmaPosicao(p1, p2)));
        System.out.println(pStringSobrepostos(p2, p3) + respostaSN(PosicaoMapa4x4.estaoMesmaPosicao(p2, p3)));
        System.out.println(pStringSobrepostos(p1, p3) + respostaSN(PosicaoMapa4x4.estaoMesmaPosicao(p1, p3)));
        dashLine();

        //-----------------------------------------------------------------------------------------------------------------------------
        ArrayList<PosicaoMapa4x4> plist = new ArrayList<PosicaoMapa4x4>();
        plist.add(p1);
        plist.add(p2);
        plist.add(p3);

        imprimeMapa(plist);
    }
}
