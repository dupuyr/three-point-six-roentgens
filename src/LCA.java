import java.io.*;
import java.util.*;
class Node
{

  int nodeNumber;
  List<Node> kids = new ArrayList<>();
  List<Node> parents = new ArrayList<>();
  static Node comp;

 public Node(int n)
 {
   nodeNumber = n;
 }

 public static void haveKids(Node p,Node k)
 {
   p.kids.add(k);
 }
 
 public static void parentN(Node p, Node k)
 {
	k.parents.add(p);
 }
}

public class LCA 
{
	  public static Node findLCA(Node r, Node x, Node y)
	  {
		if(x == null && y == null) return r;
	    if(x == r || y == r) return r;
	    int count = 0;
	    Node temp = null;
	    for(Node n : r.kids)
	    {
	      Node a = findLCA(n, x, y);
	      if(a != null)
	      {
	        count++;
	        Node.comp = a;
	        temp = a;
	      }
	    }

	    if(count >= 2) return r;
	    
	    if(Node.comp.equals(x) && x.parents.size() == 1) return x.parents.get(0);
	    //if(Node.comp.equals(y)) return y.parent;


	    return temp;
	  }

	  public static void main(String[] args)
	  {
	   }



}
