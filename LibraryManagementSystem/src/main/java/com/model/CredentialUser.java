package com.model;

import javax.validation.Valid;

public class CredentialUser {
    @Valid
    private Credential credential;
    @Valid
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
