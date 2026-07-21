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
| 3 | Herança | `extends`, reuso de código, `super` | — | 🔜 Em breve |
| 4 | Polimorfismo e Abstração | Sobrescrita de métodos, classes abstratas | — | 🔜 Em breve |
| 5 | Interfaces e Exceções | `interface`, `implements`, `try/catch`, `throw` | — | 🔜 Em breve |
| 6 | Projeto | Projeto final aplicando tudo que foi visto | — | 🔜 Em breve |

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

---

## ▶️ Como rodar o código

Você precisa ter o **JDK 17 ou superior** instalado. Confira com:

```bash
java -version
```

### Opção 1 — VS Code (recomendado)

1. Instale a extensão **Extension Pack for Java** (Microsoft).
2. Abra a pasta da aula que você quer executar (ex.: `Aula_1_fundamentos_POO`).
3. Abra o arquivo `App.java` e clique em **Run** acima do `main`.

### Opção 2 — Terminal

Entre na pasta da aula e execute:

```bash
cd Aula_1_fundamentos_POO
javac -d bin src/*.java
java -cp bin App
```

Trocando o caminho para a aula desejada:

```bash
# Aula 2 — encapsulamento
cd Aula_2_encapsulamento_POO/encapsulamento
javac -d bin src/*.java && java -cp bin App

# Aula 2 — conta bancária
cd Aula_2_encapsulamento_POO/contaBancaria/ContaBancaria
javac -d bin src/*.java && java -cp bin App
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
└── Aula_2_encapsulamento_POO/
    ├── encapsulamento/
    └── contaBancaria/
```

---

## ❓ Dúvidas

Traga suas dúvidas na próxima aula ou abra uma [issue](https://github.com/keiroez/poo-turma-14-treina-recife/issues) aqui no repositório.

Bons estudos! 🚀
