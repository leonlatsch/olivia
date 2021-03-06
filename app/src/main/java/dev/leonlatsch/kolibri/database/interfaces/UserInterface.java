package dev.leonlatsch.kolibri.database.interfaces;

import com.activeandroid.query.Select;

import java.util.List;

import dev.leonlatsch.kolibri.database.model.User;
import dev.leonlatsch.kolibri.rest.dto.UserDTO;

/**
 * Child of {@link CacheInterface}
 * Syncs the database table 'user' and the Entity {@link User}
 *
 * @author Leon Latsch
 * @since 1.0.0
 */
public class UserInterface extends CacheInterface<User> {

    private static UserInterface userInterface; // Singleton

    private UserInterface() {
        setModel(getUser());
    }

    public static UserInterface getInstance() {
        if (userInterface == null) {
            userInterface = new UserInterface();
        }

        return userInterface;
    }

    public void loadUser() {
        List<User> list = new Select().from(User.class).execute();
        if (list.size() <= 1) {
            if (list.size() == 1) {
                setModel(list.get(0));
            } else {
                setModel(null);
            }
        } else {
            throw new RuntimeException("more than one user in database"); // Should never happen case
        }
    }

    public User getUser() {
        if (getModel() == null) {
            loadUser();
        }
        return getModel();
    }

    public String getAccessToken() {
        if (getModel() == null) {
            loadUser();
        }

        return getModel().getAccessToken();
    }

    public void save(UserDTO userDto, String accessToken) {
        User user = getDatabaseMapper().toModel(userDto);
        user.setAccessToken(accessToken);
        save(user);
    }

    @Override
    public void save(User user) {
        super.save(user);
        loadUser();
    }
}
