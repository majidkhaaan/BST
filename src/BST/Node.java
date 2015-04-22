package BST;

public class Node<Item> {
	public Item data;
	public Node<Item> left;
	public Node<Item> right;
	public Node(Item d) {
		this.data=d;
		left=null;
		right=null;
	}
	public void display() {
		System.out.print(data+" ");
	}


}


