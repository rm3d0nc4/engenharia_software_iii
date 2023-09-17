

// Coincidente (pior): Há nenhuma (ou pouca) relação construtiva entre os elementos de um módulo

public class Kakaroto {
    public void voar() {
        // lógica do voo
    }

    public double lancarPoder(List<Poder> poderes, int indice) {
        // logica de lancamento de poder
    }

    public string vestirRoupa(Roupa roupa) {
        // logica de vestimento da roupa
    }
}

public class Ave extends Kakaroto { // Aproveitar o método voar
    // logica da ave
}

// Lógico: Um módulo faz um conjunto de funções relacionadas, uma das quais é escolhida
// através de um parâmetro ao chamar o módulo 

    public class Produto {
        public String nome;
        public String tipoDeProduto;
        public double valor;
    }


    public class Pedido {
        List<Produto> produtos = [];

        public void adicionarProduto(Produto produtos) {
            // logica para adicionar produto
        }

        public double calcularDescontoTotal() {
            double descontoTotal = 0;
            for(Produto produto : this.produtos) {
                if(tipoDeProduto == 'tipo1') {
                    // Calcular desconto 1
                } else if (tipoDeProduto == 'tipo2') {
                    // Calcular desconto 1
                } else {
                    // Calcular desconto 3
                }
            }

            return descontoTotal
        }
        //...
    }




// Temporal: Elementos estão agrupados no mesmo módulo porque são processados no mesmo
// intervalo de tempo 

public class Compra {
    List<Produto> produtos = [];

    public double calcularValorTotal() {
        // Lógica para calcular valor total
    }

    public double aplicarDescontos() {
        // Lógica para calcular descontos
    }

    public boolean efetuarPagamento(FormaDePagamato forma) {
        // Lógica para pagamentos
    }

    public string gerarNotaFiscal() {
        // Lógica para geração de nota fiscal
    }
    //...
}


// Procedural: Associa elementos de acordo com seus relacionamentos procedurais ou algorítmicos.
// Depende muito da aplicação sendo tratada

public class Cliente {
    public string nome;
    public strin cpf;
    public string numeroDoCalcado;
    //...
}


public class LojaDeCalcados {
    public List<Cliente> clientes = [];
    
    public int getNumeroDeCalcadoMaisFrequente() {
        // Lógica de busca do número de calcados
    }
    //...
}


// De comunicação: Todas as operações de um módulo operam no mesmo conjunto de dados e/ou
// produzem o mesmo tipo de dado de saída 

public class UtilitariosDeOrdenacao {
    public void ordenar(int[] array) {
        // lógica de ordenação
    }
    public void embaralhar(int[] array) {
        // lógica de ordenação
    }
}

// Sequencial: A saída de um elemento de um módulo serve de entrada para o próximo elemento 

public class Emprestimo {
    private double valorEmprestimo;
    private int quantidadeParcelas;
    private int quantidadeParcelasPagas;

    public double calcularValorParcela() {
        // Lógica para calcularValor da parcela;
    }

    public double aplicarJurosParcela(double valorParcela, double taxaDeJuros) {
        // Lógica de aplicação de juros 
    }

    public double aplicarImpostosParcela(double valorParcelaComJuros, List<Imposto> impostos) {
        // Lógica de aplicação de impostos
    }

    public void pagarParcela(double parclaComJurosMaisImpostos) {
        // Lógica de pagamento
    }
}


// Funcional (melhor): Um módulo tem coesão funcional se as operações do módulo puderem ser descritas
// numa única frase de forma coerente 


public interface NomeAlteravel {
    public void alterarNome(String novoNome);
}

public interface EmailAlteravel {
    public void alterarEmail(String novoEmail);
}
public interface SenhaAlteravel {
    public void alterarSenha(String novaSenha);
}

public interface EnderecoAlteravel(Endereco novoEndereco) {

}

abstract class Usuario {
    private String nome;
    private String email;
    private String senha;
    private Endereco endereco;
}

public class Cliente extends Usuario implements NomeAlteravel, SenhaAlteravel {

    @Override
    public void alterarNome(String novoNome) {
        // Logica de alteração nome;
    }

    @Overrid
    public void alterarSenha(String novaSenha) {
        // Logica de alteracao de senha
    }

}