package com.spring.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ACCOUNTS")
public class Account {

    @Id
    @Column(name = "ACCOUNT")
    private String account;
    @Column(name = "BALANCE")
    private int balance;
    @Column(name = "TYPE")
    private String type;

    protected Account()
    {

    }

    public Account(String account, int balance, String type) {
        this.account = account;
        this.balance = balance;
        this.type = type;
    }

    public String getAccount() {
        return account;
    }

    public int getBalance() {
        return balance;
    }

    public String getType(){
        return type;
    }


    @Override
    public String toString() {
        return "Account{" +
                "account='" + account + '\'' +
                ", balance=" + balance +
                ", type='" + type + '\'' +
                '}';
    }
}
