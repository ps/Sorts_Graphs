public class BST
{
	private Node root;

	public BST()
	{
		root=null;	
	}
	public void inorder()
	{
		if(root==null)
			System.out.println("No elements in tree!");
		else
		{
			inorderHelper(root);
			System.out.print("\n");
		}
	}
	private void inorderHelper(Node tree)
	{
		if(tree.left != null)
			inorderHelper(tree.left);

		System.out.print(tree.value + ", ");

		if(tree.right !=null)
			inorderHelper(tree.right);

	}

	//this BST implementation assumes no duplicate
	//numbers are to be inserted
	public void insert(int item)
	{
		Node temp = new Node(item);
		Node cur=root;
		Node prev=null;
		
		if(cur==null)
		{
			root=temp;
			return;
		}
		while(cur!=null)
		{
			prev = cur;
			if(cur.value>item)
			{
				cur = cur.left;
			}
			else if(cur.value<item)
			{
				cur = cur.right;
			}
		}

		//the tree is empty insert at root
		if(prev==null)
		{
			root = temp;
		}
		else
		{
			if(prev.left == null && prev.value>item)
			{
				prev.left=temp;
			}
			else if(prev.right==null && prev.value <item)
			{
				prev.right=temp;
			}
		}
	}
}
