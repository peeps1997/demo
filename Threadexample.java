import java.util.LinkedList;
import java.util.HashMap;
public class Threadexample
{
    public static void main(String[] args)
                        throws InterruptedException
    {
        final PC pc = new PC();
        Thread t1 = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                try
                {
                    pc.produce();
                }
                catch(InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        });
 
        Thread t2 = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                try
                {
                    pc.consume();
                }
                catch(InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
    public static class PC
    {
        HashMap<String,Integer> list = new HashMap<String,Integer>();
        int capacity = 2;
        int value=1;
        int i=1;
        public void produce() throws InterruptedException
        {
            
            while (true)
            {
                synchronized (this)
                {   
                    while ((list.get("consumer")==null)&&(i==0))
                        wait();
 
                    System.out.println("Producer produced-"
                                                  + this.value);
 
                    list.put("producer",this.value++);
                    if(list.get("consumer")!=null){
                    int val = list.remove("consumer");
                    System.out.println("Producer consumed-"
                    + val);}
                    notify();
                    i=0;
                    Thread.sleep(1000);
                }
            }
        }
 
        public void consume() throws InterruptedException
        {
            while (true)
            {
                synchronized (this)
                {
                   try{ while (list.get("producer")==null)
                        wait();
                }catch(Exception e){System.out.println("Problems solved"+e);}
                    int val = list.remove("producer");
                    System.out.println("Consumer consumed-"+ val);
                    list.put("consumer",this.value++);
                    System.out.println("Consumer produced-"+ this.value);
                    notify();
                    Thread.sleep(1000);
                }
            }
        }
    }
}
