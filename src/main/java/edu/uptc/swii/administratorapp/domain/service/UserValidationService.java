package edu.uptc.swii.administratorapp.domain.service;

import edu.uptc.swii.administratorapp.domain.model.user.User;
import edu.uptc.swii.administratorapp.domain.model.user.Password;
import edu.uptc.swii.administratorapp.domain.exception.UserValidationException;

public class UserValidationService {
    public void validateUserForCreation(User user) {
        if (user == null) {
            throw new UserValidationException("User cannot be null");
        }
    }

    public void validatePasswordUpdate(Password newPassword) {
        if (newPassword == null) {
            throw new UserValidationException("New password cannot be null");
        }
        // Aquí irían validaciones adicionales de contraseña
    }
}
