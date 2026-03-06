package br.saks.register_services.securities;

public class SessionContext {

    private static String token;

    public static void setToken(String jwt) {
        token = jwt;
    }

    public static String getToken() {
        return token;
    }

    public static void clear() {
        token = null;
    }
}