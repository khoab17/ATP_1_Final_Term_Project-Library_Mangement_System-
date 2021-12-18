package com.model;

public class CredentialUser {
    private Credential credential;
    private User user;
    public CredentialUser(){}

    public CredentialUser(Credential credential, User user) {
        this.credential = credential;
        this.user = user;
    }

    public Credential getCredential() {
        return credential;
    }

    public void setCredential(Credential credential) {
        this.credential = credential;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
