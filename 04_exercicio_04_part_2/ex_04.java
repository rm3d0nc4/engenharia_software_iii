/* 

Implementação problemática:
    - Forte acoplamento entre as classes
    - Baixo encapsulamento
    - Uma pessoa pode mudar de papel, ou ter papéis simultâneos;

*/

abstract class Pessoa {
    private String nome;
    private String endereco;

    public Pessoa(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
    }

    public String getNome() { return this.nome; }
    public String getEndereco() { return this.endereco; }

    public void setNome(String nome) { this.nome = nome; }
    public void setEndereco(String endereco) { this.endereco = endereco; }
}


class Tripulacao extends Pessoa {
    private String idTripulacao;

    public Tripulacao(String idTripulacao, String nome, String endereco) {
        super(nome, endereco);
        this.idTripulacao = idTripulacao;
    }

    public String getidTripulacao() { return this.idTripulacao; }
    public void setidTripulacao(String idTripulacao) { this.idTripulacao = idTripulacao; }
}

class Passageiro extends Pessoa {
    private String numeroSmiles;

    public Passageiro(String numeroSmiles, String nome, String endereco) {
        super(nome, endereco);
        this.numeroSmiles = numeroSmiles;
    }

    public String getnumeroSmiles() { return this.numeroSmiles; }
    public void setnumeroSmiles(String numeroSmiles) { this.numeroSmiles = numeroSmiles; }
}


class Agente extends Pessoa {
    private String idAgente;

    public Agente(String idAgente, String nome, String endereco) {
        super(nome, endereco);
        this.idAgente = idAgente;
    }

    public String getidAgente() { return this.idAgente; }
    public void setidAgente(String idAgente) { this.idAgente = idAgente; }
}

/* 

Solução:
    - Interface GettersESettersPessoa
    - Classes Tripulacao, Passageiro e Agente implementam GettersESettersPessoa
    - Classes Tripulacao, Passageiro e Agente têm uma Pessoa
    - Classes Tripulacao, Passageiro e Agente delegam os métodos de Pessoa para a Pessoa que têm

*/

public interface GettersESettersPessoa {
    public String getNome();
    public String getEndereco();
    public void setNome(String nome);
    public void setEndereco(String endereco);
}

class Pessoa implements GettersESettersPessoa {
    private String nome;
    private String endereco;

    public Pessoa(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
    }

    @Override
    public String getNome() { return this.nome; }
   
    @Override
    public String getEndereco() { return this.endereco; }

    @Override
    public void setNome(String nome) { this.nome = nome; }

    @Override
    public void setEndereco(String endereco) { this.endereco = endereco; }
}

class Tripulacao implements GettersESettersPessoa {
    private String idTripulacao;
    private Pessoa pessoa;

    public Tripulacao(String idTripulacao, String nome, String endereco) {
        this.idTripulacao = idTripulacao;
        this.pessoa = new Pessoa(nome, endereco);
    }

    @Override
    public String getNome() { return this.pessoa.getNome(); }
   
    @Override
    public String getEndereco() { return this.pessoa.getEndereco(); }

    @Override
    public void setNome(String nome) { this.pessoa.setNome(nome); }

    @Override
    public void setEndereco(String endereco) { this.pessoa.setEndereco(endereco); }

    public String getidTripulacao() { return this.idTripulacao; }
    public void setidTripulacao(String idTripulacao) { this.idTripulacao = idTripulacao; }
}

class Passageiro implements GettersESettersPessoa {
    private String numeroSmiles;
    private Pessoa pessoa;

    public Passageiro(String numeroSmiles, String nome, String endereco) {
        this.numeroSmiles = numeroSmiles;
        this.pessoa = new Pessoa(nome, endereco);
    }

    @Override
    public String getNome() { return this.pessoa.getNome(); }
   
    @Override
    public String getEndereco() { return this.pessoa.getEndereco(); }

    @Override
    public void setNome(String nome) { this.pessoa.setNome(nome); }

    @Override
    public void setEndereco(String endereco) { this.pessoa.setEndereco(endereco); }

    public String getnumeroSmiles() { return this.numeroSmiles; }
    public void setnumeroSmiles(String numeroSmiles) { this.numeroSmiles = numeroSmiles; }
}

class Agente implements GettersESettersPessoa {
    private String idAgente;
    private Pessoa pessoa;

    public Agente(String idAgente, String nome, String endereco) {
        this.idAgente = idAgente;
        this.pessoa = new Pessoa(nome, endereco);
    }

    @Override
    public String getNome() { return this.pessoa.getNome(); }
   
    @Override
    public String getEndereco() { return this.pessoa.getEndereco(); }

    @Override
    public void setNome(String nome) { this.pessoa.setNome(nome); }

    @Override
    public void setEndereco(String endereco) { this.pessoa.setEndereco(endereco); }

    public String getidAgente() { return this.idAgente; }
    public void setidAgente(String idAgente) { this.idAgente = idAgente; }
}