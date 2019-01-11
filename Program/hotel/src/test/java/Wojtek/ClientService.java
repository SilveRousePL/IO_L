package Wojtek;

import entities.Client;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ClientService {

    @InjectMocks
    ClientTDao clientTDao;

    Client myFrstClient;

    @Before
    public void setUp() {
        myFrstClient = new Client();
        myFrstClient.setPhoneNumber("123456789");
        myFrstClient.setPesel("1234124234");
        myFrstClient.setLastName("Spoko");
        myFrstClient.setFirstName("Wojtek");
    }


    @Test
    public void whenUpdateClientThenClientUpdated() {
        Assert.assertNotNull(clientTDao.modifyClient(myFrstClient));
    }

    @Test
    public void whenClientFirstNameIsNullThenReturnNull() {
        myFrstClient.setFirstName("");
        Assert.assertNull(clientTDao.modifyClient(myFrstClient));
        myFrstClient.setFirstName("Wojtek");
    }

    @Test
    public void whenClientLastNameIsNullThenReturnNull() {
        myFrstClient.setLastName("");
        Assert.assertNull(clientTDao.modifyClient(myFrstClient));
        myFrstClient.setLastName("Spoko");
    }

    @Test
    public void whenClientOkThenReturnClient() {
        Client savedClient = clientTDao.modifyClient(myFrstClient);
        Assert.assertEquals(myFrstClient, savedClient);
    }




}
