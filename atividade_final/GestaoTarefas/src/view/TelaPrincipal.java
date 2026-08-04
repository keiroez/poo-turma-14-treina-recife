package view;

import controller.SistemaController;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;

/*
 * ===================== CAMADA VIEW — A JANELA =====================
 *
 * Esta classe é só a MOLDURA: ela cria a janela e coloca as três abas dentro.
 *
 *      Aba 1 - Usuários  -> PainelUsuarios
 *      Aba 2 - Projetos  -> PainelProjetos
 *      Aba 3 - Tarefas   -> PainelTarefas
 *
 * "extends JFrame" = esta classe É uma janela (herança, da Aula 3!).
 * Por isso podemos chamar setTitle(), setSize(), add()... sem criar
 * nenhum objeto: esses métodos vieram de JFrame por herança.
 */
public class TelaPrincipal extends JFrame {

    // Guardamos os painéis como atributos para poder atualizá-los na troca de aba.
    private PainelUsuarios painelUsuarios;
    private PainelProjetos painelProjetos;
    private PainelTarefas painelTarefas;

    public TelaPrincipal(SistemaController controller) {

        // ---------- configuração da janela ----------
        setTitle("Gestão de Tarefas - Treina Recife");
        setSize(720, 560); // largura x altura, em pixels

        // Sem esta linha, fechar a janela NÃO encerra o programa.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null); // null = centraliza a janela na tela
        setResizable(false); // impede redimensionar (nosso layout é fixo)

        // ---------- as três abas ----------
        // Todos os painéis recebem o MESMO controller: é a memória compartilhada
        // do sistema. Por isso o usuário cadastrado na aba 1 aparece na aba 2.
        painelUsuarios = new PainelUsuarios(controller);
        painelProjetos = new PainelProjetos(controller);
        painelTarefas = new PainelTarefas(controller);

        // JTabbedPane é o componente de abas. addTab(titulo, painel) cria cada aba.
        JTabbedPane abas = new JTabbedPane();
        abas.addTab("1. Usuários", painelUsuarios);
        abas.addTab("2. Projetos", painelProjetos);
        abas.addTab("3. Tarefas", painelTarefas);

        /*
         * ChangeListener é igual ao ActionListener do botão, só que ele avisa
         * quando você TROCA DE ABA (em vez de avisar sobre um clique).
         *
         * Usamos isso para manter tudo em dia: ao entrar numa aba, os combos e
         * a tabela dela são remontados com os dados mais recentes.
         *
         * Sem isso, você cadastraria um usuário na aba 1 e ele não apareceria
         * na lista de responsáveis da aba 2.
         */
        abas.addChangeListener(e -> atualizarTudo());

        // A janela usa o layout padrão dela (BorderLayout), então o add()
        // sem coordenadas faz as abas ocuparem a janela inteira.
        add(abas);
    }

    /* Pede para cada painel se atualizar. */
    private void atualizarTudo() {
        painelUsuarios.atualizarTabela();

        painelProjetos.atualizarCombos();
        painelProjetos.atualizarTabela();

        painelTarefas.atualizarCombos();
        painelTarefas.atualizarTabela();
    }
}
