
public class MassageQueue implements Comparable<MassageQueue>{
	Player player;
	double arrivaltime;
	double duration;
	
	public MassageQueue(Player player, double arrivaltime, double duration) {
		this.player = player;
		this.arrivaltime = arrivaltime;
		this.duration = duration;
	}
	
	public int compareTo(MassageQueue massagequeue) {
		if (this.player.skilllevel > massagequeue.player.skilllevel) {
			return -1;
		}
		
		else if (this.player.skilllevel < massagequeue.player.skilllevel) {
			return 1;
		}
		
		else {
	        if (this.arrivaltime > massagequeue.arrivaltime) {
	        	if ((this.arrivaltime - massagequeue.arrivaltime) < 0.0000000001) {
	        		if (this.player.id > massagequeue.player.id) {
		            	return 1;
		            }
		            
		            else if (this.player.id < massagequeue.player.id) {
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
	        
	        
	        
	        else if (this.arrivaltime < massagequeue.arrivaltime) {
	        	if ((massagequeue.arrivaltime - this.arrivaltime) < 0.0000000001){
	        		if (this.player.id > massagequeue.player.id) {
		            	return 1;
		            }
		            
		            else if (this.player.id < massagequeue.player.id) {
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
	            if (this.player.id > massagequeue.player.id) {
	            	return 1;
	            }
	            
	            else if (this.player.id < massagequeue.player.id) {
	            	return -1;
	            }
	            else {
	            	return 0;
	            }
	        }
		}
    }
}

