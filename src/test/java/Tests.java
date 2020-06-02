import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.hamcrest.Matcher.*;

public class Tests {

    public GetResourceById getResourceById;
    private static RestTemplate restTemplate;
    private final static String API_BASE="https://jsonplaceholder.typicode.com";
    private static User[] users;

    @BeforeClass
    public static void  setUp()
    {
        restTemplate = new RestTemplate();
        users = restTemplate.getForObject(API_BASE+"/posts", User[].class);
    }

    @Test
    public void filterByUserId()
    {
        ArrayList<User> filteredUsers = new ArrayList<User>();
        String query = "7";

        for (int i=0; i<users.length; ++i)
        {
            if(users[i].getUserId().indexOf(query) != -1)
            {
                filteredUsers.add(users[i]);
            }
        }
        assertTrue(filteredUsers.size() != 0);
    }

    @Test
    public void filterByTitle()
    {
        ArrayList<User> filteredUsers = new ArrayList<User>();
        String query = "olestias quasi exercitati";
        int itemNumber = 0;

        for (int i=0; i<users.length; ++i)
        {
            if(users[i].getTitle().indexOf(query) != -1)
            {
                filteredUsers.add(users[i]);
            }
        }
        assertTrue(filteredUsers.size() != 0);
    }

    @Test
    public void filterByBody()
    {
        ArrayList<User> filteredUsers = new ArrayList<User>();
        String query = "suscipit nam nisi quo aperiam aut";
        int itemNumber = 0;

        for (int i=0; i<users.length; ++i)
        {
           if(users[i].getBody().indexOf(query) != -1)
           {
               filteredUsers.add(users[i]);
           }
        }
        assertTrue(filteredUsers.size() != 0);
    }

    @Test
    public void getByIdOf3()
    {
        getResourceById = new GetResourceById();
        assertTrue(getResourceById.GetUserById(users,3));
    }

    @Test
    public void getByIdOf5()
    {
        getResourceById = new GetResourceById();
        assertTrue(getResourceById.GetUserById(users,5));
    }

    @Test
    public void getByIdOf95()
    {
        getResourceById = new GetResourceById();
        assertTrue(getResourceById.GetUserById(users,95));
    }

    @Test
    public void getByIdOf100()
    {
        getResourceById = new GetResourceById();
        assertTrue(getResourceById.GetUserById(users,100));
    }

    @Test
    public void getListResources()
    {
        assertTrue(users.length>0);
    }

    @Test
    public void taskNumberTwo() throws IOException {
        URL url = new URL(API_BASE+"/posts/0");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        assertTrue(con.getResponseCode()==200);
    }
}
