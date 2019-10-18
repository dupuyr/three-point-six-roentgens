import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.ArrayList;

class LCAgraphTest {

	//Simple Graph test
	@SuppressWarnings("static-access")
	@Test
	void SGtest() {
	  List<V> t = new ArrayList<V>();
	  LCAgraph g = new LCAgraph();
	  V one = new V(1);
	  g.root = one;
	  V two = new V(2);
	  two.makeParent(one);
	  V three = new V(3);
	  three.makeParent(two);
	  V four = new V(4);
	  four.makeParent(three);
	  V five = new V(5);
	  five.makeParent(two);
	  t = g.LCA(three, four);
	  assertEquals(2, t.get(0).e);
	  
	  
	}
	
	@SuppressWarnings("static-access")
	@Test
	void DAGtest() 
	{
		 List<V> t = new ArrayList<V>();
		 LCAgraph g = new LCAgraph();
		  V A = new V(1);
		  g.root = A;
		  V B = new V(2);
		  B.makeParent(A);
		  V C = new V(3);
		  C.makeParent(B);
		  V D = new V(4);
		  D.makeParent(C);
		  V E = new V(5);
		  V F = new V(6);
		  E.makeParent(B);
		  F.makeParent(E);
		  V G = new V(7);
		  G.makeParent(D);
		  G.makeParent(F);
		  t = g.LCA(D, F);
		  assertEquals(2, t.get(0).e);
	}
	
	@SuppressWarnings("static-access")
	@Test
	void Gtest() 
	{
		 List<V> t = new ArrayList<V>();
		 LCAgraph g = new LCAgraph();
		  V one = new V(1);
		  g.root = one;
		  V two = new V(2);
		  two.makeParent(one);
		  V three = new V(3);
		  three.makeParent(two);
		  two.makeParent(three);
		  V four = new V(4);
		  four.makeParent(three);
		  t = g.LCA(three, four);
		  assertEquals(2, t.get(0).e);
	}
	
	@SuppressWarnings("static-access")
	@Test
	void Nulltest() 
	{
		 List<V> t = new ArrayList<V>();
		 LCAgraph g = new LCAgraph();
		  V one = new V(1);
		  g.root = one;
		  V two = new V(2);
		  two.makeParent(one);
		  V three = new V(3);
		  three.makeParent(two);
		  two.makeParent(three);
		  V four = new V(4);
		  four.makeParent(three);
		  t = g.LCA(null, null);
		  assertEquals(1, t.get(0).e);
	}
	
	@SuppressWarnings("static-access")
	@Test
	void yNulltest() 
	{
		 List<V> t = new ArrayList<V>();
		 LCAgraph g = new LCAgraph();
		  V one = new V(1);
		  g.root = one;
		  V two = new V(2);
		  two.makeParent(one);
		  V three = new V(3);
		  three.makeParent(two);
		  two.makeParent(three);
		  V four = new V(4);
		  four.makeParent(three);
		  t = g.LCA(two, null);
		  assertEquals(1, t.get(0).e);
	}
	
	
	@SuppressWarnings("static-access")
	@Test
	void twoOrphantest() 
	{
		 List<V> t = new ArrayList<V>();
		 LCAgraph g = new LCAgraph();
		  V one = new V(1);
		  g.root = one;
		  V two = new V(2);
		  V three = new V(3);
		  three.makeParent(one);
		  three.makeParent(two);
		  V four = new V(4);
		  four.makeParent(three);
		  t = g.LCA(three, four );
		  assertEquals(2, t.get(0).e);
	}
	
	@SuppressWarnings("static-access")
	@Test
	void ownParenttest() 
	{
		 List<V> t = new ArrayList<V>();
		 LCAgraph g = new LCAgraph();
		  V one = new V(1);
		  g.root = one;
		  V two = new V(2);
		  two.makeParent(one);
		  V three = new V(3);
		  three.makeParent(two);
		  three.makeParent(three);
		  V four = new V(4);
		  four.makeParent(three);
		  t = g.LCA(three, four);
		  assertEquals(2, t.get(0).e);
	}
	
	

}
