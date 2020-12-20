package banksystem.dao.model.security;

public enum Permission {
    WRITE("admin:write"),
    READ("client:read");

    private final String permission;

    Permission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
