public interface Publicavel {
    public void exibir();
    public perfil getAutor();
}

public class Perfil {
    private int id;
    private String nomeUsuario;
    
    public Perfil(int id, String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
        this.id = id;
    }
    // Outros métodos
}

public class Postagem implements Publicavel {
    private String id;
    private Perfil autor;
    private String conteudo;
    private List<Reacao> reacoes = new ArrayList<>();
    private List<Comentario> comentarios = new ArrayList<>();

    public Postagem(String id, Perfil autor, String conteudo) {
        this.id = id;
        this.autor = autor;
        this.conteudo = conteudo;
    }
    
    @Override
    public void exibir() {
        System.out.println("Postagem [" + id + "] de " + autor.getNomeUsuario() +
        ": " + conteudo);
    }

    @Override
    public Perfil getAutor() {
        return this.autor;
    }
    // outros métodos
}

public class Reacao implements Publicavel {
    private String id;
    private Perfil autor;
    private String tipoReacao;

    public Reacao(String id, Perfil autor, String tipoReacao) {
        this.id = id;
        this.autor = autor;
        this.tipoReacao = tipoReacao;
    }

    @Override
    public void exibir() {
        System.out.println("Reação [" + tipoReacao + "] de " +
        getAutor().getNomeUsuario() + " na postagem " + getId();
    }


    @Override 
    public Perfil getAutor() {
        return this.autor;
    }

// outros métodos
}

public class Comentario implements Publicavel {
    private String id;
    private Perfil autor;
    private String conteudo;
    private Postagem postagemOriginal;

    public Comentario(String id, Perfil autor, String conteudo, Postagem postagemOriginal) {
        this.id = id;
        this.autor = autor;
        this.conteudo = conteudo;
        this.postagemOriginal = postagemOriginal;
    }

    @Override
    public void exibir() {
        System.out.println("Comentário de " + getAutor().getNomeUsuario() + " em
        resposta a postagem [" + postagemOriginal.getId() + "]: " + conteudo);
    }

    @Override
    public Perfil getAutor() {
        return this.autor;
    }
    // outros métodos
}