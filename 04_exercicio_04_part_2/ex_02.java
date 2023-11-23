public class DadosCliente {
    private String nome;
    private String cpf;
    private String endereco;
    
    public DadosCliente(String nome, String cpf, String endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
    }
    // Métodos específicos do cliente...
}

public class Conta {
    private double saldo;
    private String numeroConta;
    private DadosCliente dadosCliente;

    public Conta(String numeroConta, double saldoInicial, DadosCliente dadosCliente) {
        this.numeroConta = numeroConta;
        this.saldo = saldoInicial;
        this.dadosCliente = dadosCliente;
    }
    
    public void depositar(double valor) {
        saldo += valor;
    }
    
    public void sacar(double valor) {
        if (valor > saldo) {
            throw new IllegalArgumentException("Saldo insuficiente.");
        }
        saldo -= valor;
    }
    // Outros métodos relevantes...
}