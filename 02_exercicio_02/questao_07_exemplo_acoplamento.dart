

// Ignorar as classes Document Snapshot e FirebaseFirstore
// Foram criadas apenas para fim de simulação do repositório

class DocumentSnapshot {
  bool get exists => throw UnimplementedError();

  Map<String, dynamic> data() {
    throw UnimplementedError();
  }
}

class FirebaseFirestore {
  static FirebaseFirestore instance = FirebaseFirestore();

  collection(String s) {
    throw UnimplementedError();
  }
}


// =========================================================
// =========================================================


class Conta {
  String nome;
  String sobrenome;
  int idade;
  Conta({
    required this.nome,
    required this.sobrenome,
    required this.idade,
  });

  Map<String, dynamic> toMap() {
    // Lógica de mapeamento
    throw UnimplementedError();
  }

  factory Conta.fromMap(Map<String, dynamic> map) {
    // Lógica de mapeamento
    throw UnimplementedError();
  }
}

// Repositório e Aplicação acoplados

class RepositorioDeContas {
  final FirebaseFirestore firestore = FirebaseFirestore.instance;

  Future<String> criarConta(Conta conta) async {
    String docRef = await firestore.collection('contas').add(conta.toMap());

    return docRef;
  }

  Future<Conta> buscarConta(String docRef) async {
    DocumentSnapshot snapshot =
        await firestore.collection('contas').document(docRef).get();
    if (snapshot.exists) {
      return Conta.fromMap(snapshot.data());
    } else {
      throw Exception("Conta não existe");
    }
  }
}

class Aplicacao {
  RepositorioDeContas repositorioDeContas = RepositorioDeContas();

  Future<String> funcionalidadeCriarConta(Conta conta) {
    return repositorioDeContas.criarConta(conta);
  }

  Future<Conta> funcionalidadeBuscarConta(String id) {
    return repositorioDeContas.buscarConta(id);
  }
}

// Repositório e Aplicação desacoplados

abstract class ContratoRepositorioDeContas {
  Future<String> criarConta(Conta conta);
  Future<Conta> buscarConta(String id);
}

class RepositoriodeContasNoFirebase implements ContratoRepositorioDeContas {
  final FirebaseFirestore firestore = FirebaseFirestore.instance;

  @override
  Future<Conta> buscarConta(String id) async {
    DocumentSnapshot snapshot =
        await firestore.collection('contas').document(id).get();
    if (snapshot.exists) {
      return Conta.fromMap(snapshot.data());
    } else {
      throw Exception("Conta não existe");
    }
  }

  @override
  Future<String> criarConta(Conta conta) async {
    String docRef = await firestore.collection('contas').add(conta.toMap());

    return docRef;
  }
}

class AplicacaoRefatorada {
  ContratoRepositorioDeContas repositorioDeContas;
  AplicacaoRefatorada({
    required this.repositorioDeContas,
  });

  Future<String> funcionalidadeCriarConta(Conta conta) {
    return repositorioDeContas.criarConta(conta);
  }

  Future<Conta> funcionalidadeBuscarConta(String id) {
    return repositorioDeContas.buscarConta(id);
  }
}
