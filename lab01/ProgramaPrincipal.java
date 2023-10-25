public class ProgramaPrincipal {
    public static void dashLine(int dashs) {
        for(int i = 0; i < dashs; ++i) {
            System.out.print("-");
        }
        System.out.print("\n");
    }

    public static void blankLine() {
        System.out.println("");
    }

    public static void main(String[] args) {
        int DASHS = 50;

        Imovel im1 = new Imovel();
        Imovel im2 = new Imovel();
        Imovel im4 = new Imovel(3, 2, true, "Rua Beltrano 466", true, 300000);

        //---------------------------------------------------------------------------------
        im1.nQuartos = 2;
        im1.nBanheiros = 1;
        im1.temGaragem = false;
        im1.endereco = "Rua dos Fulanos, n. 0";
        im1.aluguel = true;
        im1.valorVenda = 142000;

        //---------------------------------------------------------------------------------
        im2.nQuartos = im1.nQuartos;
        im2.nBanheiros = im1.nBanheiros;
        im2.temGaragem = im1.temGaragem;
        im2.endereco = im1.endereco;
        im2.aluguel = im1.aluguel;
        im2.valorVenda = im1.valorVenda;

        //---------------------------------------------------------------------------------
        im1.imprimeDados();
        im1.valoriza(3.2);
        blankLine();

        im1.imprimeDados();
        double imposto = im1.calculaImposto();
        blankLine();

        System.out.println("Imposto im1: " + imposto);
        blankLine();

        //---------------------------------------------------------------------------------
        if (im1 == im2) {
            System.out.println("Mesmos imoveis!");
        } else {
            /*
             * Não são iguais pois ao instanciar as classes criamos novos objetos na memória, logo im1 é um objeto 
             * diferente the im2 na memória, mesmo que eles possuam o mesmo conteúdo. Note que não estamos comparando
             * conteúdo, mas sim se uma instância in memory é igual ou equivalente a outra, o que não ocorre neste caso.
             */
            System.out.println("im1 != im2: Imoveis distintos!");
        }
        dashLine(DASHS);

        //---------------------------------------------------------------------------------
        Imovel im3 = im1;
        im3.valorVenda = 0; // imóvel com perda total
        im3.imprimeDados();
        blankLine();
        im1.imprimeDados();
        /*
         * São iguais (apresentam o mesmo resultado) pois im1 e im3 referênciam o mesmo objeto. Podemos nos lembrar 
         * da linguagem C, e colocando como equivalente uma classe em Java (instanciada) ser um ponteiro em C,
         * ao passar o valor para a outra, isto é, im3 = im1, estamos copiando o endereço armazenado por im1 em im3,
         * logo im3 aponta para o mesmo objeto que im1 in memory. Portanto concluímos que im1 e im3 referenciam o
         * mesmo objeto in memory.
         */
        dashLine(DASHS);

        //---------------------------------------------------------------------------------
        im4.imprimeDados();
        im4.valoriza(10.0);
        blankLine();

        im4.imprimeDados();
        blankLine();

        im4.imprimeImposto();
    }
}