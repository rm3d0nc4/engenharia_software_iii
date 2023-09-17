
abstract class Conteudo {
    private String descricao;
}

class Post extends Conteudo {
    
}
class Post extends Conteudo {

}

public class Usuario {
    private List<Conteudo> conteudos;

    public void criarConteudo(Conteudo conteudo) {
        conteudos.add(conteudo);
    }

}