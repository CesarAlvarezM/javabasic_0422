package Model;

public class Account {

    private String account_number;
    private String user;
    private String password;
    private String opening_date;
    private Double balance;

    public Account(){}

    public Account (String account_number, String user, String password, String opening_date, Double balance){
        this.account_number=account_number;
        this.user=user;
        this.password=password;
        this.opening_date=opening_date;
        this.balance=balance;
    }

    public void setAccount_number(String account_number){
        this.account_number=account_number;
    }

    public String getAccount_number(){
        return this.account_number;
    }

    public void setUser(String user){
        this.user=user;
    }

    public String getUser(){
        return this.user;
    }

    public void setPassword(String password){
        this.password=password;
    }

    public String getPassword(){
        return this.password;
    }

    public void setOpening_date(String opening_date){
        this.opening_date=opening_date;
    }

    public String getOpening_date(){
        return this.opening_date;
    }

    public void setBalance(Double balance){
        this.balance=balance;
    }

    public Double getBalance(){
        return this.balance;
    }

}

