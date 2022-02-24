package com.revature.foundation;

import java.util.UUID;

public class UserDetail {

        private String ID;
        private String username;
        private String password;
        private String email;
        private String givenName;
        private String surName;


        UserDetail(String ID, String givenName, String surName, String email, String username, String password){

        }

        public void setID(String ID){
                this.ID = UUID.randomUUID().toString();
        }

        public String getID() {
                return ID;
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

        @Override
        public String toString(){
                return "User ID: " + ID +
                        "User Name:" + givenName +
                        "User Surname: " + surName +
                        "User Email: " + email +
                        "User Username: " + username +
                        "User Password: " + password;

        }
}
