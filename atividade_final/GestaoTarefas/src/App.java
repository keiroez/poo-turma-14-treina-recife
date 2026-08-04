
import controller.SistemaController;
import javax.swing.SwingUtilities;
import view.TelaPrincipal;

/*
 * ===================== PONTO DE PARTIDA =====================
 *
 * Esta classe só tem UMA função: ligar o programa.
 *
 * Ela monta as peças do MVC e manda a tela aparecer:
 *
 *      App  ->  cria o Controller
 *           ->  cria a Tela e entrega o Controller para ela
 *           ->  manda a Tela aparecer
 *
 * Repare como é curtinha. Se o main estivesse cheio de regra de negócio,
 * seria sinal de que alguma coisa está no lugar errado.
 */
public class App {

    public static void main(String[] args) {

        /*
         * SwingUtilities.invokeLater manda o Swing montar a tela na "thread"
         * certinha dele (a thread da interface gráfica).
         *
         * Não precisa entender isso agora — é só a forma recomendada de abrir
         * uma janela. Guarde a receita: todo programa Swing começa assim.
         */
        SwingUtilities.invokeLater(() -> {

            // 1) O cérebro: guarda as listas e as regras.
            SistemaController controller = new SistemaController();

            // 2) O rosto: recebe o controller para poder conversar com ele.
            TelaPrincipal tela = new TelaPrincipal(controller);

            // 3) Sem esta linha a janela existe... mas fica invisível!
            tela.setVisible(true);
        });
    }
}
