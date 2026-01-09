package frontend;

import backend.Rubrica;
import javax.swing.SwingUtilities;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Rubrica rubrica = new Rubrica("informazioni.txt");
            rubrica.readAllFromFile();

            MainFrame frame = new MainFrame(rubrica);
            frame.setVisible(true); //per mostrare le finestra
        });
    }
}
