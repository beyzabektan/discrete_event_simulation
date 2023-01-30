
public class Training implements Comparable<Training>{
	Player  player;
	double endingtime;
	
	public Training(Player player, double endingtime) {
		this.player = player;
		this.endingtime = endingtime;
	}

	public int compareTo(Training training) {
        if (this.endingtime > training.endingtime) {
        	if ((this.endingtime - training.endingtime) < 0.0000000001) {
        		if (this.player.id > training.player.id) {
                 	return 1;
                 }
                 
                 else if (this.player.id < training.player.id) {
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
        
        else if (this.endingtime < training.endingtime) {
        	if ((training.endingtime - this.endingtime) < 0.0000000001){
        		if (this.player.id > training.player.id) {
                 	return 1;
                 }
                 
                 else if (this.player.id < training.player.id) {
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
        	 if (this.player.id > training.player.id) {
             	return 1;
             }
             
             else if (this.player.id < training.player.id) {
             	return -1;
             }
             else {
             	return 0;
             }
        }
    }

}
