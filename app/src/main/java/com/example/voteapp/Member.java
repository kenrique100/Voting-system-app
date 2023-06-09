package com.example.voteapp;

public class Member {
    String president;
    private String second;
    private String third;
    private String fourth;
    private String fiveth;

    String department, candidate;


    public Member() {

    }

    public String getDepartment() {
        return department;
    }

    public String getCandidate() {
        return candidate;
    }


    public String getPresident() {
        return president;
    }

    public void setPresident(String president) {
        this.president = president;
    }

    public String getSecond() {
        return second;
    }

    public void setSecond(String second) {
        this.second = second;
    }

    public String getThird() {
        return third;
    }

    public void setThird(String third) {
        this.third = third;
    }

    public String getFourth() {
        return fourth;
    }

    public void setFourth(String fourth) {
        this.fourth = fourth;
    }

    public String getFiveth() {
        return fiveth;
    }

    public void setFiveth(String fiveth) {
        this.fiveth = fiveth;
    }
}
