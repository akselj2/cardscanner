package ch.zli.aj.cardscanner;

import java.util.ArrayList;

public class Card {

    public String name;
    public String company;
    public String role;

    public Card(String name, String company, String role) {
        this.name = name;
        this.company = company;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
