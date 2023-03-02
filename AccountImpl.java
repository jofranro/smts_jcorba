import SMTS.*;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;
import org.omg.PortableServer.POA;

import java.util.Properties;

class AccountImpl extends AccountPOA {
  private ORB orb;
  public String id;
  public double balance;
  
  public void setORB(ORB orb_val) {
    orb = orb_val; 
  }

  // implement sayHello() method
  public double getBalance(String accID) {
    return this.balance;
  }
  
  public void deposit(double amount){
    this.balance += amount;
  }
  
  public void withdraw(double amount){
    this.balance -= amount;
  }

  public void closeAccount(){
    this.balance = 0;
  }
  public void invest(double amount){
    this.balance = amount * 0.3;
  }
  public void payInterest(double amount){
    double interest = amount * 0.05;
    this.balance -= interest;
  }
  public void giveLoan(double amount){
    this.balance += amount;
  }
  public void openAccount(String id, double balance){
    this.id = id;
    this.balance = balance;
  }
  // implement shutdown() method
  public void shutdown() {
    orb.shutdown(false);
  }

}
