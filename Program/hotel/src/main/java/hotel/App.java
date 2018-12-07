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


    private List<Client> clientsManagement(int option, Client client){

	switch(option) {
	case 1:
	{
	   return Arrays.asList(clientService.addClient(client));
	}
	case 2:
	{
	   removeClient(client);
	   return null;
	}
	case 3:
	{
	   return Arrays.asList(clientService.modifyClient(client));
	}
	case 4:
	{
	   return Arrays.asList(clientService.findClient(client));
	}
	case 5:
	{
	   return clientService.getAllClients();
	}
	}
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
