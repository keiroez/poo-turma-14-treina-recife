package view;

import controller.SistemaController;
import enums.StatusProjeto;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import models.Projeto;
import models.Usuario;

/*
 * ===================== CAMADA VIEW — ABA 2 =====================
 *
 * CADASTRO DE PROJETO.
 *
 * A novidade desta aba: o combo de RESPONSÁVEL não é preenchido com texto,
 * e sim com os OBJETOS Usuario que já foram cadastrados na aba 1.
 * É assim que a gente "vincula" um projeto a um usuário.
 */
public class PainelProjetos extends JPanel {

    private SistemaController controller;

    private JTextField campoNome;
    private JTextField campoDescricao;
    private JComboBox<StatusProjeto> comboStatus;

    // Repare no tipo: JComboBox<Usuario>. O combo guarda OBJETOS, não texto!
    private JComboBox<Usuario> comboResponsavel;

    private DefaultTableModel modeloTabela;

    public PainelProjetos(SistemaController controller) {
        this.controller = controller;
        setLayout(null);

        criarFormulario();
        criarTabela();
    }

    private void criarFormulario() {

        JLabel labelNome = new JLabel("Nome:");
        labelNome.setBounds(20, 20, 90, 25);
        add(labelNome);

        campoNome = new JTextField();
        campoNome.setBounds(115, 20, 230, 25);
        add(campoNome);

        JLabel labelResponsavel = new JLabel("Responsável:");
        labelResponsavel.setBounds(360, 20, 90, 25);
        add(labelResponsavel);

        /*
         * Este combo começa VAZIO e é preenchido depois, no método
         * atualizarCombos(), com os usuários já cadastrados.
         *
         * Por que vazio? Porque quando a tela é montada ainda não existe
         * nenhum usuário — eles vão sendo criados enquanto o programa roda.
         */
        comboResponsavel = new JComboBox<>();
        comboResponsavel.setBounds(455, 20, 225, 25);
        add(comboResponsavel);

        JLabel labelDescricao = new JLabel("Descrição:");
        labelDescricao.setBounds(20, 55, 90, 25);
        add(labelDescricao);

        campoDescricao = new JTextField();
        campoDescricao.setBounds(115, 55, 230, 25);
        add(campoDescricao);

        JLabel labelStatus = new JLabel("Status:");
        labelStatus.setBounds(360, 55, 90, 25);
        add(labelStatus);

        comboStatus = new JComboBox<>(StatusProjeto.values());
        comboStatus.setBounds(455, 55, 225, 25);
        add(comboStatus);

        JButton botaoCadastrar = new JButton("Cadastrar projeto");
        botaoCadastrar.setBounds(20, 95, 180, 30);
        botaoCadastrar.addActionListener(e -> cadastrarProjeto());
        add(botaoCadastrar);
    }

    private void criarTabela() {

        String[] colunas = { "#", "Nome", "Descrição", "Status", "Responsável", "Tarefas" };

        modeloTabela = new DefaultTableModel(colunas, 0);

        JTable tabela = new JTable(modeloTabela);
        tabela.setDefaultEditor(Object.class, null);

        // Largura de cada coluna, na mesma ordem do array 'colunas'.
        int[] larguras = { 35, 165, 175, 95, 120, 65 };
        for (int i = 0; i < larguras.length; i++) {
            tabela.getColumnModel().getColumn(i).setPreferredWidth(larguras[i]);
        }

        JScrollPane scroll = new JScrollPane(tabela);
        scroll.setBounds(20, 140, 660, 315);
        add(scroll);
    }

    private void cadastrarProjeto() {
        try {
            String nome = campoNome.getText();
            String descricao = campoDescricao.getText();
            StatusProjeto status = (StatusProjeto) comboStatus.getSelectedItem();

            /*
             * AQUI ACONTECE O VÍNCULO!
             *
             * getSelectedItem() devolve o OBJETO Usuario que está selecionado
             * no combo — a pessoa inteira, com id, e-mail, lista de tarefas...
             * e não apenas o nome que aparece escrito na tela.
             *
             * Se nenhum usuário foi cadastrado ainda, o combo está vazio e isso
             * devolve null. O controller vai perceber e avisar.
             */
            Usuario responsavel = (Usuario) comboResponsavel.getSelectedItem();

            controller.cadastrarProjeto(nome, descricao, status, responsavel);

            atualizarTabela();
            campoNome.setText("");
            campoDescricao.setText("");
            campoNome.requestFocus();

        } catch (IllegalArgumentException erro) {
            JOptionPane.showMessageDialog(this, erro.getMessage(),
                    "Atenção", JOptionPane.WARNING_MESSAGE);
        }
    }

    /*
     * Preenche o combo com os usuários que existem AGORA.
     *
     * A TelaPrincipal chama este método toda vez que você entra nesta aba.
     * Assim, se você acabou de cadastrar alguém na aba 1, essa pessoa já
     * aparece aqui na lista.
     */
    public void atualizarCombos() {
        comboResponsavel.removeAllItems(); // esvazia a lista

        for (Usuario usuario : controller.getUsuarios()) {
            /*
             * addItem() coloca o OBJETO Usuario dentro do combo.
             *
             * E como o combo mostra o nome da pessoa em vez de algo feio
             * tipo "models.Usuario@1b6d3586"? Porque a classe Usuario tem
             * um método toString() devolvendo o nome. Dê uma olhada lá!
             */
            comboResponsavel.addItem(usuario);
        }
    }

    /* Redesenha a tabela: apaga tudo e escreve de novo a partir da lista. */
    public void atualizarTabela() {
        modeloTabela.setRowCount(0);

        for (Projeto projeto : controller.getProjetos()) {
            modeloTabela.addRow(new Object[] {
                    projeto.getId(),
                    projeto.getNome(),
                    projeto.getDescricao(),
                    projeto.getStatus(),
                    // do projeto chegamos ao responsável, e dele ao nome:
                    projeto.getResponsavel().getNome(),
                    projeto.getTarefas().size()
            });
        }
    }
}
