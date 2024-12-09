public class Pessoa {

    public static boolean emailValid(String email) {
        if (email == null) {
            return false;
        }

        // Verifica se contém "@"
        if (!email.contains("@")) {
            return false;
        }

        // Verifica se possui no máximo 50 caracteres
        if (email.length() > 50) {
            return false;
        }

        return true;
    }
}

