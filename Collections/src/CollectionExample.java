
public class CollectionExample {
	String a;
	double digit;
    CollectionExample aob;
	 public CollectionExample(String a){
	    this.a =a;
	 }
	  public static void main(String args[]){
		  
	    CollectionExample a=new CollectionExample("a");
	    CollectionExample b=new CollectionExample("b");
	    CollectionExample c=new CollectionExample("c");
	    a.aob=b;
	    b.aob=a;
	    c.aob=a.aob;
	    CollectionExample d=new CollectionExample("d").aob=new CollectionExample("e");
	    c=b;
	    c.aob=null;

	    
	    System.gc();
	  }
	     
   @Override
   protected void finalize() throws Throwable 
   
   { 
	   // Get current size of heap in bytes
	    

		    System.out.println("Garbage collector called");
		    System.out.println("Object garbage collected : " + this.a );
       
   } 
}

