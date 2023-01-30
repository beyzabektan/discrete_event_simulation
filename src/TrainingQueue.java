
public class TrainingQueue implements Comparable<TrainingQueue>{
	Player player;
	double arrivaltime;
	double duration;
	
	public TrainingQueue(Player player, double arrivaltime, double duration) {
		this.player = player;
		this.arrivaltime = arrivaltime;
		this.duration = duration;
	}
	
	public int compareTo(TrainingQueue trainingqueue) {
        if (this.arrivaltime > trainingqueue.arrivaltime) {
        	if ((this.arrivaltime - trainingqueue.arrivaltime) < 0.0000000001) {
        		if (this.player.id > trainingqueue.player.id) {
                	return 1;
                }
                
                else if (this.player.id < trainingqueue.player.id) {
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
        
        else if (this.arrivaltime < trainingqueue.arrivaltime) {
        	if ((trainingqueue.arrivaltime - this.arrivaltime) < 0.0000000001) {
        		if (this.player.id > trainingqueue.player.id) {
                	return 1;
                }
                
                else if (this.player.id < trainingqueue.player.id) {
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
            if (this.player.id > trainingqueue.player.id) {
            	return 1;
            }
            
            else if (this.player.id < trainingqueue.player.id) {
            	return -1;
            }
            else {
            	return 0;
            }
        }
        
    }
}
