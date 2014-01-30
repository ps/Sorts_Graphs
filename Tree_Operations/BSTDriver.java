public class BSTDriver
{
	public static void main(String [] args)
	{
		BST myTree = new BST();
		myTree.insert(5);
		myTree.insert(9);
		myTree.insert(4);
		myTree.insert(3);
		myTree.insert(2);
		myTree.insert(6);
		myTree.inorder();
	}
}
