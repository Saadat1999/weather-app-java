package model.client;

import model.Person;
import model.products.*;

public class Client extends Person {
    private String job;
    private String address;
    private Loan loan;
    private Card card;
    private Deposit deposit;
    private int branchCode;

    public Client(int cif, String name, String surname, int age, double salary, String job, String address, int branchCode) {
        this.cif = cif;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.salary = salary;
        this.job = job;
        this.address = address;
        this.branchCode = branchCode;
    }

    public void getLoan(Loan loan) {
        this.loan = loan;
    }
    public Loan showLoan() {
        return loan;
    }

    public void getCard(Card card) {
        this.card = card;
    }
    public Card showCard() {
        return card;
    }

    public void addDeposit(Deposit deposit) {
        this.deposit = deposit;
    }
    public Deposit showDeposit() {
        return deposit;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(int branchCode) {
        this.branchCode = branchCode;
    }
}
