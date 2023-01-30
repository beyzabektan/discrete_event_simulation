
public class WaitingTimePQ implements Comparable<WaitingTimePQ>{
	Player player;
	double waitingTime;
	
	public WaitingTimePQ(Player player, double waitingTime) {
		this.player = player;
		this.waitingTime = waitingTime;
		
	}
	
	public int compareTo(WaitingTimePQ waitingTimePQ) {
        if (this.waitingTime > waitingTimePQ.waitingTime) {
        	if ((this.waitingTime - waitingTimePQ.waitingTime) < 0.0000000001) {
        		if (this.player.id > waitingTimePQ.player.id) {
                	return 1;
                }
                
                else if (this.player.id < waitingTimePQ.player.id) {
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
        else if (this.waitingTime < waitingTimePQ.waitingTime) {
        	if ((waitingTimePQ.waitingTime - this.waitingTime) < 0.0000000001) {
        		if (this.player.id > waitingTimePQ.player.id) {
                	return 1;
                }
                
                else if (this.player.id < waitingTimePQ.player.id) {
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
        
        
        else {
        	if (this.player.id > waitingTimePQ.player.id) {
            	return 1;
            }
            
            else if (this.player.id < waitingTimePQ.player.id) {
            	return -1;
            }
            else {
            	return 0;
            }
    	
        }
    }

}
