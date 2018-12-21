package hotel;

import Config.Config;
import entities.Client;
import services.ClientService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientManagement extends JFrame {

    private final ClientService clientService = Config.clientService;

    private JTextField first_name_field, last_name_field, pesel_field, phone_number_field;
    private JLabel first_name_label, last_name_label, pesel_label, phone_number_label;
    boolean isPresent = false;
    Client presentClient;

    public ClientManagement() {

        super("Client panel");

        JPanel clientPanel = new JPanel();
        clientPanel.setLayout(new GridLayout(6,2));

        setSize(300, 400);

        first_name_field = new JTextField("");
        first_name_label = new JLabel("first name");

        last_name_field = new JTextField("");
        last_name_label = new JLabel("last name");

        pesel_field = new JTextField("");
        pesel_label = new JLabel("pesel");

        phone_number_field = new JTextField("");
        phone_number_label = new JLabel("phone number");

        JButton buttonAdd = new JButton("Create client");
        buttonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isPresent = false;
                Client client = translateClient();
                client = clientService.addClient(client);
                if(client != null) {
                    clearField();
                    JOptionPane.showMessageDialog(null, "Kliekt został dodany!");
                }
                else
                    JOptionPane.showMessageDialog(null, "Nie udało się dodać klienta!");
            }
        });
        JButton buttonDelete = new JButton("Remove client");
        buttonDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(isPresent == true) {
                    clientService.removeClient(presentClient);
                    JOptionPane.showMessageDialog(null, "Polecenie usunięcia klienta zostało przekierowane do bazy!");
                }
                isPresent = false;
                clearField();
            }
        });
        JButton buttonFind = new JButton("Find client");
        buttonFind.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Client client = translateClient();
                client = clientService.findClient(client);
                if(client != null) {
                    first_name_field.setText(client.getFirstName());
                    last_name_field.setText(client.getLastName());
                    pesel_field.setText(client.getPesel());
                    phone_number_field.setText(client.getPhoneNumber());
                    JOptionPane.showMessageDialog(null, "Kliekt został odnaleziony!");
                    isPresent = true;
                    presentClient = client;
                }
                else {
                    JOptionPane.showMessageDialog(null, "Nie udało się odnaleźć klienta!");
                }
            }
        });
        JButton buttonUpdate = new JButton("Update client");
        buttonUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(isPresent == true) {
                    presentClient.setFirstName(first_name_field.getText());
                    presentClient.setLastName(last_name_field.getText());
                    presentClient.setPesel(pesel_field.getText());
                    presentClient.setPhoneNumber(phone_number_field.getText());
                    presentClient = clientService.modifyClient(presentClient);
                    if(presentClient != null)
                        JOptionPane.showMessageDialog(null, "KKlient z powodzeniem zaktualizowany!");
                    else
                        JOptionPane.showMessageDialog(null, "Nie udało się zaktualizować klienta!");
                }
                isPresent = false;
                clearField();
            }
        });

        clientPanel.add(first_name_label);
        clientPanel.add(first_name_field);
        clientPanel.add(last_name_label);
        clientPanel.add(last_name_field);
        clientPanel.add(pesel_label);
        clientPanel.add(pesel_field);
        clientPanel.add(phone_number_label);
        clientPanel.add(phone_number_field);

        clientPanel.add(buttonAdd);
        clientPanel.add(buttonFind);
        clientPanel.add(buttonUpdate);
        clientPanel.add(buttonDelete);

        setContentPane(clientPanel);

        setVisible(true);
    }

    private Client translateClient() {
        Client client = new Client();
        client.setFirstName(first_name_field.getText());
        client.setLastName(last_name_field.getText());
        client.setPesel(pesel_field.getText());
        client.setPhoneNumber(phone_number_field.getText());
        return client;
    }

    private void clearField() {
        first_name_field.setText("");
        last_name_field.setText("");
        pesel_field.setText("");
        phone_number_field.setText("");
    }
}