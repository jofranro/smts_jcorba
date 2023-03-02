import SMTS.*;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;

public class Client
{
  static Account accountImpl;

  public static void main(String args[])
    {
      try{
        // create and initialize the ORB
        String[] orbArgs = new String[3];
        orbArgs[0] = args[0];
        orbArgs[1] = args[1];
        orbArgs[2] = args[2];
        //orbArgs[3] = args[3];
        ORB orb = ORB.init(orbArgs, null);
        
        //System.out.println(args[4]);
        // get the root naming context
        org.omg.CORBA.Object objRef = 
            orb.resolve_initial_references("NameService");
        // Use NamingContextExt instead of NamingContext. This is 
        // part of the Interoperable naming Service.  
        NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
 
        // resolve the Object Reference in Naming
        String name = "bank";
        accountImpl = AccountHelper.narrow(ncRef.resolve_str(name));

        System.out.println("Obtained a handle on server object: " + accountImpl);
        
        try{
            switch(args[4]){
                
                case "balance":
                    try{
                        System.out.format("Balance is %.2f\n", (accountImpl.getBalance(args[5])));
                    }
                    catch(Exception e){
                        System.out.println("insert account ID");
                    }
                    break;
                
                case "deposit":
                    try{
                        accountImpl.deposit(Double.parseDouble(args[5]));
                    }
                    catch(Exception e){
                        System.out.println("Insert deposit amount.");
                    }
                    break;
                   
                case "withdraw":
                    try{
                        accountImpl.withdraw(Double.parseDouble(args[5]));
                        //System.out.println(args[5]);
                    }
                    catch(Exception e){
                        System.out.println("Insert withdraw amount.");
                    }
                    break;
                case "closeacc":
                    try{
                        accountImpl.closeAccount();
                    }
                    catch(Exception e){
                        System.out.println("Insert account ID.");
                    }
                    break;

                case "shutdown":
                    accountImpl.shutdown();
                    break;
                
                case "help":
                    System.out.println("balance <account ID>");
                    System.out.println("deposit <amount>");
                    System.out.println("withdraw <amount>");
                    System.out.println("closeacc <account ID>");
                    System.out.println("shutdown");
                    break;            
                
                case "payinterest":
                    try{
                        accountImpl.withdraw(Double.parseDouble(args[5]));
                    }
                    catch(Exception e){
                        System.out.println("Insert withdraw amount.");
                    }
                    break;
                    
                case "giveloan":
                    try{
                        accountImpl.deposit(Double.parseDouble(args[5]));
                    }
                    catch(Exception e){
                        System.out.println("Insert deposit amount.");
                    }
                    break;
    
                default:
                    System.out.println("Client server is operational.");
                    break;
            }
        }catch(Exception e){
            System.out.println("Input error");
        }
        
        } catch (Exception e) {
          System.out.println("ERROR : " + e) ;
          e.printStackTrace(System.out);
        }
    }
}