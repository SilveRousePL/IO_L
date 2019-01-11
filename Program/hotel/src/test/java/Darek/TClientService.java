package Darek;

import entities.Client;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class TClientService {

    @InjectMocks
    TClientDAO clientDAO;

    Client myClient;

    @Before
    public void setUp() {
        myClient = new Client();
        myClient.setFirstName("Darek");
        myClient.setLastName("Tomaszewski");
        myClient.setPesel("12345612345");
        myClient.setPhoneNumber("987789678");
    }

    @Test
    public void whenAddClientThenClientAdded() {
        Assert.assertNotNull(clientDAO.addClient(myClient));
    }

    @Test
    public void whenAddClientWithoutFirstNameReturnedClientIsNull() {
        myClient.setFirstName("");
        Assert.assertNull(clientDAO.addClient(myClient));
    }

}
