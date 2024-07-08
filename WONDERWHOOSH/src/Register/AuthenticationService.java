package Register;

import java.util.ArrayList;
import java.util.List;

public class AuthenticationService {
    private List<User> users;

    public AuthenticationService() {
        users = new ArrayList<>();
        users.add(new User("user1", "123", "user1@gmail.com"));
        users.add(new User("user2", "1234", "user2@gmail.com"));
    }

    public boolean authenticate(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public boolean register(String username, String password, String email) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return false; // Username sudah ada
            }
        }
        users.add(new User(username, password, email));
        return true;
    }
}

