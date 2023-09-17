// ignore_for_file: public_member_api_docs, sort_constructors_first
// 8. Por que dizemos que o princípio ”Tell, don’t ask” mitiga problema de acoplamento.
// Demonstre.

//     Porque, ao aplicar o princípio "Tell, don’t ask", estamos limitando o conhecimento
//     da classe/dependência mais externa sobre detalhes da classe/dependência mais interna,
//     tornando a comunicação entres elas mais objetiva, consequentemente aumentando a coesão.

// Exemplo:

// Com implementação ”Tell, don’t ask”
class Album1 {
  late String _musicaAtual;
  late List<String> _musicas;
  late String _compositor;
  Album1({
    required String musicaAtual,
    required List<String> musicas,
    required String compositor,
  });

  void reproduzirMusica(String nomeMusica) {
    if (!_existeMusica(nomeMusica)) {
      throw Exception("Musica não existe");
    }
    this._musicaAtual = _musicas[_musicas.indexOf(nomeMusica)];
  }

  bool _existeMusica(String nomeMusica) {
    return _musicas.indexOf(nomeMusica) != -1;
  }
}

class ReprodutorMP31 {
  Album1 albumAtual;
  ReprodutorMP31({
    required this.albumAtual,
  });

  void reproduzirMusica(String nomeMusica) {
    albumAtual.reproduzirMusica(nomeMusica);
  }
}

// Sem implementação ”Tell, don’t ask”
class Album2 {
  late String _musicaAtual;
  late List<String> _musicas;
  late String _compositor;
  Album2({
    required String musicaAtual,
    required List<String> musicas,
    required String compositor,
  });

  void reproduzirMusica(String nomeMusica) {
    this._musicaAtual = _musicas[_musicas.indexOf(nomeMusica)];
  }

  bool existeMusica(String nomeMusica) {
    return _musicas.indexOf(nomeMusica) != -1;
  }
}

class ReprodutorMP32 {
  Album2 albumAtual;
  ReprodutorMP32({
    required this.albumAtual,
  });

  void reproduzirMusica(String nomeMusica) {
    if (albumAtual.existeMusica(nomeMusica)) {
      albumAtual.reproduzirMusica(nomeMusica);
    } else {
      throw Exception('"Musica não existe"');
    }
  }
}
