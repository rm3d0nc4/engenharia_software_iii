package questao_05_banco_srp;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
enum TipoInvestimento {
    RENDA_FIXA, RENDA_VARIAVEL
}
enum TipoTransacao {
    CREDITO, DEBITO
}
class ContaCorrente {
    private String numero;
    private double saldo;
    private List<Transacao> transacoes = new ArrayList<>();
    public ContaCorrente(String numero, double saldo) {
        this.numero = numero;
        this.saldo = saldo;
    }
    public String getNumero() {
        return numero;
    }
    public double getSaldo() {
        return saldo;
    }
}
class Investimento {
    private int id;
    private double valor;

    private double retorno;
    private TipoInvestimento tipo;
    public Investimento(int id, double valor, TipoInvestimento tipo) {

        this.id = id;
        this.valor = valor;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public double getRetorno() {return this.retorno;}
    public double getValor() {
        return valor;
    }
    public TipoInvestimento getTipo() {
        return tipo;
    }
}
class Transacao {
    private int id;
    private double valor;
    private Date data;
    private TipoTransacao tipo;
    public Transacao(int id, double valor, TipoTransacao tipo) {
        this.id = id;
        this.valor = valor;
        this.tipo = tipo;
        this.data = new Date();
    }
    public int getId() {return id;}
    public double getValor() {return valor;}
    public TipoTransacao getTipo() {return tipo;}
    public Date getData() {return data;}
}

class ContaCorrenteService {
    public List<Transacao> filtrarTransacoesInvalidas(List<Transacao> transacoes, Double saldo) {
        return transacoes.stream().filter(
                transacao -> transacao.getValor() > saldo ).toList();
    }
}

class InvestimentoService {
    public String avaliarRisco(Investimento investimento) {
        double variacaoPercentual = (investimento.getValor() - investimento.getRetorno()) / investimento.getValor();

        if(variacaoPercentual < 0.3) {
            return "BAIXO RISCO";
        } else if (variacaoPercentual < 0.5) {
            return "MEDIO RISCO";
        } else if (variacaoPercentual < 0.7) {
            return "ALTO RISCO";
        }
        return "ALTISSIMO RISCO";
    }
}

class TransacaoService {
    public boolean verificarFraude(Transacao transacao) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH");
        int hours = Integer.parseInt(dateFormat.format(transacao.getData()));
        return hours < 6 || hours > 23;
    }
}

