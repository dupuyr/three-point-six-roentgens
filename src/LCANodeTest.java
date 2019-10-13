import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LCANodeTest {

	    // LCA if one node is null
		@Test
		void oneNullNodetest() 
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
		    Node.haveKids(four,six);
		    
		    Node ancestor = t.findLCA(r,null,four);
		    assertEquals(four.nodeNumber,ancestor.nodeNumber);
		    
		    
		}
		
		// LCA if both nodes are null
		@Test
		void bothNullNodesTest()
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
		    Node.haveKids(four,six);
		    
		    Node a = t.findLCA(r,null,null);
		    assertEquals(null, a.nodeNumber);
		    
		    
		}
		
		// LCA if both Nodes are the same Node
		@Test
		void bothTheSameNodeTest()
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
		    Node.haveKids(four,six);
		    
		    Node a = t.findLCA(r, four, four);
		    assertEquals(four.nodeNumber, a.nodeNumber);
		}
		
		@Test
		void oneNodeIsRootNodeTest()
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
		    Node.haveKids(four,six);
		    
		    Node a = t.findLCA(r, r, four);
		    assertEquals(r.nodeNumber,a.nodeNumber);
		
		}
		

}
