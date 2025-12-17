class DaemonThread extends Thread {
    public void run() {
        while (true) {
            System.out.println("Daemon thread is running...");
            try {
                Thread.sleep(1000); // Sleep for 1 second
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}
class UserThread extends Thread {
public void run() {
        System.out.println("User thread is starting.");
        try {
            Thread.sleep(5000); 
        } catch (InterruptedException e) {
            System.out.println(e);
        }0
        System.out.println("User thread is finishing.");
    }
}
public class DaemonThreadDemo
{
	public static void main(String[] args) 
	{
        	DaemonThread daemonThread= new DaemonThread();
        	daemonThread.setDaemon(true); 
        	UserThread userThread= new UserThread();
        	daemonThread.start();
        	userThread.start();
        	try 
		{
        		userThread.join(); // Wait for the user thread to finish
		} 
		catch (InterruptedException e)
		{
            		System.out.println(e);
        	}
        	System.out.println("Main thread is finishing.");
	}
}