package src.routes;
import java.util.Scanner;

/* Responsible for gathering user information and allows TV object to be tangable
    User can call methods from an instance of a TV class unique to each remote. */
public class Remote {

    // An instance refrence for the TV class
    private Television myTv;

    // Constructor method which initializes the myTv object to a CERTAIN remote

    public Remote(Television myTv){
        this.myTv = myTv;

    }

    /*  Method which processes user input and allows the user to interact with the tv    
        Will loop until the powerOff command is called.

        USES A SCANNER REFRENCE AS A PARAMETER -> User input determines actions of tv
        Prompts the user to input their wanted actions with a prompt:
        Enter Remote Command (0 = Power On, 1 = Channel Up, 2 = Channel Down, 3 = Volume Up, 4 = Volume Down, 5 = Power Off): 
            - Input must be an integer ranging from 0-5
                - IF it is not an integer, or in the range of 0-5 -> Use the default number(5) which calls the  "powerOff" function
     */
    public void processInput(Scanner s){
        int cmd;
        boolean powerOn = false;
        
        while (powerOn == false){
            System.out.print("Enter Remote Command (0 = Power On, 1 = Channel Up, 2 = Channel Down, 3 = Volume Up, 4 = Volume Down, 5 = Power Off): ");
            if(!s.hasNextInt()){
                break;
            }else{
            cmd = s.nextInt(); 
            if (cmd == 0){
                actionForInput(0);
                powerOn = true;
                continue;
            } else {continue;}
            
            }
        }
        
        while (powerOn == true){
            
            
            System.out.print("Enter Remote Command (0 = Power On, 1 = Channel Up, 2 = Channel Down, 3 = Volume Up, 4 = Volume Down, 5 = Power Off): ");
            if(!s.hasNextInt()){
                actionForInput(5);
                break;
            }else{
            cmd = s.nextInt();    
            }
            

            if (cmd >= 0 && cmd <= 5) {
                actionForInput(cmd);
                
                    if (cmd == 5) {
                        actionForInput(5);
                        powerOn = false;
                    
                    }
            } else {
    
                actionForInput(5);
                powerOn = false;
            }

        }
        
        

    }

    
    // Method which takes in a command and performs the action associated with it
    // actionForInput: 
    // The processInput method will call this  with the command as a parameter
    // This method will only provide 5 actions which correspond to the commands:
    // 0 = Power On, 1 = Channel Up, 2 = Channel Down, 3 = Volume Up, 4 = Volume Down, 5 = Power Off
    // It will return with the value of the command which was called
    private String actionForInput(int cmd){
        // could use switch as well
        if(cmd == 0){
           myTv.powerOn();
           
        } else if (cmd == 1){
            myTv.channelUp();
            
        } else if (cmd == 2){
            myTv.channelDown();
            
        } else if (cmd == 3){
            myTv.volumeUp();
            
        } else if (cmd == 4){
            myTv.volumeDown();
            
        } else if (cmd == 5){
            myTv.powerOff();
            
        } else {
            myTv.powerOff();
        }
        
        return null;
    } 
    

}