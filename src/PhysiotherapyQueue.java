
public class PhysiotherapyQueue implements Comparable<PhysiotherapyQueue>{
	Player player;
	double arrivaltime;
	
	public PhysiotherapyQueue(Player player, double arrivaltime) {
		this.player = player;
		this.arrivaltime = arrivaltime;
	}
	
	public int compareTo(PhysiotherapyQueue physiotherapyQueue) {
		if (this.player.durationoftraining > physiotherapyQueue.player.durationoftraining) {
			if ((this.player.durationoftraining - physiotherapyQueue.player.durationoftraining) < 0.0000000001){

		        if (this.arrivaltime > physiotherapyQueue.arrivaltime) {
		        	if ((this.arrivaltime - physiotherapyQueue.arrivaltime) < 0.0000000001) {
		        		if (this.player.id > physiotherapyQueue.player.id) {
			            	return 1;
			            }
			            
			            else if (this.player.id < physiotherapyQueue.player.id) {
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
		        
		        
		        else if (this.arrivaltime < physiotherapyQueue.arrivaltime) {
		        	if ((physiotherapyQueue.arrivaltime - this.arrivaltime) < 0.0000000001) {
		        		if (this.player.id > physiotherapyQueue.player.id) {
			            	return 1;
			            }
			            
			            else if (this.player.id < physiotherapyQueue.player.id) {
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
		            if (this.player.id > physiotherapyQueue.player.id) {
		            	return 1;
		            }
		            
		            else if (this.player.id < physiotherapyQueue.player.id) {
		            	return -1;
		            }
		            else {
		            	return 0;
		            }
		        }
			
			}
			
			else {
				return -1;
			}
		}
		
		
		else if (this.player.durationoftraining < physiotherapyQueue.player.durationoftraining) {
			if ((physiotherapyQueue.player.durationoftraining - this.player.durationoftraining) < 0.0000000001) {

		        if (this.arrivaltime > physiotherapyQueue.arrivaltime) {
		        	if ((this.arrivaltime - physiotherapyQueue.arrivaltime) < 0.0000000001) {
		        		if (this.player.id > physiotherapyQueue.player.id) {
			            	return 1;
			            }
			            
			            else if (this.player.id < physiotherapyQueue.player.id) {
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
		        
		        
		        else if (this.arrivaltime < physiotherapyQueue.arrivaltime) {
		        	if ((physiotherapyQueue.arrivaltime - this.arrivaltime) < 0.0000000001) {
		        		if (this.player.id > physiotherapyQueue.player.id) {
			            	return 1;
			            }
			            
			            else if (this.player.id < physiotherapyQueue.player.id) {
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
		            if (this.player.id > physiotherapyQueue.player.id) {
		            	return 1;
		            }
		            
		            else if (this.player.id < physiotherapyQueue.player.id) {
		            	return -1;
		            }
		            else {
		            	return 0;
		            }
		        }
			
			}
			
			else {
				return 1;
			}
		}
		
		
		
		else {
	        if (this.arrivaltime > physiotherapyQueue.arrivaltime) {
	        	if ((this.arrivaltime - physiotherapyQueue.arrivaltime) < 0.0000000001) {
	        		if (this.player.id > physiotherapyQueue.player.id) {
		            	return 1;
		            }
		            
		            else if (this.player.id < physiotherapyQueue.player.id) {
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
	        
	        
	        else if (this.arrivaltime < physiotherapyQueue.arrivaltime) {
	        	if ((physiotherapyQueue.arrivaltime - this.arrivaltime) < 0.0000000001) {
	        		if (this.player.id > physiotherapyQueue.player.id) {
		            	return 1;
		            }
		            
		            else if (this.player.id < physiotherapyQueue.player.id) {
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
	            if (this.player.id > physiotherapyQueue.player.id) {
	            	return 1;
	            }
	            
	            else if (this.player.id < physiotherapyQueue.player.id) {
	            	return -1;
	            }
	            else {
	            	return 0;
	            }
	        }
		}
    }
}

