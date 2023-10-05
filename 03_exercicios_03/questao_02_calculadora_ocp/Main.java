package questao_02_calculadora_ocp;
import java.util.ArrayList;
import java.util.List;
class Calculadora {
    private final double a;
    private final double b;
    public Calculadora(double a, double b) {
        this.a = a;
        this.b = b;
    }
    public List<Double> calcular(List<Operacao> operacoes) {
        List<Double> resultados = new ArrayList<>();
        for (Operacao operacao : operacoes) {
            resultados.add(operacao.executar(a, b));
        }
        return resultados;
    }
}


interface Operacao {
    public double executar(double a, double b);
}


class Soma implements Operacao {
    @Override
    public double executar(double a, double b) {
        return a + b;
    }
}

class Subtracao implements Operacao {
    @Override
    public double executar(double a, double b) {
        return a - b;
    }
}
class Multiplicacao implements Operacao {
    @Override
    public double executar(double a, double b) {
        return a * b;
    }
}