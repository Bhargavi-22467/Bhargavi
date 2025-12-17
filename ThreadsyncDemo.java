class Table
{
	/*Table t;
	Table(Table t)
	{
		this.t = t;
	}*/
	synchronized void printTable(int n)
	{
		for(int i=0;i<=10;i++)
		{
			System.out.println(n + "*" + i + "=" + (n*i));
			try 
			{
				Thread.sleep(2000);
			}
			catch(Exception e){ }
		}
	}
}
class Thread1 extends Thread
{
	Table t;
	Thread1(Table t)
	{
		this.t = t;
	}
	public void run()
	{
		System.out.println();
		t.printTable(10);
	}
}
class Thread2 extends Thread
{
	Table t;
	Thread2(Table t)
	{
		this.t = t;
	}
	public void run()
	{
		System.out.println();
		t.printTable(50);
	}
}
class ThreadsyncDemo
{
	public static void main(String[] args)
	{
		Table t = new Table();
		Thread1 t1 = new Thread1(t);
		Thread2 t2 = new Thread2(t);
		t1.start();
		t2.start();
	}
}