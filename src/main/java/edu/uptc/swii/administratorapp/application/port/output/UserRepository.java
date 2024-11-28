package edu.uptc.swii.administratorapp.application.port.output;

import edu.uptc.swii.administratorapp.domain.model.user.User;
import edu.uptc.swii.administratorapp.domain.model.customer.CustomerId;
import java.util.Optional;

public interface UserRepository {
    User save(User user);
    Optional<User> findByCustomerId(CustomerId customerId);
}
