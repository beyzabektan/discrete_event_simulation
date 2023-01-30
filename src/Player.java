
public class Player implements Comparable<Player>{
	int id;
	int skilllevel;
	int playeractivity;
	int numberofmassages;
	double durationoftraining;
	double turnaroundstartingtime;
	double waitingTimePQ;
	double waitingTimeMQ;

	public Player(int id, int skilllevel, int playeractivity, int numberofmassages, double durationoftraining, double turnaroundstartingtime, double waitingTimePQ, double waitingTimeMQ){
		this.id = id;
		this.skilllevel = skilllevel;
		this.playeractivity = playeractivity;
		this.numberofmassages = numberofmassages;
		this.durationoftraining = durationoftraining;
		this.turnaroundstartingtime = turnaroundstartingtime;
		this.waitingTimePQ = waitingTimePQ;
		this.waitingTimeMQ = waitingTimeMQ;
	}
	
	public int compareTo(Player player) {
        if (this.id > player.id) {
            return 1;
        } 
        else if (this.id < player.id) {
            return -1;
        } 
        else {
            return 0;
        }
    }
	
}
