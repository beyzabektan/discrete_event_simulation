import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Locale;
import java.util.PriorityQueue;
import java.util.Scanner;

public class project2main {
	public static void main(String[] args) throws FileNotFoundException {
		
		Locale.setDefault(new Locale("en", "US"));
        Scanner input = new Scanner(new File(args[0])).useLocale(Locale.US);;
        PrintStream output = new PrintStream(args[1]);
        
        ArrayList<Player> players = new ArrayList<Player>();
        PriorityQueue<TrainingArrival> trainingArrivals = new PriorityQueue<TrainingArrival>();
        PriorityQueue<MassageArrival> massageArrivals = new PriorityQueue<MassageArrival>();
        PriorityQueue<TrainingQueue> trainingQueue = new PriorityQueue<TrainingQueue>();
        PriorityQueue<MassageQueue> massageQueue = new PriorityQueue<MassageQueue>();
        PriorityQueue<PhysiotherapyQueue> physiotherapyQueue = new PriorityQueue<PhysiotherapyQueue>();
        PriorityQueue<Training> trainingsInProcess = new PriorityQueue<Training>();
        PriorityQueue<Massage> massagesInProcess = new PriorityQueue<Massage>();
        PriorityQueue<Physiotherapy> physiotherapiesInProcess = new PriorityQueue<Physiotherapy>();
        PriorityQueue<Physiotherapist> availablePhysiotherapists = new PriorityQueue<Physiotherapist>();
        PriorityQueue<Event> allEvents = new PriorityQueue<Event>();
        PriorityQueue<WaitingTimePQ> waitingTimeInPQ = new PriorityQueue<WaitingTimePQ>();
        PriorityQueue<WaitingTimeMQ> waitingTimeInMQ = new PriorityQueue<WaitingTimeMQ>();
        int numberOfInvalidAttempts = 0;
        int numberOfCanceledTrainingAttempts = 0;
        int numberOfCanceledMassageAttempts = 0;
        
        
        
        double globalTime = 0;
        
        int N = input.nextInt();
        
        for (int i = 0; i < N; i ++) {
        	players.add(new Player(input.nextInt(),input.nextInt(), 0, 0, 0, 0, 0 ,0));
        }
        
        int A = input.nextInt();
        
        for (int i = 0; i < A; i ++) {
        	String type = input.next();
        	if (type.equals("t")) {
        		int id = input.nextInt();
        		double arrivaltime = input.nextDouble();
        		double duration = input.nextDouble();
        		trainingArrivals.add(new TrainingArrival(players.get(id), arrivaltime, duration));
        	}
        	
        	if (type.equals("m")) {	
        		int id = input.nextInt();
        		double arrivaltime = input.nextDouble();
        		double duration = input.nextDouble();
        		massageArrivals.add(new MassageArrival(players.get(id), arrivaltime, duration));
        	}
        }
        
        int numberOfPhysiotherapists = input.nextInt();
        for (int i = 0; i < numberOfPhysiotherapists; i ++) {
        	availablePhysiotherapists.add(new Physiotherapist(i, input.nextDouble()));
        }
        
        int numberOfCoaches = input.nextInt();
        int numberOfMasseurs = input.nextInt();
        int numberOfAvailableCoaches = numberOfCoaches;
        int numberOfAvailableMasseurs = numberOfMasseurs;
        int numberOfAvailablePhysiotherapists = numberOfPhysiotherapists;
        int numberOfTrainingArrivals = trainingArrivals.size();
        int numberOfMassageArrivals = massageArrivals.size();
        double totalTurnaroundTime = 0;
        double totalTrainingTime = 0;
        double totalMassageTime = 0;
        double totalPhysiotherapyTime = 0;
        double totalTrainingWaitingTime = 0;
        double totalMassageWaitingTime = 0;
        double totalPhysiotherapyWaitingTime = 0;
        int maxLengthTrainingQueue = 0;
        int maxLengthMassageQueue = 0;
        int maxLengthPhysiotherapyQueue = 0;
       
       
        // loop until there is no event left
        while(!trainingArrivals.isEmpty() || !massageArrivals.isEmpty() || !trainingQueue.isEmpty() || !massageQueue.isEmpty() || !physiotherapyQueue.isEmpty() || !trainingsInProcess.isEmpty() || !massagesInProcess.isEmpty() || !physiotherapiesInProcess.isEmpty()) {

        	
        	
        if (!trainingArrivals.isEmpty()) {
        	TrainingArrival peekTrainingArrival = trainingArrivals.peek();
        	allEvents.add(new Event("trainingArrival", peekTrainingArrival.arrivaltime, peekTrainingArrival.player.id));
        }
        
        if (!massageArrivals.isEmpty()) {
        	MassageArrival peekMassageArrival = massageArrivals.peek();

        	allEvents.add(new Event("massageArrival", peekMassageArrival.arrivaltime, peekMassageArrival.player.id));
        
        }
        
        if (!trainingsInProcess.isEmpty()) {
        	
        	Training peekTrainingInProcess = trainingsInProcess.peek();

        	allEvents.add(new Event("trainingInProcess", peekTrainingInProcess.endingtime, peekTrainingInProcess.player.id));
        }
        
        if (!massagesInProcess.isEmpty()) {
        	Massage peekMassageInProcess = massagesInProcess.peek();
        	allEvents.add(new Event("massageInProcess", peekMassageInProcess.endingtime, peekMassageInProcess.player.id));
        }
        
        if (!physiotherapiesInProcess.isEmpty()) {
        	Physiotherapy peekPhysiotherapyInProcess = physiotherapiesInProcess.peek();
        	allEvents.add(new Event("physiotherapyInProcess", peekPhysiotherapyInProcess.endingtime, peekPhysiotherapyInProcess.player.id));
        }

        // time increases when a player's training attempt
        if (allEvents.peek().name.equals("trainingArrival")) {
        	
        	TrainingArrival currentTrainingArrival = trainingArrivals.poll();
        	globalTime = currentTrainingArrival.arrivaltime;
        	
        	
        	if (currentTrainingArrival.player.playeractivity != 0) {
        		numberOfCanceledTrainingAttempts += 1;
        	}
        	
        	else {
        		currentTrainingArrival.player.turnaroundstartingtime = globalTime;
	        	currentTrainingArrival.player.playeractivity = 1;
	        	currentTrainingArrival.player.durationoftraining = currentTrainingArrival.duration;
	        	totalTrainingTime += currentTrainingArrival.duration; 
	        	
	        			
	        	if (numberOfAvailableCoaches > 0) {
	        		
	        		trainingsInProcess.add(new Training(currentTrainingArrival.player, globalTime + (currentTrainingArrival.duration)));
	        		numberOfAvailableCoaches -= 1;
	        	}
	        	
	        	else {
	        		trainingQueue.add(new TrainingQueue(currentTrainingArrival.player, currentTrainingArrival.arrivaltime, currentTrainingArrival.duration));
	        		if (trainingQueue.size() > maxLengthTrainingQueue) {
	        			maxLengthTrainingQueue = trainingQueue.size();
	        		}
	        	}
	        	
        	}
        	
        	while (!allEvents.isEmpty()) {
        		allEvents.poll();
        	}
        	continue;
        	
        }
        
        // time increases when a player's massage attempt
        if (allEvents.peek().name.equals("massageArrival")) {
        	MassageArrival currentMassageArrival = massageArrivals.poll();
        	globalTime = currentMassageArrival.arrivaltime;
        	
        	if (currentMassageArrival.player.numberofmassages < 3) {
        		
        	
        	
	        	if (currentMassageArrival.player.playeractivity != 0) {
	        		numberOfCanceledMassageAttempts += 1;
	        	}
	        	
	        	else {
	        		currentMassageArrival.player.numberofmassages += 1;
	        		currentMassageArrival.player.playeractivity = 1;
	        		totalMassageTime += currentMassageArrival.duration; 
	        	
	        		if (numberOfAvailableMasseurs > 0) {
	        			
		        		massagesInProcess.add(new Massage(currentMassageArrival.player, globalTime + (currentMassageArrival.duration)));
		        		
		        		numberOfAvailableMasseurs -=1;
		        	}
		        	
		        	else {
		        		massageQueue.add(new MassageQueue(currentMassageArrival.player, currentMassageArrival.arrivaltime, currentMassageArrival.duration));
		        		if (massageQueue.size() > maxLengthMassageQueue) {
		        			maxLengthMassageQueue = massageQueue.size();
		        		}
		        	}
	        	
	        	}
	        	
	        	
	        	
        	}
        	
        	else {
        		numberOfInvalidAttempts += 1;
        	}
        	
        	while (!allEvents.isEmpty()) {
        		allEvents.poll();
        	}
        	continue;
        }
        
        // time increases when a player ends his training
        if (allEvents.peek().name.equals("trainingInProcess")) {
        	Training currentTrainingInProcess = trainingsInProcess.poll();
        	
        	globalTime = currentTrainingInProcess.endingtime;
        	numberOfAvailableCoaches += 1;
        	
        	if (numberOfAvailablePhysiotherapists > 0) {
        		Physiotherapist peekAvailablePhysiotherapist = availablePhysiotherapists.poll();
        		physiotherapiesInProcess.add(new Physiotherapy(currentTrainingInProcess.player, (globalTime + peekAvailablePhysiotherapist.servicetime), peekAvailablePhysiotherapist));
        		numberOfAvailablePhysiotherapists -= 1;
        		totalPhysiotherapyTime += peekAvailablePhysiotherapist.servicetime;
        		
        	}
        	
        	else {
        		
        		physiotherapyQueue.add(new PhysiotherapyQueue(currentTrainingInProcess.player, globalTime));
        		if (physiotherapyQueue.size() > maxLengthPhysiotherapyQueue) {
        			maxLengthPhysiotherapyQueue = physiotherapyQueue.size();
        			
        		}
        		
        	}
        	
        	if (!trainingQueue.isEmpty()) {
        		TrainingQueue nextTrainingInProcess = trainingQueue.poll();
        		trainingsInProcess.add(new Training(nextTrainingInProcess.player, (globalTime + nextTrainingInProcess.duration)));
        		numberOfAvailableCoaches -= 1;
        		totalTrainingWaitingTime += (globalTime - nextTrainingInProcess.arrivaltime);
        	}
        	while (!allEvents.isEmpty()) {
        		allEvents.poll();
        	}
        	continue;
        }
        
        // time increases when a player ends his massage
        if (allEvents.peek().name.equals("massageInProcess")) {
        	
        	Massage currentMassageInProcess = massagesInProcess.poll();
        	globalTime = currentMassageInProcess.endingtime;
        	numberOfAvailableMasseurs += 1;
        
        	currentMassageInProcess.player.playeractivity = 0;
        	
        	if (!massageQueue.isEmpty()) {
        		MassageQueue nextMassageInProcess = massageQueue.poll();
        		massagesInProcess.add(new Massage(nextMassageInProcess.player, (globalTime + nextMassageInProcess.duration)));
        		numberOfAvailableMasseurs -= 1;
        		totalMassageWaitingTime += (globalTime - nextMassageInProcess.arrivaltime);
        		nextMassageInProcess.player.waitingTimeMQ += (globalTime - nextMassageInProcess.arrivaltime);
        	}
        	while (!allEvents.isEmpty()) {
        		allEvents.poll();
        	}
        	continue;
        }
        
        
        // time increases when a player ends his physiotherapy
        if (allEvents.peek().name.equals("physiotherapyInProcess")) {

        	Physiotherapy currentPhysiotherapyInProcess = physiotherapiesInProcess.poll();
        	globalTime = currentPhysiotherapyInProcess.endingtime;
        	availablePhysiotherapists.add(currentPhysiotherapyInProcess.physiotherapist);
        	numberOfAvailablePhysiotherapists += 1 ;
        	
        	
        	
        	totalTurnaroundTime += (globalTime - currentPhysiotherapyInProcess.player.turnaroundstartingtime);
        	currentPhysiotherapyInProcess.player.playeractivity = 0;
        	
        	if (!physiotherapyQueue.isEmpty()) {
        		
        		PhysiotherapyQueue nextPhysiotherapyInProcess = physiotherapyQueue.poll();
        		nextPhysiotherapyInProcess.player.durationoftraining = 0;
        		Physiotherapist peekAvailablePhysiotherapist = availablePhysiotherapists.poll();
        		physiotherapiesInProcess.add(new Physiotherapy(nextPhysiotherapyInProcess.player, (globalTime + peekAvailablePhysiotherapist.servicetime), peekAvailablePhysiotherapist));
        		numberOfAvailablePhysiotherapists -= 1;
        		totalPhysiotherapyTime += peekAvailablePhysiotherapist.servicetime;
        		totalPhysiotherapyWaitingTime += (globalTime - nextPhysiotherapyInProcess.arrivaltime);
        		
        		nextPhysiotherapyInProcess.player.waitingTimePQ += (globalTime - nextPhysiotherapyInProcess.arrivaltime);
        		
        	}
        	while (!allEvents.isEmpty()) {
        		allEvents.poll();
        	}
        	continue;
        	
        }
        
        }
        
        for (int i = 0; i < players.size() ; i ++) {
        	waitingTimeInPQ.add(new WaitingTimePQ(players.get(i), players.get(i).waitingTimePQ));
        	if (players.get(i).numberofmassages == 3) {
        		waitingTimeInMQ.add(new WaitingTimeMQ(players.get(i), players.get(i).waitingTimeMQ));
        	}
        }
        
        DecimalFormat decimalFormat = new DecimalFormat("#0.000", DecimalFormatSymbols.getInstance(Locale.US));
        
        output.println(maxLengthTrainingQueue);
        output.println(maxLengthPhysiotherapyQueue);
        output.println(maxLengthMassageQueue);
        output.println(decimalFormat.format(totalTrainingWaitingTime / (numberOfTrainingArrivals - numberOfCanceledTrainingAttempts)));
        output.println(decimalFormat.format(totalPhysiotherapyWaitingTime / (numberOfTrainingArrivals - numberOfCanceledTrainingAttempts)));
        output.println(decimalFormat.format(totalMassageWaitingTime / (numberOfMassageArrivals - numberOfCanceledMassageAttempts - numberOfInvalidAttempts)));
        output.println(decimalFormat.format(totalTrainingTime / (numberOfTrainingArrivals - numberOfCanceledTrainingAttempts)));
        output.println(decimalFormat.format(totalPhysiotherapyTime / (numberOfTrainingArrivals - numberOfCanceledTrainingAttempts)));
        output.println(decimalFormat.format(totalMassageTime / (numberOfMassageArrivals - numberOfCanceledMassageAttempts - numberOfInvalidAttempts)));
        output.println(decimalFormat.format(totalTurnaroundTime / (numberOfTrainingArrivals - numberOfCanceledTrainingAttempts)));
        output.println(waitingTimeInPQ.peek().player.id + " " + decimalFormat.format(waitingTimeInPQ.peek().player.waitingTimePQ)); 
        if (waitingTimeInMQ.isEmpty()) {
        	output.println( -1 + " " + -1 );
        }
        else {
        	output.println(waitingTimeInMQ.peek().player.id + " " + decimalFormat.format(waitingTimeInMQ.peek().player.waitingTimeMQ));
        }
        output.println(numberOfInvalidAttempts);
        output.println((numberOfCanceledTrainingAttempts + numberOfCanceledMassageAttempts));
        output.println(decimalFormat.format(globalTime));
        
   

        
	}
}
