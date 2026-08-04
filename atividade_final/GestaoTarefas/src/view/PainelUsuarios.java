package view;

import controller.SistemaController;
import enums.StatusUsuario;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import models.Usuario;

/*
 * ===================== CAMADA VIEW — ABA 1 =====================
 *
 * CADASTRO DE USUÁRIO (é ele quem depois vira responsável por projetos e tarefas).
 *
 * "extends JPanel" = esta classe É um painel, ou seja, um pedaço de tela.
 * A janela (TelaPrincipal) coloca este painel dentro de uma aba.
 *
 * O que o painel FAZ: desenha os componentes, lê o que foi digitado,
 * entrega para o controller e mostra o resultado na tabela.
 *
 * O que ele NÃO FAZ: não cria objeto Usuario e não valida nada.
 * Isso é trabalho do controller.
 */
public class PainelUsuarios extends JPanel {

    // O painel guarda o controller para poder conversar com ele.
    private SistemaController controller;

    // Componentes que vários métodos aqui precisam usar viram atributos.
    private JTextField campoNome;
    private JTextField campoEmail;
    private JComboBox<StatusUsuario> comboStatus;
    private DefaultTableModel modeloTabela;

    public PainelUsuarios(SistemaController controller) {
        this.controller = controller;

        /*
         * setLayout(null) desliga o organizador automático do Swing.
         * Assim NÓS posicionamos cada componente na mão, com
         * setBounds(x, y, largura, altura).
         *
         * x = distância da borda esquerda | y = distância do topo
         * (o ponto 0,0 é o canto superior esquerdo, e o y cresce para BAIXO)
         */
        setLayout(null);

        criarFormulario();
        criarTabela();
    }

    /* ---------- Os campos que o usuário preenche ---------- */
    private void criarFormulario() {

        // JLabel = texto fixo, só para a pessoa saber o que digitar ali.
        JLabel labelNome = new JLabel("Nome:");
        labelNome.setBounds(20, 20, 90, 25);
        add(labelNome); // sem o add(), o componente NÃO aparece!

        // JTextField = caixinha onde a pessoa digita.
        campoNome = new JTextField();
        campoNome.setBounds(115, 20, 230, 25);
        add(campoNome);

        JLabel labelEmail = new JLabel("E-mail:");
        labelEmail.setBounds(360, 20, 90, 25);
        add(labelEmail);

        campoEmail = new JTextField();
        campoEmail.setBounds(455, 20, 225, 25);
        add(campoEmail);

        JLabel labelStatus = new JLabel("Status:");
        labelStatus.setBounds(20, 55, 90, 25);
        add(labelStatus);

        /*
         * JComboBox = lista suspensa (aquela que abre ao clicar).
         *
         * StatusUsuario.values() devolve um array com TODOS os valores do enum
         * (ATIVO, INATIVO, BLOQUEADO). Ou seja: a lista se monta sozinha!
         * Vantagem sobre o campo de texto: é impossível digitar errado.
         */
        comboStatus = new JComboBox<>(StatusUsuario.values());
        comboStatus.setBounds(115, 55, 230, 25);
        add(comboStatus);

        JButton botaoCadastrar = new JButton("Cadastrar usuário");
        botaoCadastrar.setBounds(20, 95, 180, 30);
        add(botaoCadastrar);

        /*
         * ActionListener = "ouvinte de ação". É o aviso que damos ao botão:
         * "quando você for clicado, execute este código aqui".
         *
         * O "e -> ..." é a forma curta de escrever isso (lambda).
         * IMPORTANTE: este código NÃO roda agora, na montagem da tela.
         * Ele fica guardado, esperando o clique acontecer.
         */
        botaoCadastrar.addActionListener(e -> cadastrarUsuario());
    }

    /* ---------- A tabela que lista os usuários cadastrados ---------- */
    private void criarTabela() {

        // Os nomes das colunas, na ordem em que aparecem.
        String[] colunas = { "#", "Nome", "E-mail", "Status", "Tarefas" };

        // DefaultTableModel guarda os DADOS da tabela.
        // O 0 é a quantidade de linhas iniciais: começamos com a tabela vazia.
        modeloTabela = new DefaultTableModel(colunas, 0);

        // JTable é a parte visual; ela lê tudo do modelo que passamos.
        JTable tabela = new JTable(modeloTabela);

        // Deixa a tabela somente para leitura (sem isso dá para editar as células,
        // o que mudaria só o texto da tabela, sem mudar o objeto de verdade).
        tabela.setDefaultEditor(Object.class, null);

        /*
         * Largura (em pixels) de cada coluna, na mesma ordem do array 'colunas'.
         * É opcional — sem isso todas ficam do mesmo tamanho e o texto corta.
         */
        int[] larguras = { 35, 190, 190, 100, 70 };
        for (int i = 0; i < larguras.length; i++) {
            tabela.getColumnModel().getColumn(i).setPreferredWidth(larguras[i]);
        }

        /*
         * JScrollPane é a "moldura com barra de rolagem".
         * Sem ele, os nomes das colunas nem aparecem e a lista não rola!
         * Repare: quem entra no add() é o SCROLL, não a tabela.
         */
        JScrollPane scroll = new JScrollPane(tabela);
        scroll.setBounds(20, 140, 660, 315);
        add(scroll);
    }

    /*
     * ---------- O que acontece ao clicar em "Cadastrar usuário" ----------
     *
     * 1. lê o que foi digitado
     * 2. entrega para o controller (que valida e cria o objeto)
     * 3. atualiza a tabela
     * 4. limpa os campos para o próximo cadastro
     */
    private void cadastrarUsuario() {

        // try/catch (Aula 5!): se o controller reclamar de algum campo,
        // ele LANÇA uma exceção e o programa pula direto para o catch.
        try {
            // 1) LER a tela. getText() pega o texto digitado.
            String nome = campoNome.getText();
            String email = campoEmail.getText();

            /*
             * getSelectedItem() devolve o item escolhido no combo como Object
             * (o tipo mais genérico do Java). Como sabemos que ali só existe
             * StatusUsuario, fazemos um CAST: (StatusUsuario) ...
             */
            StatusUsuario status = (StatusUsuario) comboStatus.getSelectedItem();

            // 2) PEDIR para o controller fazer o trabalho.
            // A tela não sabe COMO o usuário é criado — e não precisa saber.
            controller.cadastrarUsuario(nome, email, status);

            // 3) e 4) mostrar o resultado e limpar os campos.
            atualizarTabela();
            campoNome.setText("");
            campoEmail.setText("");
            campoNome.requestFocus(); // cursor volta para o primeiro campo

        } catch (IllegalArgumentException erro) {
            /*
             * JOptionPane mostra uma janelinha de aviso.
             * getMessage() pega o texto que o controller colocou na exceção.
             *
             * Repare a divisão de tarefas: o controller DECIDE que é erro,
             * a tela apenas EXIBE o erro.
             */
            JOptionPane.showMessageDialog(this, erro.getMessage(),
                    "Atenção", JOptionPane.WARNING_MESSAGE);
        }
    }

    /*
     * Redesenha a tabela inteira a partir da lista do controller.
     *
     * A ideia é simples: apaga tudo e escreve de novo.
     * Assim a tabela é sempre um ESPELHO fiel da lista de objetos.
     *
     * É public porque a TelaPrincipal chama este método ao trocar de aba.
     */
    public void atualizarTabela() {
        modeloTabela.setRowCount(0); // apaga todas as linhas

        for (Usuario usuario : controller.getUsuarios()) {
            /*
             * Cada linha é um Object[] com o valor de cada coluna,
             * na MESMA ORDEM do array 'colunas' lá em cima.
             *
             * Pegamos tudo com GETTERS (encapsulamento da Aula 2!).
             */
            modeloTabela.addRow(new Object[] {
                    usuario.getId(),
                    usuario.getNome(),
                    usuario.getEmail(),
                    usuario.getStatus(),
                    usuario.getTarefas().size() // quantas tarefas essa pessoa tem
            });
        }
    }
}
