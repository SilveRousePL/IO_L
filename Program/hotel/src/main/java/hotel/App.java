package hotel;

import Config.Config;
import entities.Client;
import services.ClientService;
import services.ReservationService;
import services.RoomService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App extends JFrame {

    private ReservationService reservationService = Config.reservationService;
    private ClientService clientService = Config.clientService;
    private RoomService roomService = Config.roomService;


    public App() {

        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        JButton Button  = new JButton("Zarządzaj klientami");

        App app = this;
        Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ClientManagement();
            }
        });
        JButton Button2  = new JButton("Zarządzaj pokojami");
        JButton Button3  = new JButton("Zarządzaj rezerwacjami");
        panel.add(Button);
        panel.add(Button2);
        panel.add(Button3);
        setContentPane(panel);

        setVisible(true);
    }

    public static void main(String[] args) {
        new App();
    }


    private void test() {
        Client client = new Client();
        client.setFirstName("Wojtek");
        client.setLastName("Spoton");
        client.setPhoneNumber("123456789");
        client.setPesel("1234567894");
        clientService.addClient(client);

        Client client2 = new Client();
        client2.setFirstName("Koko");
        client2.setLastName("Spoko");
        client2.setPhoneNumber("123");
        client2.setPesel("123");
        clientService.addClient(client2);


        Client c = clientService.findClient(client);
        c.setPesel("242");
        clientService.modifyClient(c);

        Client cl = clientService.findClient(client2);
        clientService.removeClient(cl);
    }
}
