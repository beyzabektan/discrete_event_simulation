
public class MassageArrival implements Comparable<MassageArrival>{
	Player player;
	double arrivaltime;
	double duration;
	
	public MassageArrival(Player player, double arrivaltime, double duration) {
		this.player = player;
		this.arrivaltime = arrivaltime;
		this.duration = duration;
	}
	
	public int compareTo(MassageArrival massagearrival) {
	        if (this.arrivaltime > massagearrival.arrivaltime) {
	        	if ((this.arrivaltime - massagearrival.arrivaltime) < 0.0000000001) {
	        		if (this.player.id > massagearrival.player.id) {
		            	return 1;
		            }
		            
		            else if (this.player.id < massagearrival.player.id) {
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
	        else if (this.arrivaltime < massagearrival.arrivaltime) {
	        	if ((massagearrival.arrivaltime - this.arrivaltime) < 0.0000000001) {
	        		if (this.player.id > massagearrival.player.id) {
		            	return 1;
		            }
		            
		            else if (this.player.id < massagearrival.player.id) {
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
	            if (this.player.id > massagearrival.player.id) {
	            	return 1;
	            }
	            
	            else if (this.player.id < massagearrival.player.id) {
	            	return -1;
	            }
	            else {
	            	return 0;
	            }
	        }
		}
    }

