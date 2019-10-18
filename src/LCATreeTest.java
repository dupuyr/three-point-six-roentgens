import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LCATreeTest {

	// LCA of two nodes in a n-ary tree
	@Test
	void naryTreeTest() 
	{
		LCA t = new LCA();
		Node r = new Node(1);
	    Node two = new Node(2);
	    Node three = new Node(3);
	    Node four = new Node(4);
	    Node five = new Node(5);
	    Node six = new Node(6);
	    Node.haveKids(r,two);
	    Node.haveKids(r,three);
	    Node.haveKids(two,four);
	    Node.haveKids(two,five);
	    Node.haveKids(two,six);
	    
	    Node a = t.findLCA(r, four, five);
	    assertEquals(two.nodeNumber, a.nodeNumber);
	}
	
	
}
