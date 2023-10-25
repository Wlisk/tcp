public class Imovel {
    public int      nQuartos;
    public int      nBanheiros;
    public boolean  temGaragem;
    public String   endereco;
    public boolean  aluguel;
    public double   valorVenda;

    Imovel() {
        this.nQuartos = 0;
        this.nBanheiros = 0;
        this.temGaragem = false;
        this.endereco = "";
        this.aluguel = false;
        this.valorVenda = 0.0;
    }

    Imovel(int _nQuartos, int _nBanheiros, boolean _temGaragem, String _endereco, boolean _aluguel, double _valorVenda) {
        this.temGaragem = _temGaragem;
        this.nQuartos = _nQuartos;
        this.nBanheiros = _nBanheiros;
        this.endereco = _endereco;
        this.aluguel = _aluguel;
        this.valorVenda = _valorVenda;
    }

    private String temItem(boolean item) { return (item ? "sim" : "não"); }

    private double calculaPercValor(double perc, double valor) { return valor * (perc / 100); }

    public void imprimeDados() {
        System.out.println("Quartos: " + this.nQuartos);
        System.out.println("Banheiros: " + this.nBanheiros);
        System.out.println("Garagem: " + this.temItem(this.temGaragem));
        System.out.println("Endereço: " + this.endereco);
        System.out.println("Aluguel: " + this.temItem(this.aluguel));
        System.out.println("Valor: R$" + this.valorVenda);
    }

    public double calculaImposto() { 
        if(!this.aluguel) return 0.0;

        double percVenda = 12.0;
        double percAluguel = 8.0;

        double imposto = this.calculaPercValor(percVenda, this.valorVenda) + this.calculaPercValor(percAluguel, this.valorVenda);

        return imposto;
    }

    // aqui pressupõe se que perc já não está no formato decimal
    public void valoriza(double perc) {
        this.valorVenda += (this.valorVenda * (perc / 100));
    }

    public void imprimeImposto() {
        System.out.println("Imposto: " + this.calculaImposto());
    }
}
