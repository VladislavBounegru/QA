import org.springframework.web.client.RestTemplate;

public class GetResourceById {

    public boolean GetUserById(User[] users, int id)
    {

        for (int i=0; i<users.length; ++i)
        {
            if(users[i].getId() == id)
            {
                return true;
            }
        }
        return false;
    }
}
