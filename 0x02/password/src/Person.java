import java.util.regex.Pattern;

public class Person {

    // Valida o nome de usuário
    public boolean checkUser(String username) {
        if (username == null || username.length() < 8) {
            return false;
        }
        return Pattern.matches("^[a-zA-Z0-9]+$", username); // Apenas letras e números
    }

    // Valida a senha
    public boolean checkPassword(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }
        boolean hasUppercase = Pattern.compile("[A-Z]").matcher(password).find();
        boolean hasNumber = Pattern.compile("[0-9]").matcher(password).find();
        boolean hasSpecialChar = Pattern.compile("[^a-zA-Z0-9]").matcher(password).find();

        return hasUppercase && hasNumber && hasSpecialChar;
    }
}
