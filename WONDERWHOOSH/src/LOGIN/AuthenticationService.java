package LOGIN;

import java.util.ArrayList;
import java.util.List;

public class AuthenticationService {
    private List<User> users;

    public AuthenticationService() {
        users = new ArrayList<>();
        users.add(new User("user1", "pass1"));
        users.add(new User("user2", "pass2"));
    }

    public boolean authenticate(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}

