# Atividade Final — Tela de Gestão de Tarefas (Java Swing + MVC)

Interface gráfica para o **Gerenciador de Projetos e Tarefas** da Aula 6.
As classes `Usuario`, `Projeto` e `Tarefa` continuam as mesmas — o que muda é que agora elas ganham um **rosto**.

O sistema tem **três cadastros**, em três abas, e a ordem importa:

```
   1. Usuário  ─────┐
                    ├──►  3. Tarefa   (vinculada a um projeto e a um usuário)
   2. Projeto  ─────┘
      (escolhe um usuário como responsável)
```

Você não consegue cadastrar um projeto sem ter um usuário, nem uma tarefa sem ter um projeto — o sistema avisa. Isso é de propósito: é o que mostra que os objetos estão **relacionados de verdade**.

---

## ▶️ Como rodar

Precisa do **JDK 17 ou superior**.

**VS Code (recomendado):** abra a pasta `GestaoTarefas`, abra `src/App.java` e clique em **Run** acima do `main`.

**Terminal:**

```bash
cd atividade_final/GestaoTarefas
javac -d bin -sourcepath src src/App.java
java -cp bin App
```

> O `-sourcepath src` é necessário porque o código está dividido em **pacotes** (`models`, `view`, `controller`). Sem ele o compilador não acha as outras classes.

---

## 🧩 O que é MVC

MVC é só uma forma de **organizar as pastas e as responsabilidades** do código. Cada camada tem um trabalho e não se mete no do vizinho:

| Camada | Pasta | Responsabilidade | Nunca faz |
|--------|-------|------------------|-----------|
| **Model** | `models/` e `enums/` | Guardar os dados e os relacionamentos | Não conhece a tela |
| **View** | `view/` | Mostrar os componentes e ler o que foi digitado | Não cria objetos nem valida |
| **Controller** | `controller/` | Validar, criar os objetos e guardar as listas | Não conhece botão nem tabela |

O caminho de um clique no botão **Cadastrar tarefa**:

```
  usuário clica
        │
        ▼
  PainelTarefas (view)        lê os campos e pega os objetos escolhidos nos combos
        │
        ▼
  SistemaController           valida ➜ cria o objeto Tarefa ➜ guarda na lista
        │
        ▼
  Tarefa (model)              objeto pronto, volta para a tela
        │
        ▼
  PainelTarefas (view)        redesenha a tabela
```

**Como saber se as camadas estão certas?** Olhe os `import`:

- `SistemaController.java` **não tem nenhum** `import javax.swing` → o cérebro não sabe o que é botão ✅
- `Usuario.java`, `Projeto.java` e `Tarefa.java` **também não** → os dados vivem sem tela ✅
- Nenhum painel da `view` tem `new Tarefa(...)` → quem cria os objetos é o controller ✅

---

## 🗂️ Arquivos

```
src/
├── App.java                       # liga o programa: cria o controller, cria a tela e mostra
│
├── enums/                         # MODEL — listas fixas de valores
│   ├── Prioridade.java            #   BAIXA, MEDIA, ALTA
│   ├── StatusTarefa.java          #   PENDENTE, FAZENDO, CONCLUIDA
│   ├── StatusProjeto.java         #   ATIVO, CONCLUIDO, CANCELADO
│   └── StatusUsuario.java         #   ATIVO, INATIVO, BLOQUEADO
│
├── models/                        # MODEL — os dados
│   ├── Usuario.java               #   tem uma List<Tarefa>
│   ├── Projeto.java               #   tem um responsável e uma List<Tarefa>
│   └── Tarefa.java                #   ao nascer, se registra no projeto e no usuário
│
├── controller/
│   └── SistemaController.java     # CONTROLLER — um método para cada cadastro:
│                                  #   cadastrarUsuario / cadastrarProjeto / cadastrarTarefa
│
└── view/
    ├── TelaPrincipal.java         # a janela, com as 3 abas dentro
    ├── PainelUsuarios.java        # aba 1 — cadastro de usuário
    ├── PainelProjetos.java        # aba 2 — cadastro de projeto
    └── PainelTarefas.java         # aba 3 — cadastro de tarefa
```

Os três painéis são bem parecidos: **formulário em cima, botão, tabela embaixo**. Entendendo um, você entende os três.

---

## 🖼️ Componentes Swing usados

| Componente | Para quê | Onde aparece |
|------------|----------|--------------|
| `JFrame` | A janela em si | `TelaPrincipal extends JFrame` |
| `JTabbedPane` | As abas | `TelaPrincipal` |
| `JPanel` | Um pedaço de tela (o conteúdo de cada aba) | os três painéis |
| `JLabel` | Texto fixo ("Nome:") | ao lado de cada campo |
| `JTextField` | Onde a pessoa digita | nome, e-mail, título, descrição |
| `JComboBox` | Lista suspensa | status, prioridade, projeto, responsável |
| `JButton` | Botão clicável | "Cadastrar ..." |
| `JTable` + `DefaultTableModel` | Lista em formato de tabela | embaixo de cada formulário |
| `JScrollPane` | Moldura com barra de rolagem | em volta de cada tabela |
| `JOptionPane` | Janelinha de aviso | quando falta preencher algo |

Dois métodos que aparecem o tempo todo:

- `setBounds(x, y, largura, altura)` — posiciona o componente. O ponto `0,0` é o canto **superior esquerdo** e o `y` cresce para **baixo**.
- `add(componente)` — coloca o componente no painel. **Esqueceu o `add`? O componente não aparece.**

---

## 💡 Detalhes que valem a pena entender

**1. Tem combo de duas naturezas diferentes**

O de status/prioridade nasce pronto, direto do enum:

```java
comboPrioridade = new JComboBox<>(Prioridade.values());
```

Já o de responsável nasce **vazio** e é preenchido enquanto o programa roda, porque os usuários vão sendo criados:

```java
comboResponsavel.removeAllItems();
for (Usuario usuario : controller.getUsuarios()) {
    comboResponsavel.addItem(usuario);   // guarda o OBJETO, não o nome
}
```

**2. O combo guarda objetos — e é aí que mora o vínculo**

Repare no tipo: `JComboBox<Usuario>`. Quando você faz

```java
Usuario responsavel = (Usuario) comboResponsavel.getSelectedItem();
```

o que volta é a **pessoa inteira** (id, e-mail, lista de tarefas...), não o texto que está escrito na tela. É esse objeto que entra dentro do `Projeto` e da `Tarefa`.

**3. Por que o combo mostra o nome e não `models.Usuario@1b6d3586`?**

Porque `Usuario` e `Projeto` têm o método `toString()` devolvendo o nome. É ele que o Swing usa para escrever o objeto na tela.

**4. A tabela é só um espelho — os dados de verdade são os objetos**

O método `atualizarTabela()` apaga tudo (`setRowCount(0)`) e escreve de novo a partir da lista do controller. Por isso a coluna "Tarefas" da aba de usuários vai aumentando conforme você cadastra tarefas: a lista mudou, a tabela redesenha.

**5. Trocar de aba atualiza tudo**

```java
abas.addChangeListener(e -> atualizarTudo());
```

É a mesma ideia do `ActionListener` do botão, só que dispara quando você muda de aba. Sem isso, você cadastraria um usuário na aba 1 e ele não apareceria na lista de responsáveis da aba 2.

**6. Validação com exceção (Aula 5)**

O controller **lança** `IllegalArgumentException` quando falta um campo; a tela **captura** com `try/catch` e mostra o `JOptionPane`. Quem decide o que é erro é o controller; a tela só exibe.

---

## 🚀 Desafios para ir além

1. Botão **Excluir** em cada aba — pegar a linha selecionada com `tabela.getSelectedRow()` e remover da lista.
2. Botão **Concluir tarefa** — mudar o status da tarefa selecionada para `CONCLUIDA`.
3. Não deixar excluir um projeto que ainda tem tarefas.
4. Filtrar a tabela de tarefas por projeto.
5. Salvar os cadastros em arquivo para não perder tudo ao fechar o programa.
