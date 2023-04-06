package com.almousleck.user_api;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> fetchUsers();
    User registerUser(RegistrationRequest request);
    Optional<User> findByEmail(String email);
    void saveUserVerifyToken(User user, String verificationToken);
    String validateToken(String token);

}
