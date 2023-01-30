
public class WaitingTimeMQ implements Comparable<WaitingTimeMQ>{
	Player player;
	double waitingTime;
	
	public WaitingTimeMQ(Player player, double waitingTime) {
		this.player = player;
		this.waitingTime = waitingTime;
		
	}
	
	public int compareTo(WaitingTimeMQ waitingTimeMQ) {
        if (this.waitingTime > waitingTimeMQ.waitingTime) {
        	if ((this.waitingTime - waitingTimeMQ.waitingTime) < 0.0000000001) {
        		if (this.player.id > waitingTimeMQ.player.id) {
                	return 1;
                }
                
                else if (this.player.id < waitingTimeMQ.player.id) {
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
        else if (this.waitingTime < waitingTimeMQ.waitingTime) {
        	if ((waitingTimeMQ.waitingTime - this.waitingTime) < 0.0000000001) {
        		if (this.player.id > waitingTimeMQ.player.id) {
                	return 1;
                }
                
                else if (this.player.id < waitingTimeMQ.player.id) {
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
        	if (this.player.id > waitingTimeMQ.player.id) {
            	return 1;
            }
            
            else if (this.player.id < waitingTimeMQ.player.id) {
            	return -1;
            }
            else {
            	return 0;
            }
    	
        }
    }

}
