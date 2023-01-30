
public class Event implements Comparable<Event>{
	String name;
	double time;
	int playerID;
	
	
	public Event(String name, double time, int playerID) {
		this.name = name;
		this.time = time;
		this.playerID = playerID;
		
	}
	
	public int compareTo(Event event) {
        if (this.time > event.time) {
        	if ((this.time - event.time) < 0.0000000001) {
        		if (this.playerID > event.playerID) {
                	return 1;
                }
                
                else if (this.playerID < event.playerID) {
                	return -1;
                }
                else {
                	return 0;
                }
        	}
        	
        	else {
        		return 1;
        	}
        } 
        else if (this.time < event.time) {
        	
        	if ((event.time - this.time) < 0.0000000001) {
        		if (this.playerID > event.playerID) {
                	return 1;
                }
                
                else if (this.playerID < event.playerID) {
                	return -1;
                }
                else {
                	return 0;
                }
        	}
        	
        	else {
        		return -1;
        		
        	}
        } 
        
        
        else {
            if (this.playerID > event.playerID) {
            	return 1;
            }
            
            else if (this.playerID < event.playerID) {
            	return -1;
            }
            else {
            	return 0;
            }
        }
    }
}
