import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

public class LCAgraph {

	static ArrayList<Node> nodes=new ArrayList<Node>();
	private static Queue<Node> queue = new LinkedList<Node>();
	static ArrayList<List<Node>> neighbourLists = new ArrayList<List<Node>>();

	class Node
	{

	  int nodeNumber;
	  int depth;
      int chainCount;
	  boolean visited;
	  List<Node> kids = new ArrayList<>();
	  List<Node> neighbours;

	 public Node(int n, int d)
	 {
	   depth = d;
	   nodeNumber = n;
     chainCount = 0;
	   this.neighbours=new ArrayList<>();
	 }

		public void addneighbours(Node neighbourNode)
		{
			this.neighbours.add(neighbourNode);
		}

		public List<Node> getNeighbours() {
			return neighbours;
		}
	}


	public static List<Node> bfs(Node node)
	{
    List<Node> t = new ArrayList<Node>();
		queue.add(node);
    //System.out.println(node.nodeNumber);
		node.visited=true;
    t.add(node);
		while (!queue.isEmpty())
		{

			Node element=queue.remove();
			//System.out.print(element.nodeNumber + "t");
			List<Node> neighbours=element.getNeighbours();
			for (int i = 0; i < neighbours.size(); i++) {
				Node n=neighbours.get(i);
        //System.out.println(neighbours.get(i).nodeNumber);
				if(n!=null && !n.visited)
				{
          //System.out.println(n.nodeNumber);
					queue.add(n);
					n.visited=true;
          t.add(n);


				}
			}

		}
	      return t;

	}


	public static boolean check(List<Node> l, Node x, Node y)
	{
    int count = 0;
    for(int i = 0; i< l.size(); i++)
		{
      //System.out.println("Nodes: " + l.get(i).nodeNumber);
			if(l.get(i).equals(x)) count++;
			else if(l.get(i).equals(y)) count++;
    //  System.out.println(count);
			if(count == 2)
      {
        //System.out.println(l.get(0).nodeNumber);
        return true;
    	}
    }
		 return false;
	}

	public static boolean checkDepth(Node n, int largestDepth)
	{
		if(n.depth > largestDepth) return true;
		return false;
	}


	public static List<Node> LCA(Node x, Node y)
	{
		List<Node> t = new ArrayList<Node>();
		List<Node> lca = new ArrayList<Node>();
    int d = 0;
		for(int i = 0; i<nodes.size(); i++)
		{
			if(nodes.get(i).neighbours.size() > 0)
			{
        //System.out.println("Nodes tried: " + nodes.get(i).nodeNumber);
				 t = bfs(nodes.get(i));
         System.out.println(t.get(0).nodeNumber);
				 if(check(t, x, y))
				 {
          //System.out.println(t.get(0).nodeNumber);
					if(checkDepth(t.get(0), d))
					{
						d = t.get(0).depth;
					}
				 }
			}

		}

		 for(int i = 0; i<nodes.size(); i++)
		 {
			 if(nodes.get(i).depth == d) lca.add(nodes.get(i));
       //System.out.println(d);
		 }

		 printLca(lca);

	      return lca;
	}

	static void printLca(List<Node> lca)
	{
		for(int i = 0; i<lca.size(); i++)
		{
			//System.out.println(lca.get(i).nodeNumber);
		}
	}


	public static void main(String[] args)
	{
		LCAgraph g = new LCAgraph();
		Node one = g.new Node(1, 0);
    nodes.add(one);
		Node two = g.new Node(2, 1);
    nodes.add(two);
		Node three = g.new Node(3, 2);
    nodes.add(three);
		Node four = g.new Node(4, 3);
    nodes.add(four);
		Node five = g.new Node(5, 2);
    nodes.add(five);
		one.addneighbours(two);
		two.addneighbours(three);
		two.addneighbours(five);
		three.addneighbours(four);
		LCA(three, four);



	}

}