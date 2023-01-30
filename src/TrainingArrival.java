
public class TrainingArrival implements Comparable<TrainingArrival>{
	Player player;
	double arrivaltime;
	double duration;
	
	public TrainingArrival(Player player, double arrivaltime, double duration) {
		this.player = player;
		this.arrivaltime = arrivaltime;
		this.duration = duration;
	}
	
	public int compareTo(TrainingArrival trainingarrival) {
        if (this.arrivaltime > trainingarrival.arrivaltime) {
        	if ((this.arrivaltime - trainingarrival.arrivaltime) < 0.0000000001) {
        		if (this.player.id > trainingarrival.player.id) {
                	return 1;
                }
                
                else if (this.player.id < trainingarrival.player.id) {
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
        else if (this.arrivaltime < trainingarrival.arrivaltime) {
        	if ((trainingarrival.arrivaltime - this.arrivaltime) < 0.0000000001) {
        		if (this.player.id > trainingarrival.player.id) {
                	return 1;
                }
                
                else if (this.player.id < trainingarrival.player.id) {
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
            if (this.player.id > trainingarrival.player.id) {
            	return 1;
            }
            
            else if (this.player.id < trainingarrival.player.id) {
            	return -1;
            }
            else {
            	return 0;
            }
        }
        
    }
}
