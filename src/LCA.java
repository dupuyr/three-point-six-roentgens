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
	    Node r = new Node(1);
	    Node n = new Node(2);
	    Node o = new Node(3);
	    Node p = new Node(4);
	    Node q = new Node(5);
	    Node s = new Node(6);
	    Node.haveKids(r,n);
	    Node.haveKids(r,o);
	    Node.haveKids(n,p);
	    Node.haveKids(n,q);
	    Node.haveKids(p,s);

	    System.out.print(findLCA(r,q,s).nodeNumber);
	 }



}
