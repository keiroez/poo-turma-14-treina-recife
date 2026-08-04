# Programação Orientada a Objetos — Turma 14 (Treina Recife)

Repositório com todo o código escrito em aula no curso de **POO com Java**.
Cada aula fica em uma pasta própria, com o código-fonte em `src/`.

> 📌 **Dica para os alunos:** este repositório é atualizado a cada aula. Use `git pull` antes de cada encontro para receber o material novo.

---

## 📚 Aulas

| # | Aula | Tema | Código | Status |
|---|------|------|--------|--------|
| 1 | Fundamentos de POO | Classe, objeto, atributos, métodos, construtor, `this` | [`Aula_1_fundamentos_POO`](Aula_1_fundamentos_POO/src) | ✅ Disponível |
| 2 | Encapsulamento | `private`, getters e setters, validação nos setters | [`encapsulamento`](Aula_2_encapsulamento_POO/encapsulamento/src) | ✅ Disponível |
| 2 | Encapsulamento (prática) | Conta bancária: `Cliente`, `Conta`, `BigDecimal` | [`ContaBancaria`](Aula_2_encapsulamento_POO/contaBancaria/ContaBancaria/src) | ✅ Disponível |
| 3 | Herança | `extends`, `super`, reuso de código | [`Empresa`](Aula_3_heranca_POO/exercicio_pratico_heranca/Empresa/src) · [`Zoologico`](Aula_3_heranca_POO/exercicio_pratico_heranca/Zoologico/zoologico/src) | ✅ Disponível |
| 4 | Polimorfismo e Abstração | `abstract`, `@Override`, `final`, `instanceof` | [`banco`](Aula_4_polimorfismo_abstracao/banco/banco/src) · [`geometria`](Aula_4_polimorfismo_abstracao/formaGeometrica/geometria/src) · [`zoologico`](Aula_4_polimorfismo_abstracao/zoologico/src) | ✅ Disponível |
| 5 | Interfaces e Exceções | `interface`, `implements`, `throw`, `try/catch` | [`FormaPagamento`](Aula_5_interface_exceptions/FormaPagamento/src) | ✅ Disponível |
| 6 | Projeto final | Gerenciador de projetos e tarefas: pacotes, `enum`, `record`, DTOs | [`GerenciadorProjetos`](Aula_6_projeto_gerenciador_tarefas/GerenciadorProjetos/src) | ✅ Disponível |

## 📝 Atividades

| Atividade | Tema | Código |
|-----------|------|--------|
| 1 e 2 | Biblioteca — classes se relacionando, listas, validação | [`biblioteca`](atividade_1_2/biblioteca/src) |
| 3 e 4 | Sistema escolar — herança, abstração e polimorfismo | [`SistemaEscolar`](atividade_3_4/SistemaEscolar/src) |
| Final | Tela de gestão de tarefas — Java Swing + MVC | [`GestaoTarefas`](atividade_final/GestaoTarefas/src) |

---

## 🗂️ O que tem em cada aula

### Aula 1 — Fundamentos de POO
Primeiro contato com classes e objetos usando a classe `Livro`.

- `Livro.java` — atributos, construtor e métodos (`resumo()`, `contarPaginas()`)
- `App.java` — criação do objeto e chamada dos métodos

### Aula 2 — Encapsulamento
Duas partes:

**a) `encapsulamento/`** — `LivroEncapsulado.java` mostra atributos `private` acessados por getters e setters, com **validação** dentro do setter (ex.: não aceitar ano anterior a 1885 nem livro com menos de 2 páginas).

**b) `contaBancaria/`** — exercício prático com duas classes se relacionando:
- `Cliente.java` — dados do cliente (CPF sem setter, pois não deve mudar)
- `Conta.java` — `sacar()`, `depositar()` e `extrato()` usando `BigDecimal` para valores monetários
- `App.java` — programa principal

### Aula 3 — Herança
Dois exercícios de `extends` e `super`:

**a) `Empresa/`** — `Funcionario` é a classe mãe (com `calcularFGTS()`); `Gerente` acrescenta `bonus` e `Atendente` acrescenta `comissao`. Ambos chamam `super(nome, salario)` no construtor.

**b) `Zoologico/`** — `Animal` é a classe mãe (`comer()`, `emitirSom()`); `Mamifero`, `Ave` e `Reptil` herdam dela e acrescentam comportamento próprio (ex.: `Ave.voar()` só voa se `isVoador`).

### Aula 4 — Polimorfismo e Abstração
Três exercícios:

**a) `banco/`** — `Conta` é uma classe **abstrata**: `sacar()` e `depositar()` são `abstract` (cada filha implementa do seu jeito) e `imprimirExtrato()` é `final` (não pode ser sobrescrito). `ContaCorrente` cobra taxa de manutenção e `ContaPoupanca` tem sua própria regra. O `setSaldo()` é `protected` — só as filhas usam.
> A pasta também tem `FormularioComMascaras.java`, um exemplo extra de tela Swing com máscaras de CEP, telefone, CPF e data.

**b) `formaGeometrica/`** — `FormaGeometrica` abstrata com `calcularArea()`; `Quadrado`, `Circulo` e `Triangulo` implementam. O `App` guarda todas numa `List<FormaGeometrica>` e chama o mesmo método em todas — **polimorfismo na prática**.

**c) `zoologico/`** — versão do zoológico da Aula 3 agora com `Animal` abstrata: `Cachorro`, `Galinha` e `Cobra` são obrigados a implementar `comer()` e `emitirSom()`.

### Aula 5 — Interfaces e Exceções
`FormaPagamento/` — como programar para a interface, não para a implementação:

- `Pagavel.java` — interface com `pagar(BigDecimal valor)`
- `CobrarJuros.java` — segunda interface, com `calcularJuros()`
- `Boleto.java` — implementa só `Pagavel`
- `CartaoCredito.java` — implementa **as duas** interfaces, calcula parcelas e lança `LimiteExcedidoException` quando o valor passa do limite
- `App.java` — `try/catch` em volta do pagamento e uma `List<Pagavel>` recebendo qualquer forma de pagamento

### Aula 6 — Projeto final: Gerenciador de Projetos e Tarefas
`GerenciadorProjetos/` — projeto que junta tudo que foi visto no curso, agora **organizado em pacotes**:

```
src/
├── App.java              # monta o cenário: usuário, projeto e tarefa
├── enums/                # Prioridade, StatusProjeto, StatusTarefa, StatusUsuario
└── models/
    ├── Usuario.java      # tem uma List<Tarefa>
    ├── Projeto.java      # tem um responsável e uma List<Tarefa>
    ├── Tarefa.java       # ao ser criada, se registra no projeto e no usuário
    └── dto/              # ToDTOInterface<R> + records UsuarioDTO, ProjetoDTO, TarefaDTO
```

Conceitos novos que aparecem aqui:
- **`enum`** para representar estados fixos (`StatusTarefa.PENDENTE`, `Prioridade.ALTA`…) em vez de texto solto
- **`record`** para os DTOs — classes só de dados, escritas em uma linha
- **interface genérica** `ToDTOInterface<R>`, implementada por `Usuario`, `Projeto` e `Tarefa`
- **DTO** para expor só os campos necessários (o `UsuarioDTO`, por exemplo, não carrega a senha)
- **relacionamento nos dois sentidos**: o construtor de `Tarefa` já adiciona a si mesma na lista do projeto e do usuário

---

## 📝 O que tem em cada atividade

### Atividade 1 e 2 — Biblioteca
`atividade_1_2/biblioteca/` — encapsulamento e relacionamento entre objetos:
- `Livro.java` — valida o ano de publicação no construtor e controla o campo `disponivel`
- `Emprestimo.java` — só empresta livro disponível (senão lança `IllegalArgumentException`) e devolve com `devolver()`
- `Biblioteca.java` — guarda uma `List<Livro>`, lista os disponíveis e busca por título
- `App.java` — programa principal

### Atividade 3 e 4 — Sistema Escolar
`atividade_3_4/SistemaEscolar/` — herança, abstração e polimorfismo:
- `Pessoa.java` — classe abstrata com `apresentar()` e validação de idade
- `Aluno.java` e `Professor.java` — cada um sobrescreve `apresentar()` do seu jeito
- `Turma.java` — usa `instanceof` para contar alunos e imprimir só os professores
- `App.java` — percorre uma `List<Pessoa>` chamando o mesmo método em objetos diferentes

### Atividade final — Tela de Gestão de Tarefas (Swing + MVC)
`atividade_final/GestaoTarefas/` — a interface gráfica do projeto da Aula 6. As classes continuam as mesmas; o que muda é que agora elas ganham uma tela.

São **três cadastros**, um por aba, e a ordem importa:

1. **Usuário** — quem depois vira responsável
2. **Projeto** — escolhe um usuário como responsável
3. **Tarefa** — escolhe um projeto e um responsável já cadastrados

Não dá para cadastrar projeto sem usuário, nem tarefa sem projeto: é isso que mostra que os objetos estão relacionados de verdade.

O código está separado em **MVC** — cada camada com um trabalho:

| Camada | Pasta | Responsabilidade |
|--------|-------|------------------|
| Model | `models/` e `enums/` | guardar os dados (não conhece a tela) |
| View | `view/` | uma janela + um painel para cada aba |
| Controller | `controller/SistemaController.java` | validar, criar os objetos e guardar as listas |

Componentes Swing usados: `JFrame`, `JTabbedPane`, `JPanel`, `JLabel`, `JTextField`, `JComboBox`, `JButton`, `JTable` + `DefaultTableModel`, `JScrollPane` e `JOptionPane`.

> 📖 O projeto tem um [README próprio](atividade_final/GestaoTarefas/README.md) explicando o MVC passo a passo, o que cada componente faz e os desafios extras. O código-fonte está todo comentado.

---

## ▶️ Como rodar o código

Você precisa ter o **JDK 17 ou superior** instalado. Confira com:

```bash
java -version
```

### Opção 1 — VS Code (recomendado)

1. Instale a extensão **Extension Pack for Java** (Microsoft).
2. Abra a pasta do projeto que você quer executar (ex.: `Aula_1_fundamentos_POO`).
3. Abra o arquivo `App.java` e clique em **Run** acima do `main`.

> Importante: abra a pasta que contém o `src/`, não a raiz do repositório.

### Opção 2 — Terminal

Entre na pasta do projeto e execute:

```bash
cd Aula_1_fundamentos_POO
javac -d bin src/*.java
java -cp bin App
```

Trocando o caminho para o projeto desejado:

```bash
# Aula 2 — encapsulamento
cd Aula_2_encapsulamento_POO/encapsulamento
javac -d bin src/*.java && java -cp bin App

# Aula 2 — conta bancária
cd Aula_2_encapsulamento_POO/contaBancaria/ContaBancaria
javac -d bin src/*.java && java -cp bin App

# Aula 3 — empresa
cd Aula_3_heranca_POO/exercicio_pratico_heranca/Empresa
javac -d bin src/*.java && java -cp bin App

# Aula 3 — zoológico
cd Aula_3_heranca_POO/exercicio_pratico_heranca/Zoologico/zoologico
javac -d bin src/*.java && java -cp bin App

# Aula 4 — banco
cd Aula_4_polimorfismo_abstracao/banco/banco
javac -d bin src/*.java && java -cp bin App

# Aula 4 — formas geométricas
cd Aula_4_polimorfismo_abstracao/formaGeometrica/geometria
javac -d bin src/*.java && java -cp bin App

# Aula 4 — zoológico
cd Aula_4_polimorfismo_abstracao/zoologico
javac -d bin src/*.java && java -cp bin App

# Aula 5 — formas de pagamento
cd Aula_5_interface_exceptions/FormaPagamento
javac -d bin src/*.java && java -cp bin App

# Atividade 1 e 2 — biblioteca
cd atividade_1_2/biblioteca
javac -d bin src/*.java && java -cp bin App

# Atividade 3 e 4 — sistema escolar
cd atividade_3_4/SistemaEscolar
javac -d bin src/*.java && java -cp bin App
```

**A Aula 6 e a atividade final são diferentes**, porque o código está dividido em pacotes (`models`, `enums`, `view`...). Use `-sourcepath` para o compilador achar as classes dos outros pacotes:

```bash
# Aula 6 — gerenciador de projetos
cd Aula_6_projeto_gerenciador_tarefas/GerenciadorProjetos
javac -d bin -sourcepath src src/App.java && java -cp bin App

# Atividade final — tela Swing
cd atividade_final/GestaoTarefas
javac -d bin -sourcepath src src/App.java && java -cp bin App
```

> A pasta `bin/` guarda os arquivos `.class` gerados pela compilação. Você nunca precisa editar nada lá.

---

## 💻 Como baixar o repositório

```bash
git clone https://github.com/keiroez/poo-turma-14-treina-recife.git
cd poo-turma-14-treina-recife
```

Para atualizar depois de cada aula:

```bash
git pull
```

Se preferir não usar Git: clique em **Code → Download ZIP** aqui no GitHub.

---

## 🧭 Convenção das pastas

```
poo-turma-14-treina-recife/
├── Aula_1_fundamentos_POO/
│   ├── src/      # código-fonte (.java) — é aqui que você mexe
│   └── bin/      # arquivos compilados (.class)
├── Aula_2_encapsulamento_POO/
│   ├── encapsulamento/
│   └── contaBancaria/
├── Aula_3_heranca_POO/
│   └── exercicio_pratico_heranca/   # Empresa/ e Zoologico/
├── Aula_4_polimorfismo_abstracao/   # banco/, formaGeometrica/ e zoologico/
├── Aula_5_interface_exceptions/     # FormaPagamento/
├── Aula_6_projeto_gerenciador_tarefas/  # GerenciadorProjetos/ (com pacotes)
├── atividade_1_2/                   # biblioteca/
├── atividade_3_4/                   # SistemaEscolar/
└── atividade_final/                 # GestaoTarefas/ (tela Swing em MVC)
```

Em todos os projetos vale a mesma regra: **`src/` é o que você edita, `bin/` é gerado**.

---

## ❓ Dúvidas

Traga suas dúvidas na próxima aula ou abra uma [issue](https://github.com/keiroez/poo-turma-14-treina-recife/issues) aqui no repositório.

Bons estudos! 🚀
