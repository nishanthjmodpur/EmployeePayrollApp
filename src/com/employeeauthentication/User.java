package com.employeeauthentication;

//Abstract User class
public abstract class User {
 protected String username;
 protected String passwordHash;
 protected String role;

 public User(String username, String password, String role) {
     this.username = username;
     this.passwordHash = PasswordUtil.hashPassword(password);
     this.role = role;
 }

 public String getRole() {
     return role;
 }

 public String getUsername() {
     return username;
 }
 
 // Abstract method forces subclasses to define authentication logic
 public abstract boolean authenticate(String username, String password);
}


