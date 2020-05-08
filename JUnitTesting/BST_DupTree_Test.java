import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections; //Added by  Aditya
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class BST_DupTree_Test {

	static DupTree dtr;
	static List<Integer> al = new ArrayList<Integer>();
	static Random r = new Random();

	@BeforeAll
	public static void setup() {
		dtr= new DupTree(r.nextInt(25));
		al.add(dtr.value);
        for(int i=0;i<=23;i++)
        {int y=r.nextInt(25);
        dtr.insert(y);
        al.add(y);}
        Collections.sort(al);
        TreeIterator dtiold=new TreeIterator(dtr);
        System.out.println("DupTree created in Setup:");
 		while(dtiold.hasNext())
 		{
 			Integer y=dtiold.next();
 			System.out.print(y);
 		    System.out.print(" ");
 		}
         System.out.println("");
         System.out.println("Sorted ArrayList created in Setup:");
         Iterator<Integer> dsiold= al.iterator();
         while(dsiold.hasNext())
 		{
 			Integer y=dsiold.next();
 			System.out.print(y);
 		    System.out.print(" ");
 		}
         System.out.println("");
         System.out.println("-------------------------");
        
	 	// code to be filled in by you
	}

	@AfterEach
	void check_invariant() {
		if(ordered(dtr))
			{System.out.println("DupTree invariant maintained");
			System.out.println("----------------------------");}
		else
		{System.out.println("DupTree invariant is not maintained");
		System.out.println("----------------------------");}
		// code to be filled in by you
	}
	
	@Test
	void test_insert() {
		System.out.println("Testing DupTree insert ...");
        System.out.println("Creating ArrayList iterator and Comparing elements pair-wise ...");
		TreeIterator dti=new TreeIterator(dtr);
		Iterator<Integer> dsi= al.iterator();
		while(dti.hasNext() && dsi.hasNext())
		{
			
			assertTrue(dti.next()==dsi.next());
		}
		System.out.println("... DupTree insert test passed");
		
		// code to be filled in by you 
	}
	
	@Test
	void test_delete() {
		System.out.println("Testing DupTree delete ...");
		System.out.print("inserted value = 6 ");
		int z=r.nextInt(6);
		dtr.insert(z);
		int count_before=get_count(dtr,z);
		System.out.println("with count = " + count_before);
		dtr.delete(z);
		int count_after=get_count(dtr,z);
		System.out.print("After DupTree delete:");
		System.out.print(" value = 6 ");
		System.out.println(", count = " + count_after);
		assertTrue( count_before>=1 &&
			count_after==count_before-1 );
		System.out.println("DupTree delete test passed");
		// code to be filled in by you
	}		

	public int get_count(DupTree dtr, int v) {
		if(dtr.find(v)!=null)
		{return dtr.find(v).get_count();}
		else
			return 0;
		
		// code to be filled in by you 
	}

	public boolean ordered(Tree tr) {
		return(
				tr.left==null 
				|| 
				(tr.value > tr.left.max().value && ordered(tr.left))
				&&
				tr.right==null 
				|| 
				(tr.value < tr.right.min().value && ordered(tr.right))
				);
		// code to be filled in by you
	}
}