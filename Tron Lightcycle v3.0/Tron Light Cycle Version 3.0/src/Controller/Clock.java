package Controller;

public class Clock {
	
	private long startTime , endTime, passedTime;
	
	public Clock() {
		startTime = 0;
		endTime = 0;
		passedTime = 0;
	}
	
	public void start() {
		
		startTime = System.nanoTime();
	}
	
	public void stop() {
		endTime = System.nanoTime();
		passedTime = endTime - startTime;
		startTime = 0; 
	}
	
	public long getTime() {
		return passedTime;
	}

}
