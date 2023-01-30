
public class Physiotherapist implements Comparable<Physiotherapist>{
	int id;
	double servicetime;
	
	public Physiotherapist(int id, double servicetime) {
		this.id = id;
		this.servicetime = servicetime;
	}
	
	public int compareTo(Physiotherapist physiotherapist) {
        if (this.id > physiotherapist.id) {
            return 1;
        } 
        else if (this.id < physiotherapist.id) {
            return -1;
        } 
        else {
            return 0;
        }
    }

}
