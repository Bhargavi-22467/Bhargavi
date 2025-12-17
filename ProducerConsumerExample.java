import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
class Producer implements Runnable 
{
	private final BlockingQueue<Integer> queue;
	private final int limit;
	public Producer(BlockingQueue<Integer> queue, int limit)
	{
		this.queue = queue;
		this.limit = limit;
	}
    	public void run() 
	{
		int item = 0;
		try 
		{
			while (item < limit) 
			{
				System.out.println("Producer produced: " + item);
				queue.put(item); 
				item++;
				Thread.sleep(500); 
			}
			System.out.println("Producer has finished producing.");
		} 
		catch (InterruptedException e) 
		{
			Thread.currentThread().interrupt();
			System.out.println("Producer interrupted");
		}
        }
 }
class Consumer implements Runnable {
    private final BlockingQueue<Integer> queue;
    private final int limit;
    public Consumer(BlockingQueue<Integer> queue, int limit) {
        this.queue = queue;
        this.limit = limit;
    }
    public void run() {
        int itemCount = 0;
        try {
            while (itemCount < limit) {
                int item = queue.take(); 
                System.out.println("Consumer consumed: " + item);
                itemCount++;
                Thread.sleep(700); 
            }
            System.out.println("Consumer has finished consuming.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Consumer interrupted");
        }
    }
}
public class ProducerConsumerExample{
    public static void main(String[] args) {
        int limit = 10; 
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);
        Thread producerThread = new Thread(new Producer(queue, limit));
        Thread consumerThread = new Thread(new Consumer(queue, limit));
        producerThread.start();
        consumerThread.start();
        try {
            producerThread.join();
            consumerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Production and consumption have completed.");
    }
}