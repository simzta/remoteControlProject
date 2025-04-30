package src.routes;

public class Schedule
{
     /*
    dayOfWeek is represented as an integer from 0 to 6 where:
    0 = Sunday
    1 = Monday
    2 = Tuesday
    3 = Wednesday
    4 = Thursday
    5 = Friday
    6 = Saturday 
    
    hourOfDay is represented as an integer from 0 to 23 where:
    0 = 12 AM
    1 = 1 AM
    ...
    13 = 1 PM
    14 = 2 PM
    ...
    22 = 10 PM
    23 = 11 PM
    */
    private static int dayOfWeek;
    private static int hourOfDay;

    
   

    // Method which updates the variables dayOfWeek and hourOfDay, setting them to the values passed as parameters
    public static  void setTime(int newDayOfWeek,  int newHourOfDay){
        dayOfWeek = newDayOfWeek;
        hourOfDay = newHourOfDay;
        
    }

    // Method which accesses the data from the variables dayOfWeek and hourOfDay, recieveing one int parameter which indicates a certain channel
    // Returns a string with the value of the given channel
    public static String getShow(int channel){
        int channelNumber = channel;

        // Returns a string with the value of the given channel dependiing on the day of the week and the hour of the day
        // If the channel does not run at given time/day, it returns "No shows found, try again" 
        // Prompting the user to try again
        if (channelNumber == 0){
            return movieChannel(dayOfWeek, hourOfDay);
        } else if (channelNumber == 1){
            return sportsChannel(dayOfWeek, hourOfDay);
        } else if (channelNumber == 2){
            return varietyChannel(dayOfWeek, hourOfDay);
        } else {
            return "No channels found, try again";
        }

        
    }

    // ----------------------------------------------------------------------------------------------------
    // CHANNEL METHODS

    
    // Private method for channel 0
    // Movie channel
    // Runs movies every day [0-6] and every hour [0-23]
    private static String movieChannel(int dayOfWeek, int hourOfDay){
        boolean isMovieChannelAvailable; // Unnecessary variable, but kept for clarity
        String channelName;

        // If dayOfWeek is between 0 and 6 AND hourOfDay is between 0 and 23, then the movie channel is available
        // Else, it is not available
        if ((dayOfWeek >= 0 && dayOfWeek <= 6) && (hourOfDay >= 0 && hourOfDay <= 23)) {
            isMovieChannelAvailable = true;
            channelName = "Movies";

        } else {
            isMovieChannelAvailable = false;
            return "No shows found, try again";
        }
        
        return channelName;
    }

    // Private method for channel 1
    // The Sports channel
    // Same schedule every day [0-6]: 
    // When the hour is [12-20], the channel runs "Live Sports"
    // When the hour is less than 12 [0-12), or greater than 20 (20-23], the channel runs "Player Interviews"
    private static String sportsChannel(int dayOfWeek, int hourOfDay){
        boolean isSportsChannelAvailable; // Unnecessary variable, but kept for clarity
        String channelName;

        // If dayOfWeek is between 0 and 6
            // If hourOfDay is less than 12 or greater than 20, then the channel runs "Sports Interviews"  > 12 || < 20
             // Else if hourOfDay is between 12 and 2o (inclusive), then the channel runs "Live Sports"
                // Else, channel is not available
        // Else, channel is not available
        if (dayOfWeek >= 0 && dayOfWeek <=6){
            if (hourOfDay < 12 || hourOfDay > 20){
                isSportsChannelAvailable = true;
                channelName = "Player Interviews";
                
            } else if (hourOfDay >= 12 && hourOfDay <= 20){
                isSportsChannelAvailable = true;
                channelName = "Live Sports";

            } else {
                isSportsChannelAvailable = false;
                return "No shows found, try again";

            }
        } else {
            isSportsChannelAvailable = false;
            return "No shows found, try again";
        }

        return channelName;
            
    }       

    // Private method for channel 2
    // The Variety channel
    // Every weekend (Either 0 or 6):
        // When the hour is between 12 and 20 (including both 12 and 20) the channel runs "Cooking".
        // When the hour is at any other time (less than 12 or greater than 20) the channel runs "Infomercial".
    // Every weekday (1-5):
        // When the hour is below 12 the channel runs "Talk Show".
        // When the hour is between 12 and 18 (including both 12 and 18) the channel runs "Game Show".
        // When the hour is greater than than 18 the channel runs "News".
    private static String varietyChannel(int dayOfWeek, int hourOfDay){
        boolean isVarietyChannelAvailable; // Unnecessary variable, but kept for clarity
        String channelName;

        // If dayOfWeek is 0 or 6 
            // If hourOfDay is less than 12 or greater than 20, then the channel runs "Infomercial"
            // Else if hourOfDay is between 12 and 20 (inclusive), then the channel runs "Cooking"
            // Else, channel is not available

        // Else if dayOfWeek is between 1 and 5 (inclusive)
            // If hourOfDay is less than 12, then the channel runs "Talk Show"
            // Else if hourOfDay is between 12 and 18 (inclusive), then the channel runs "Game Show"
            // Else if hourOfDay is greater than 18, then the channel runs "News"

        // Else, return channel is not available
        if (dayOfWeek == 0 || dayOfWeek == 6){
            if (hourOfDay < 12 || hourOfDay > 20){
                isVarietyChannelAvailable = true;
                channelName = "Infomercial";

            } else if (hourOfDay >= 12 && hourOfDay <= 20){
                isVarietyChannelAvailable = true;
                channelName = "Cooking";

            } else {
                isVarietyChannelAvailable = false;
                return "No shows found, try again";
            }

        } else if (dayOfWeek >= 1 && dayOfWeek <= 5) {
            if (hourOfDay < 12){
                isVarietyChannelAvailable = true;
                channelName = "Talk Show";

            } else if (hourOfDay >= 12 && hourOfDay <= 18){
                isVarietyChannelAvailable = true;
                channelName = "Game Show";

            } else if (hourOfDay > 18){
                isVarietyChannelAvailable = true;
                channelName = "News";

            } else {
                isVarietyChannelAvailable = false;
                return "No shows found, try again";
            }

        } else {
            isVarietyChannelAvailable = false;
            return "No shows found, try again";
        }

        return channelName;
    }
    // ----------------------------------------------------------------------------------------------------
}
