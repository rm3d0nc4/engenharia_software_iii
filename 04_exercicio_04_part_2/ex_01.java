//A herança entre as classes não pode ser aproveitada 
// porque apesar de parecerem semelhantes, 
// a Conta Poupança possuirá um funcionamento diferente 
// da classe Conta Bancária, pois ela não é não é um tipo de 
// conta bancária, e sim uma conta com características especifícas.

public class ContaBancaria {
    private double saldo;

    public ContaBancaria(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    public void depositar(double valor) {
        saldo += valor;
    }

    public void sacar(double valor) {
        saldo -= valor;
    }
}

public class ContaPoupanca {
    private ContaBancaria contaBancaria;

    public ContaPoupanca(double saldoInicial) {
        this.contaBancaria = new ContaBancaria(saldoInicial);
    }

    public void depositar(double valor) {
        contaBancaria.depositar(valor);
    }

    public void sacar(double valor) {
        if (valor > 1000) {
            throw new RuntimeException("Não pode sacar mais de 1000 em uma poupança");
        }
        contaBancaria.sacar(valor);
    }
}