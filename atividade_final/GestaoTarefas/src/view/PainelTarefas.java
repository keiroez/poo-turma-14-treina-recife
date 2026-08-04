package view;

import controller.SistemaController;
import enums.Prioridade;
import enums.StatusTarefa;
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
import models.Tarefa;
import models.Usuario;

/*
 * ===================== CAMADA VIEW — ABA 3 =====================
 *
 * CADASTRO DE TAREFA.
 *
 * Esta é a aba que amarra tudo: a tarefa é criada JÁ VINCULADA a um projeto
 * e a um usuário, os dois escolhidos em combos com o que já foi cadastrado
 * nas abas anteriores.
 *
 * Por isso a ordem do sistema é: usuário -> projeto -> tarefa.
 */
public class PainelTarefas extends JPanel {

    private SistemaController controller;

    private JTextField campoTitulo;
    private JTextField campoDescricao;
    private JComboBox<Prioridade> comboPrioridade;
    private JComboBox<StatusTarefa> comboStatus;

    // Os dois combos que fazem o vínculo — guardam OBJETOS, não texto.
    private JComboBox<Projeto> comboProjeto;
    private JComboBox<Usuario> comboResponsavel;

    private DefaultTableModel modeloTabela;

    public PainelTarefas(SistemaController controller) {
        this.controller = controller;
        setLayout(null);

        criarFormulario();
        criarTabela();
    }

    private void criarFormulario() {

        JLabel labelTitulo = new JLabel("Título:");
        labelTitulo.setBounds(20, 20, 90, 25);
        add(labelTitulo);

        campoTitulo = new JTextField();
        campoTitulo.setBounds(115, 20, 230, 25);
        add(campoTitulo);

        JLabel labelProjeto = new JLabel("Projeto:");
        labelProjeto.setBounds(360, 20, 90, 25);
        add(labelProjeto);

        // Vazio agora; preenchido em atualizarCombos() com os projetos existentes.
        comboProjeto = new JComboBox<>();
        comboProjeto.setBounds(455, 20, 225, 25);
        add(comboProjeto);

        JLabel labelDescricao = new JLabel("Descrição:");
        labelDescricao.setBounds(20, 55, 90, 25);
        add(labelDescricao);

        campoDescricao = new JTextField();
        campoDescricao.setBounds(115, 55, 230, 25);
        add(campoDescricao);

        JLabel labelResponsavel = new JLabel("Responsável:");
        labelResponsavel.setBounds(360, 55, 90, 25);
        add(labelResponsavel);

        comboResponsavel = new JComboBox<>();
        comboResponsavel.setBounds(455, 55, 225, 25);
        add(comboResponsavel);

        JLabel labelPrioridade = new JLabel("Prioridade:");
        labelPrioridade.setBounds(20, 90, 90, 25);
        add(labelPrioridade);

        // Este combo já nasce preenchido: os valores vêm direto do enum.
        comboPrioridade = new JComboBox<>(Prioridade.values());
        comboPrioridade.setBounds(115, 90, 230, 25);
        comboPrioridade.setSelectedItem(Prioridade.MEDIA); // começa em MEDIA
        add(comboPrioridade);

        JLabel labelStatus = new JLabel("Status:");
        labelStatus.setBounds(360, 90, 90, 25);
        add(labelStatus);

        comboStatus = new JComboBox<>(StatusTarefa.values());
        comboStatus.setBounds(455, 90, 225, 25);
        add(comboStatus);

        JButton botaoCadastrar = new JButton("Cadastrar tarefa");
        botaoCadastrar.setBounds(20, 130, 180, 30);
        botaoCadastrar.addActionListener(e -> cadastrarTarefa());
        add(botaoCadastrar);
    }

    private void criarTabela() {

        String[] colunas = { "#", "Título", "Prioridade", "Status", "Projeto", "Responsável" };

        modeloTabela = new DefaultTableModel(colunas, 0);

        JTable tabela = new JTable(modeloTabela);
        tabela.setDefaultEditor(Object.class, null);

        // Largura de cada coluna, na mesma ordem do array 'colunas'.
        int[] larguras = { 35, 175, 85, 90, 150, 120 };
        for (int i = 0; i < larguras.length; i++) {
            tabela.getColumnModel().getColumn(i).setPreferredWidth(larguras[i]);
        }

        JScrollPane scroll = new JScrollPane(tabela);
        scroll.setBounds(20, 175, 660, 280);
        add(scroll);
    }

    private void cadastrarTarefa() {
        try {
            String titulo = campoTitulo.getText();
            String descricao = campoDescricao.getText();
            Prioridade prioridade = (Prioridade) comboPrioridade.getSelectedItem();
            StatusTarefa status = (StatusTarefa) comboStatus.getSelectedItem();

            // O VÍNCULO: pegamos os objetos escolhidos nos combos.
            Projeto projeto = (Projeto) comboProjeto.getSelectedItem();
            Usuario responsavel = (Usuario) comboResponsavel.getSelectedItem();

            controller.cadastrarTarefa(titulo, descricao, prioridade, status, projeto, responsavel);

            atualizarTabela();
            campoTitulo.setText("");
            campoDescricao.setText("");
            campoTitulo.requestFocus();

        } catch (IllegalArgumentException erro) {
            JOptionPane.showMessageDialog(this, erro.getMessage(),
                    "Atenção", JOptionPane.WARNING_MESSAGE);
        }
    }

    /* Preenche os dois combos com o que já foi cadastrado nas outras abas. */
    public void atualizarCombos() {
        comboProjeto.removeAllItems();
        for (Projeto projeto : controller.getProjetos()) {
            comboProjeto.addItem(projeto);
        }

        comboResponsavel.removeAllItems();
        for (Usuario usuario : controller.getUsuarios()) {
            comboResponsavel.addItem(usuario);
        }
    }

    /* Redesenha a tabela: apaga tudo e escreve de novo a partir da lista. */
    public void atualizarTabela() {
        modeloTabela.setRowCount(0);

        for (Tarefa tarefa : controller.getTarefas()) {
            modeloTabela.addRow(new Object[] {
                    tarefa.getId(),
                    tarefa.getTitulo(),
                    tarefa.getPrioridade(),
                    tarefa.getStatus(),
                    // a partir da tarefa chegamos no projeto e no usuário dela:
                    tarefa.getProjeto().getNome(),
                    tarefa.getUsuario().getNome()
            });
        }
    }
}
