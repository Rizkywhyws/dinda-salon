package BaseApp;

public class SessionLogin {
    private static String username;
    private static String namaUser;
    private static String level;
    private static int idUser;
    
    // Setter methods
    public static void setUsername(String username) {
        SessionLogin.username = username;
    }
    
    public static void setNamaUser(String namaUser) {
        SessionLogin.namaUser = namaUser;
    }
    
    public static void setLevel(String level) {
        SessionLogin.level = level;
    }
    
    public static void setIdUser(int idUser) {
        SessionLogin.idUser = idUser;
    }
    
    // Getter methods
    public static String getUsername() {
        return username;
    }
    
    public static String getNamaUser() {
        return namaUser;
    }
    
    public static String getLevel() {
        return level;
    }
    
    public static int getIdUser() {
        return idUser;
    }
    
    // Method untuk clear session saat logout
    public static void clearSession() {
        username = null;
        namaUser = null;
        level = null;
        idUser = 0;
    }
    
    // Method untuk cek apakah user sudah login
    public static boolean isLoggedIn() {
        return username != null && !username.isEmpty();
    }
}