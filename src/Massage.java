
public class Massage implements Comparable<Massage>{
	Player  player;
	double endingtime;
	
	public Massage(Player player, double endingtime) {
		this.player = player;
		this.endingtime = endingtime;
	}

	public int compareTo(Massage massage) {
        if (this.endingtime > massage.endingtime) {
        	if ((this.endingtime - massage.endingtime) < 0.0000000001) {
        		if (this.player.id > massage.player.id) {
                 	return 1;
                 }
                 
                 else if (this.player.id < massage.player.id) {
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
        else if (this.endingtime < massage.endingtime) {
        	if ((massage.endingtime - this.endingtime) < 0.0000000001) {
        		if (this.player.id > massage.player.id) {
                 	return 1;
                 }
                 
                 else if (this.player.id < massage.player.id) {
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
        	 if (this.player.id > massage.player.id) {
             	return 1;
             }
             
             else if (this.player.id < massage.player.id) {
             	return -1;
             }
             else {
             	return 0;
             }
        }
    }

}
