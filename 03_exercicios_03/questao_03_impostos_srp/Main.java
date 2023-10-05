package questao_03_impostos_srp;

import java.util.List;
class ImpostoDeRenda {
    private String cpfContribuinte;
    private List<Double> rendimentos;
    private List<Double> despesas;
    public ImpostoDeRenda(String cpfContribuinte, List<Double> rendimentos, List<Double> despesas) {
        this.cpfContribuinte = cpfContribuinte;
        this.rendimentos = rendimentos;
        this.despesas = despesas;
    }

    public void processar() {
        CalculadoraImpostoDeRenda calculadoraImpostoDeRenda = new CalculadoraImpostoDeRenda();
        RelatorioImpostoDeRenda relatorioImpostoDeRenda = new RelatorioImpostoDeRenda();
        relatorioImpostoDeRenda.gerarRelatorio(this, calculadoraImpostoDeRenda.calcular(this.rendimentos, this.despesas));
    }
    public String getCpfContribuinte() {return this.cpfContribuinte;}
    public List<Double> getRendimentos() {return List.copyOf(this.rendimentos);}
    public List<Double> getDespesas() {return List.copyOf(this.despesas);}
}


class CalculadoraImpostoDeRenda {
    public Double calcular(List<Double> rendimentos, List<Double> despesas) {
        double rendaTotal =
                rendimentos.stream().mapToDouble(Double::doubleValue).sum();
        double despesaTotal =
                despesas.stream().mapToDouble(Double::doubleValue).sum();
        double baseCalculo = rendaTotal - despesaTotal;
        if (baseCalculo <= 1903.98) {
            return 0.0;
        }
        if (baseCalculo <= 2826.65) {
            return baseCalculo * 0.075 - 142.80;
        }
        // E assim por diante, para outros intervalos...
        return baseCalculo * 0.275 - 869.36; // Para bc acima de 4664.68
    }
}


class RelatorioImpostoDeRenda {
    public void gerarRelatorio(ImpostoDeRenda impostoDeRenda, Double impostoDevido) {
        System.out.println("CPF: " + impostoDeRenda.getCpfContribuinte());
        System.out.println("Rendimentos: " + impostoDeRenda.getRendimentos());
        System.out.println("Despesas: " + impostoDeRenda.getDespesas());
        System.out.println("Imposto Devido: " + impostoDevido);
    }

}