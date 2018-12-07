package hotel;

import Config.Config;
import entities.Client;
import services.ClientService;
import services.ReservationService;
import services.RoomService;

import javax.swing.*;
public class App extends JFrame {

    private ReservationService reservationService = Config.reservationService;
    private ClientService clientService = Config.clientService;
    private RoomService roomService = Config.roomService;


    public App() {

        test();


        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
    }
}
