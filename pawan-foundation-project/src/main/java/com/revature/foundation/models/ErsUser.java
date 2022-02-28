package com.revature.foundation.models;

import java.util.Objects;
import java.util.UUID;

public class ErsUser {

        private String ID;
        private String username;
        private String password;
        private String email;
        private String givenName;
        private String surName;
        private String roleId;
        private boolean isActive;


        public ErsUser() {
                super();
        }

        public ErsUser(String givenName, String surName, String email, String username, String password, String roleId, boolean isActive) {

                setGivenName(givenName);
                setSurName(surName);
                setEmail(email);
                setUsername(username);
                setPassword(password);
                setRoleId(roleId);
                setIsActive(isActive);
        }

        public String getId() {
                return this.ID = UUID.randomUUID().toString();
        }

        public String setId(String ID) {
                return this.ID = UUID.randomUUID().toString();

        }

        public String getUsername() {
                return username;
        }

        public void setUsername(String username) {
                this.username = username;
        }

        public String getPassword() {
                return password;
        }

        public void setPassword(String password) {
                this.password = password;
        }

        public void setSurName(String surName) {
                this.surName = surName;
        }

        public String getSurName() {
                return surName;
        }

        public String getGivenName() {
                return givenName;
        }

        public void setGivenName(String givenName) {
                this.givenName = givenName;
        }

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public String getRoleId() {
                return roleId;
        }

        public void setRoleId
                (String roleId) {
                this.roleId = roleId;
        }

        public boolean getIsActive() {
                return isActive;
        }

        public void setIsActive(boolean isActive) {
                this.isActive = isActive;
        }

        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                ErsUser ersUser = (ErsUser) o;
                return isActive == ersUser.isActive && Objects.equals(ID, ersUser.ID) && Objects.equals(username, ersUser.username) && Objects.equals(password, ersUser.password) && Objects.equals(email, ersUser.email) && Objects.equals(givenName, ersUser.givenName) && Objects.equals(surName, ersUser.surName) && Objects.equals(roleId, ersUser.roleId);
        }

        @Override
        public int hashCode() {
                return Objects.hash(ID, username, password, email, givenName, surName, roleId, isActive);
        }

        @Override
        public String toString() {
                return "ErsUser{" +
                        "ID='" + ID + '\'' +
                        ", username='" + username + '\'' +
                        ", password='" + password + '\'' +
                        ", email='" + email + '\'' +
                        ", givenName='" + givenName + '\'' +
                        ", surName='" + surName + '\'' +
                        ", roleId='" + roleId + '\'' +
                        ", isActive=" + isActive +
                        '}';
        }
}


