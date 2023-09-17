enum TipoRelacionamento {
    AMIGO,
    SEGUIDOR,
    BLOQUEADO
}

public class Relacionamento {
    private Usuario solicitante;
    private Usuario solicitado;
    private TipoRelacionamento relacionamento;
}

public class Usuario {
    private List<Relacionamento> relacionamentos;
    public void adicionarRelacionamento(Relacionamento relacionamento) {
        relacionamentos.add(relacionamento);
    }
}