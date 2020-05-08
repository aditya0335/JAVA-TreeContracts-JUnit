import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;
import java.util.Iterator;
import java.util.Random;
import java.util.TreeSet;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class BST_Tree_Test {

	static Tree tr;
	static TreeSet<Integer> ts = new TreeSet<Integer>();
	static Random r = new Random();
	
	

	@BeforeAll
	public static void setup() {
       
		tr= new Tree(r.nextInt(25));
        
        ts.add(tr.value);
        for(int i=0;i<=23;i++)
        {int y=r.nextInt(25);
        tr.insert(y);
        ts.add(y);}
        
		TreeIterator t1old=new TreeIterator(tr);
        System.out.println("Tree created in Setup: ");
		while(t1old.hasNext())
		{
			Integer y=t1old.next();
			System.out.print(y);
		    System.out.print(" ");
		}
        System.out.println("");
        System.out.println("TreeSet created in Setup:");
        Iterator<Integer> siold= ts.iterator();
        while(siold.hasNext())
		{
			Integer y=siold.next();
			System.out.print(y);
		    System.out.print(" ");
		}
        System.out.println("");
        System.out.println("-------------------------");
// code to be filled in by you
	}		 

	@AfterEach
	void check_invariant() {
//		assertTrue(ordered(tr));
		if(ordered(tr))
		{System.out.println("Tree invariant maintained");}
		else
		{System.out.println("Tree invariant is not maintained");
		}
		// code to be filled in by you 
	}
		
	@Test
	void test_insert() {
        System.out.println("Testing Tree insert ...");
        System.out.println("Creating TreeSet iterator and Comparing elements pair-wise ...");
		TreeIterator ti=new TreeIterator(tr);
		Iterator<Integer> si= ts.iterator();
		Integer treeItrVal,tsItrVal;
		while(ti.hasNext() && si.hasNext())
		{
			treeItrVal = ti.next();
			tsItrVal = si.next();
			assertTrue(treeItrVal.equals(tsItrVal));
				
		}
        System.out.println("... Tree insert test passed");
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
	}

}