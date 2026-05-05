package service;

import util.HashUtil;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class AuthService {
    private static final String USERS_FILE = "data/users.txt";

    public static boolean login(String username, String password) {
        Map<String, String> users = loadUsers();
        String hashed = HashUtil.hashPassword(password);
        return users.containsKey(username) && users.get(username).equals(hashed);
    }

    public static String register(String username, String password) {
        if (!HashUtil.checkPasswordStrength(password)) {
            return "Password too weak. Min 6 characters.";
        }
        Map<String, String> users = loadUsers();
        if (users.containsKey(username)) {
            return "Username already taken.";
        }
        
        String hashed = HashUtil.hashPassword(password);
        FileService.appendLine(USERS_FILE, username + ":" + hashed);
        return "SUCCESS";
    }

    private static Map<String, String> loadUsers() {
        Map<String, String> map = new HashMap<>();
        List<String> lines = FileService.readLines(USERS_FILE);
        for (String line : lines) {
            String[] parts = line.split(":");
            if (parts.length == 2) {
                map.put(parts[0], parts[1]);
            }
        }
        return map;
    }
}
