
import java.awt.*;
import java.text.ParseException;
import javax.swing.*;
import javax.swing.text.MaskFormatter;

public class FormularioComMascaras extends JFrame {

    public FormularioComMascaras() {
        // Configurações da Janela Principal
        setTitle("Formulário com Máscaras");
        setSize(450, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centraliza na tela
        setResizable(false);

        // Painel Principal com Layout de Grid (GridBagLayout para bom alinhamento)
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Espaçamento entre os componentes
        gbc.fill = GridBagConstraints.HORIZONTAL;

        try {
            // Máscaras de Formatação
            MaskFormatter mascaraCep = new MaskFormatter("#####-###");
            MaskFormatter mascaraTelefone = new MaskFormatter("(##)#####-####");
            MaskFormatter mascaraCpf = new MaskFormatter("###.###.###-##");
            MaskFormatter mascaraData = new MaskFormatter("##/##/####");

            // Define o caractere de preenchimento para sublinhado '_' (igual à imagem)
            mascaraCep.setPlaceholderCharacter('_');
            mascaraTelefone.setPlaceholderCharacter('_');
            mascaraCpf.setPlaceholderCharacter('_');
            mascaraData.setPlaceholderCharacter('_');

            // --- Linha 1: CEP ---
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.anchor = GridBagConstraints.LINE_END;
            JLabel lblCep = new JLabel("CEP:");
            lblCep.setFont(new Font("SansSerif", Font.BOLD, 13));
            panel.add(lblCep, gbc);

            gbc.gridx = 1;
            gbc.anchor = GridBagConstraints.LINE_START;
            JFormattedTextField txtCep = new JFormattedTextField(mascaraCep);
            txtCep.setPreferredSize(new Dimension(160, 25));
            panel.add(txtCep, gbc);

            // --- Linha 2: Telefone ---
            gbc.gridx = 0;
            gbc.gridy = 1;
            gbc.anchor = GridBagConstraints.LINE_END;
            JLabel lblTelefone = new JLabel("Telefone:");
            lblTelefone.setFont(new Font("SansSerif", Font.BOLD, 13));
            panel.add(lblTelefone, gbc);

            gbc.gridx = 1;
            gbc.anchor = GridBagConstraints.LINE_START;
            JFormattedTextField txtTelefone = new JFormattedTextField(mascaraTelefone);
            txtTelefone.setPreferredSize(new Dimension(160, 25));
            panel.add(txtTelefone, gbc);

            // --- Linha 3: CPF ---
            gbc.gridx = 0;
            gbc.gridy = 2;
            gbc.anchor = GridBagConstraints.LINE_END;
            JLabel lblCpf = new JLabel("CPF:");
            lblCpf.setFont(new Font("SansSerif", Font.BOLD, 13));
            panel.add(lblCpf, gbc);

            gbc.gridx = 1;
            gbc.anchor = GridBagConstraints.LINE_START;
            JFormattedTextField txtCpf = new JFormattedTextField(mascaraCpf);
            txtCpf.setPreferredSize(new Dimension(160, 25));
            panel.add(txtCpf, gbc);

            // --- Linha 4: Data ---
            gbc.gridx = 0;
            gbc.gridy = 3;
            gbc.anchor = GridBagConstraints.LINE_END;
            JLabel lblData = new JLabel("Data:");
            lblData.setFont(new Font("SansSerif", Font.BOLD, 13));
            panel.add(lblData, gbc);

            gbc.gridx = 1;
            gbc.anchor = GridBagConstraints.LINE_START;
            JFormattedTextField txtData = new JFormattedTextField(mascaraData);
            txtData.setPreferredSize(new Dimension(160, 25));
            panel.add(txtData, gbc);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        add(panel);
    }

    public static void main(String[] args) {
        // Define o visual nativo do sistema operacional (Look and Feel)
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(() -> {
            new FormularioComMascaras().setVisible(true);
        });
    }
}
