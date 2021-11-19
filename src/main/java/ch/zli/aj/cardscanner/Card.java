package ch.zli.aj.cardscanner;

import java.util.ArrayList;

public class Card {

    public String firstname;
    public String lastname;
    public String company;
    public String role;

    public Card(String firstname, String lastname, String company, String role) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.company = company;
        this.role = role;
    }

    public static ArrayList<Card> createCards(int num){
        ArrayList<Card> cards = new ArrayList<>();

        for(int i = 0; i < num; i++){
            cards.add(new Card("aksel", "jessen", "cognizant", ""));
        }

        return cards;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
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
