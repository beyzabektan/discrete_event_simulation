
public class Physiotherapy implements Comparable<Physiotherapy>{
	Player  player;
	double endingtime;
	Physiotherapist physiotherapist;
	
	public Physiotherapy(Player player, double endingtime, Physiotherapist physiotherapist) {
		this.player = player;
		this.endingtime = endingtime;
		this.physiotherapist = physiotherapist;
	}

	public int compareTo(Physiotherapy physiotherapy) {
        if (this.endingtime > physiotherapy.endingtime) {
        	if ((this.endingtime - physiotherapy.endingtime) < 0.0000000001) {
        		if (this.player.id > physiotherapy.player.id) {
                 	return 1;
                 }
                 
                 else if (this.player.id < physiotherapy.player.id) {
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
        else if (this.endingtime < physiotherapy.endingtime) {
        	if ((physiotherapy.endingtime - this.endingtime) < 0.0000000001) {
        		if (this.player.id > physiotherapy.player.id) {
                 	return 1;
                 }
                 
                 else if (this.player.id < physiotherapy.player.id) {
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
        	 if (this.player.id > physiotherapy.player.id) {
             	return 1;
             }
             
             else if (this.player.id < physiotherapy.player.id) {
             	return -1;
             }
             else {
             	return 0;
             }
        }
    }

}
