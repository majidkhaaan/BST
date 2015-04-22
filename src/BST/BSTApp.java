package BST;

import java.util.ArrayList;
import java.util.LinkedList;

public class BSTApp {

	public static ArrayList<LinkedList<Node<Integer>>> findLevelLinkedList (BST<Integer> bst) {
		LinkedList<Node<Integer>> current = new LinkedList<Node<Integer>>();
		LinkedList<Node<Integer>> next = new LinkedList<Node<Integer>>();
		ArrayList<LinkedList<Node<Integer>>> result = new ArrayList<LinkedList<Node<Integer>>>();
		Node<Integer> node = bst.bst_root;
		current.add(node);
		while(!current.isEmpty()) {
			for(Node<Integer> n : current){
				if(n.left!=null)
					next.add(n.left);
				if(n.right!=null)
					next.add(n.right);
				//n.display();
			}
			result.add(current);
			current=next;
			next=new LinkedList<Node<Integer>>();
		}
		
		return result;
	}
	public static void main(String[] args) {
		BST<Integer> bst=new BST<Integer>();
		
		bst.insert(7);
//		bst.preOrder();
		bst.insert(3);
//		bst.preOrder();
		bst.insert(11);
		bst.insert(1);
		bst.insert(5);
		bst.insert(9);
		bst.insert(13);
		bst.display();

		ArrayList<LinkedList<Node<Integer>>> tmp;
		tmp=findLevelLinkedList(bst);
		for(LinkedList<Node<Integer>> list: tmp) {
			for(Node<Integer> n: list)
				n.display();
			System.out.println();
			}
				
	}

}
