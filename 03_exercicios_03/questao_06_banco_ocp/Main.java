package questao_06_banco_ocp;

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

interface Auditavel {
    public void auditar();

}

class AuditoriaContaCorrente implements Auditavel {
    private ContaCorrente contaCorrente;
    public AuditoriaContaCorrente(ContaCorrente contaCorrente) {
        this.contaCorrente = contaCorrente;
    }
    @Override
    public void auditar() {
            // Auditoria para Conta Corrente
    }
}
class AuditoriaInvestimento implements Auditavel {
    private Investimento investimento;
    public AuditoriaInvestimento(Investimento investimento) {
        this.investimento = investimento;
    }
    @Override
    public void auditar() {
        // Auditoria para investimento...
    }
}
class AuditoriaTransacao implements Auditavel {
    private Transacao transacao;
    public AuditoriaTransacao(Transacao transacao) {
        this.transacao = transacao;
    }
    @Override
    public void auditar() {
        // Auditoria para Transacao...
    }
}
class AuditoriaFinanceiraService {
    public void executar(List<Auditavel> auditaveis) {
        for(Auditavel auditavel: auditaveis) {
            auditavel.auditar();
        }

    }
}
