import java.util.ArrayList;

public class FasterFunctions {
	public static void main(String[] args) {
		float totalTime = 0;
		long startTime = System.currentTimeMillis();
		// Your Code Here
		ArrayList<Thread> threads = new ArrayList<Thread>();
		Thread t1 = new Thread(() -> {
			SlowFunctions.slowSortLargeArray();
		});
		Thread t2 = new Thread(() ->{
			SlowFunctions.ackermann(3, 14);
		});
		Thread t3 = new Thread(()-> {
			SlowFunctions.millionsOfSqrts();
		});
		threads.add(t1);
		threads.add(t2);
		threads.add(t3);
		for (Thread thread : threads) {
			thread.start();
		}
		float endTime = (float) ((double) System.currentTimeMillis() - (double) startTime) / 1000.0f;
		totalTime += endTime;
		System.out.println("Total Time: " + totalTime);
	}
}
