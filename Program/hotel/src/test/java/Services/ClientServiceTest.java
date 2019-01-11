package Services;

import Config.Config;
import DAOs.ClientDAO;
import entities.Client;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import services.ClientService;

@RunWith(MockitoJUnitRunner.class)
public class ClientServiceTest {

    @Mock
    Config config;

    @InjectMocks
    ClientService clientService;

    private boolean mockInitialized = false;
    private Client client, newClient;

    @Before
    public void setUp(){
        if(!mockInitialized) {
            MockitoAnnotations.initMocks(this);
            client = new Client();
            client.setPesel("12345678901");
            client.setPhoneNumber("112112112");
            client.setFirstName("Wojtek");
            client.setLastName("Spoton");
            newClient = new Client();
            newClient.setPesel("12345678901");
            newClient.setPhoneNumber("112112112");
            newClient.setFirstName("Wojtek");
            newClient.setLastName("Spoton");
            mockInitialized = true;
        }
    }

    @Test
    public void whenDatabaseIsNotEmptyThenReturnedClientIsNotNull(){
        Client savedClient = clientService.addClient(client);
        Assert.assertNotNull(clientService.findClient(newClient));
        clientService.removeClient(savedClient);
    }

    @Test
    public void whenDatabaseIsEmptyThenReturnedClientIsNull(){
        Assert.assertNull(clientService.findClient(newClient));
    }

    @Test
    public void whenClientCreatedThenReturnNotNull() {
        Assert.assertNotNull(clientService.addClient(newClient));
        Client savedClient = clientService.findClient(newClient);
        clientService.removeClient(savedClient);
    }

    @Test
    public void whenClientCreatedThenReturnedCorrectly() {
        Client savedClient = clientService.addClient(newClient);
        Assert.assertEquals(savedClient, newClient);
        clientService.removeClient(savedClient);
    }

    @Test
    public void whenClientDeletedThenRemovedCorrectly() {
        Client savedClient = clientService.addClient(newClient);
        clientService.removeClient(savedClient);
        Assert.assertTrue(clientService.getAllClients().size() == 0);
    }
}
