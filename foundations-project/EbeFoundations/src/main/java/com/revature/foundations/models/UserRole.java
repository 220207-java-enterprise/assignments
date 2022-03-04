package com.revature.foundations.models;

public class UserRole {
    private String roleId;
    private String roleName;

    public UserRole() {
        super();
    }

    public UserRole(String roleId, String role) {
        this.roleId = roleId;
        this.roleName = role;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String role_id) {
        this.roleId = role_id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String role) {
        this.roleName = role;
    }

    @Override
    public String toString() {
        return "userRoles{" +
                "role_id='" + roleId + '\'' +
                ", role='" + roleName + '\'' +
                '}';
    }
}
