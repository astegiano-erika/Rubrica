package frontend;

import backend.Persona;
import backend.Rubrica;
import java.awt.*;
import javax.swing.*;

public class MainFrame extends JFrame {

    private final Rubrica rubrica;
    private final RubricaTable tableModel;
    private final JTable table;

    public MainFrame(Rubrica rubrica) {
        this.rubrica = rubrica;

        setTitle("Rubrica Telefonica");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 400);
        setLocationRelativeTo(null); //no owner

        this.tableModel = new RubricaTable(rubrica.getAll());
        this.table = new JTable(tableModel);

        setLayout(new BorderLayout());
        add(new JScrollPane(table), BorderLayout.CENTER);
        add(buttons(), BorderLayout.SOUTH);
    }

    private JPanel buttons() {
        JButton btnNuovo = new JButton("Nuovo");
        JButton btnModifica = new JButton("Modifica");
        JButton btnElimina = new JButton("Elimina");

        btnNuovo.addActionListener(e -> onNuovo());
        btnModifica.addActionListener(e -> onModifica());
        btnElimina.addActionListener(e -> onElimina());

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel.add(btnNuovo);
        panel.add(btnModifica);
        panel.add(btnElimina);
        return panel;
    }

    private void onNuovo() {
        Form form = new Form(this);
        Persona nuova = form.showForm(null); // null == campi vuoti
        if (nuova != null) {
            rubrica.addPersona(nuova);
            tableModel.refresh(rubrica.getAll());
        }
    }

    private void onModifica() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, Messages.ERR_EDIT);
            return;
        }

        Persona selezionata = rubrica.getAll().get(selectedRow);

        Form form = new Form(this);
        Persona modificata = form.showForm(selezionata);
        if (modificata != null) {
            rubrica.updatePersona(selectedRow, modificata);
            tableModel.refresh(rubrica.getAll());
        }
    }

    private void onElimina() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, Messages.ERR_DELETE);
            return;
        }

        Persona selezionata = rubrica.getAll().get(selectedRow);
        String msg = String.format(Messages.CONF_DELETE,
                selezionata.getNome(), selezionata.getCognome());

        int choice = JOptionPane.showConfirmDialog(this, msg, "Conferma",
                JOptionPane.YES_NO_OPTION);

        if (choice == JOptionPane.YES_OPTION) {
            rubrica.deletePersona(selectedRow);
            tableModel.refresh(rubrica.getAll());
        }
    }
}
