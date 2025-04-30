package src.routes;


/* Television class which allows the user to view and alter:
 * Volume
 * Channel
 * Power
 * This class is used to control the television and is used by the remote class
 * THE TELEVISION CLASS WILL ONLY WORK IF IT IS ON!!!!
 */
public class Television
{
    // Variables declaring the state of the television
    public final static int MAX_CHANNEL = 2;
    public final static int MAX_VOLUME = 6;
    
    private int currentChannel;
    private int currentVolume;
    private boolean on;

    // Constructor for the television class
    public Television(){
        this.currentChannel = 0;
        this.currentVolume =  MAX_VOLUME / 2;
        this.on = false;
    }


        // Mutator and Accessor methods for the television class

    /* ----------------------------------------------------------------------------------------------------
        Methods to access the properties of 
        Channel, Volume, and Power
        Getters for the properties of the television
    */ 
    public int getChannel(){
        return this.currentChannel;
        
    
    }
    
    public int getVolume(){
        return this.currentVolume;
        

    }

    public boolean getOn(){
        return this.on;
    }

    /* Setters for the properties of the television
        Allows the user to alter the values of the
        Channel, Volume, and Power
    */

   public void setChannel(int channel){
        if (this.on == true){
           this.currentChannel = channel; 
        }
        
   }

    public void setVolume(int volume){
        if (this.on == true){
            this.currentVolume = volume; 
         }
    }

    public void setOn(boolean power){
        this.on = power;
    }
    
    // ----------------------------------------------------------------------------------------------------

    /*  Methods to alter the power status of the television*/

    // This method turns the television on
    // If the television is already on, it does nothing
    // If the television is off:
        // on = true
        // prints "TV: Powering On"
    public void powerOn(){
        if (getOn() == false){
            setOn(true);
            System.out.println("TV: Powering On");
        } 
    }

    // This method turns the television off
    // If the television is already off, it does nothing
    // If the television is on:
        // on = false
        // prints "TV: Powering Off"
    public void powerOff(){
        if (getOn() == true){
            System.out.println("TV: Powering Off");
            setOn(false);
        }
    }

    // ----------------------------------------------------------------------------------------------------

    /* Methods to change the channels
     * If the Television is off, it does nothing
     * Remember too wrap the channel if needed
     */
    
     // This method changes to the next channel
     // If the television is off, it does nothing
     // If the television is on:
        // Add 1 to the current channel
        // If the current channel is greater than the max channel -> set current channel to 0
            // Calls the getShow method from schedule.java 
            // Prints "TV: Now Showing "<show>" on Channel <currentChannel>"
    public void channelUp(){
        // Create currentShow and currentChannel variables
        String newShow;
        int newChannel = getChannel();

        //If the television is on:
            //Add 1 to the current channel
            //If the current channel > than max channel -> set current channel to 0
                //If else -> set current channel to current channel + 1
            //Set show to the value of the getShow method from schedule.java
            // print
        // Else do nothing
        if (getOn() == true){
            
            if (newChannel + 1 > MAX_CHANNEL){
                newChannel = 0;
            } else {
                newChannel += 1;
            }

            newShow = Schedule.getShow(newChannel);
            setChannel(newChannel);
            System.out.println("TV: Now Showing \"" + newShow + "\" on Channel " + newChannel);
        } 

        
    }

    // This method changes to the previous channel
    // If the television is off, it does nothing
    // If the television is on:
        // Subtract 1 from the current channel
        // If the current channel is less than 0 -> set current channel to max channel
            // Calls the getShow method from schedule.java 
            // Prints "TV: Now Showing "<show>" on Channel <currentChannel>"

    public void channelDown(){
        String newShow;
        int newChannel = getChannel();

        //If the television is on:
            //Subtract 1 from the current channel
            //If the current channel < 0 -> set current channel to max channel
                //If else -> set current channel to current channel - 1
            //Set show to the value of the getShow method from schedule.java
            // print
        // Else do nothing
        if (getOn() == true){
            
            if (newChannel - 1 < 0){
                newChannel = MAX_CHANNEL;
            } else {
                newChannel -= 1;
            }

            newShow = Schedule.getShow(newChannel);
            setChannel(newChannel);
            System.out.println("TV: Now Showing \"" + newShow + "\" on Channel " + newChannel);

        }

        
    }
    
    // ----------------------------------------------------------------------------------------------------

    /* Methods to change the volume
     * If the Television is off, it does nothing
     */

    // This method increases the volume by 1
    // If the television is off, it does nothing
    // If the television is on:
        // Add 1 to the current volume
        // If the current volume is greater than the max volume -> set current volume Max volume
            // Prints "TV: Volume Up to <currentVolume>"
    public void volumeUp(){
        int newVolume = getVolume();

        //If the television is on:
            //Add 1 to the current volume
            //If the current volume > than max volume -> set current volume to max volume
                // print statement
        // Else do nothing
        if (getOn() == true){
            if (newVolume + 1 > MAX_VOLUME){
                newVolume = MAX_VOLUME;
            } else {
                newVolume += 1;
            }  

            setVolume(newVolume);
            System.out.println("TV: Volume Up to " + newVolume);
        }
        
    }

    // This method decreases the volume by 1
    // If the television is off, it does nothing
    // If the television is on:
        // Subtract 1 from the current volume
        // If the current volume is less than 0 -> set current volume to 0
            // Prints "TV: Volume Down to <currentVolume>"
    public void volumeDown(){
        int newVolume = getVolume();

        //If the television is on:
            //Subtract 1 from the current volume
            //If the current volume < 0 -> set current volume to 0
                // print statement
        // Else do nothing
        if (getOn() == true){
            
            if (newVolume - 1 < 0){
                newVolume = 0;
            } else {
                newVolume -= 1;
            }
            
            setVolume(newVolume);
            System.out.println("TV: Volume Down to " + newVolume);
        }
        
    }

}
