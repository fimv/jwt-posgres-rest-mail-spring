package net.proselyte.jwtappdemo.service;

import java.util.List;
import net.proselyte.jwtappdemo.model.Message;
import net.proselyte.jwtappdemo.model.User;

/**
 * Service interface for class {@link User}.
 */

public interface UserService {

    User register(User user);

    List<User> getAll();

    User findByUsername(String username);

    User findById(Long id);

    void delete(Long id);

	void sendMessage(User currentUser, List<Message> messages);
}
