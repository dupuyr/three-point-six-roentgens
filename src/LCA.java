import java.io.*;
import java.util.*;
class Node
{

  int nodeNumber;
  Node parent;
  List<Node> kids = new ArrayList<>();

 public Node(int n)
 {
   nodeNumber = n;
 }

 public static void haveKids(Node p,Node k)
 {
   p.kids.add(k);
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
	        temp = a;
	      }
	    }

	    if(count == 2) return r;

	    return temp;
	  }

	  public static void main(String[] args)
	  {
	   }



}
