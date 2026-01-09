package frontend;

import backend.Persona;
import java.awt.*;
import javax.swing.*;

public class Form extends JDialog {

    private JTextField nome;
    private JTextField cognome;
    private JTextField indirizzo;
    private JTextField telefono;
    private JTextField eta;

    private Persona result;

    public Form(Frame owner) {  //ownew == mainframe
        super(owner, "Editor Persona", true); // modale == non si può interagire con owner
        setSize(400, 250);
        setLocationRelativeTo(owner);

        initComponents();
    }

    private void initComponents() {
        nome = new JTextField(20);
        cognome = new JTextField(20);
        indirizzo = new JTextField(20);
        telefono = new JTextField(20);
        eta = new JTextField(20);

        JPanel form = new JPanel(new GridLayout(5, 2, 8, 8));
        form.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        form.add(new JLabel("Nome"));
        form.add(nome);
        form.add(new JLabel("Cognome"));
        form.add(cognome);
        form.add(new JLabel("Indirizzo"));
        form.add(indirizzo);
        form.add(new JLabel("Telefono"));
        form.add(telefono);
        form.add(new JLabel("Età"));
        form.add(eta);

        JButton btnSalva = new JButton("Salva");
        JButton btnAnnulla = new JButton("Annulla");

        btnSalva.addActionListener(e -> onSalva());
        btnAnnulla.addActionListener(e -> onAnnulla());

        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttons.add(btnSalva);
        buttons.add(btnAnnulla);

        setLayout(new BorderLayout());
        add(form, BorderLayout.CENTER);
        add(buttons, BorderLayout.SOUTH);
    }

    public Persona showForm(Persona p) {
        result = null;

        if (p != null) {
            nome.setText(p.getNome());
            cognome.setText(p.getCognome());
            indirizzo.setText(p.getIndirizzo());
            telefono.setText(p.getTelefono());
            eta.setText(String.valueOf(p.getEta()));
        } else {
            nome.setText("");
            cognome.setText("");
            indirizzo.setText("");
            telefono.setText("");
            eta.setText("");
        }

        setVisible(true); // visibile fino a chiusura
        return result;
    }

    private void onSalva() {
        //controlli non richiesti
        int i_eta;
        try {
            i_eta = Integer.parseInt(eta.getText().trim());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, Messages.ERR_INVALID);
            return;
        }
    
        int i_telefono;
        try {
            i_telefono = Integer.parseInt(telefono.getText().trim());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, Messages.ERR_INVALID);
            return;
        }

        String s_nome = nome.getText().trim();
        String s_cognome = cognome.getText().trim();
        String s_indirizzo = indirizzo.getText().trim();
        String s_telefono = telefono.getText().trim();

        if (s_nome.isEmpty() || s_cognome.isEmpty() || s_telefono.isEmpty()) {
            JOptionPane.showMessageDialog(this, Messages.ERR_EMPTY);
            return;
        }

        result = new Persona(
                s_nome,
                s_cognome,
                s_indirizzo,
                s_telefono,
                i_eta
        );

        dispose(); //chisura finestra
    }

    private void onAnnulla() {
        result = null;
        dispose(); //chiusura finestra
    }
}
