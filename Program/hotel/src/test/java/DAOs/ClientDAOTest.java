package DAOs;

import Config.Config;
import entities.Client;
import org.junit.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ClientDAOTest {

    @Mock
    Config config;

    @InjectMocks
    ClientDAO clientDAO;

    private boolean mockInitialized = false;
    private Client client, newClient;

    @BeforeEach
    public void setClient() {
        newClient = new Client();
        newClient.setPesel("12345678901");
        newClient.setPhoneNumber("112112112");
        newClient.setFirstName("Wojtek");
        newClient.setLastName("Spoton");
    }

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
        Client savedClient = clientDAO.addClient(client);
        Assert.assertNotNull(clientDAO.findClient(newClient));
        clientDAO.removeClient(savedClient);
    }

    @Test
    public void whenDatabaseIsEmptyThenReturnedClientIsNull(){
        Assert.assertNull(clientDAO.findClient(newClient));
    }

    @Test
    public void whenClientCreatedThenReturnNotNull() {
        Assert.assertNotNull(clientDAO.addClient(newClient));
        Client savedClient = clientDAO.findClient(newClient);
        clientDAO.removeClient(savedClient);
    }

    @Test
    public void whenClientCreatedThenReturnedCorrectly() {
        Client savedClient = clientDAO.addClient(newClient);
        Assert.assertEquals(savedClient, newClient);
        clientDAO.removeClient(savedClient);
    }

    @Test
    public void whenClientDeletedThenRemovedCorrectly() {
        Client savedClient = clientDAO.addClient(newClient);
        clientDAO.removeClient(savedClient);
        Assert.assertTrue(clientDAO.getAllClients().size() == 0);
    }
}