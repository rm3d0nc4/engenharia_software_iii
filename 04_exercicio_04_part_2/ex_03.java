import java.io.*;
public class Persistencia {
    public void salvar(String dados, String arquivo) throws IOException {
        try (FileWriter writer = new FileWriter(arquivo)) {
            writer.write(dados);
        }
    }
}

public class PersistenciaJSON {
    private Persistencia persistencia;

    public PersistenciaJSON(Persistencia persistencia) {
        this.persistencia = persistencia;
    }

    public void salvar(String dados, String arquivo) throws IOException {
        if (!dados.startsWith("{")) {
            throw new
            IllegalArgumentException("Dados não estão em formato JSON.");
        }
        persistencia.salvar(dados, arquivo);
    }
}