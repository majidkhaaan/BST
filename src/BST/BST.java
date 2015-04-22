package BST;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;


public class BST< Item extends Comparable<Item> > {
	public Node<Item> bst_root;
	
	public BST() {
		bst_root=null;
	}
	
	public boolean search (Item d){
		return search(bst_root,d);	
	}
	public void insert(Item d) {		
		bst_root=insert(bst_root, d);
	}
	public void delete (Item d) {
		delete(bst_root, d);
	}
	public Item min(){
		return min(bst_root);
	}
	public void preOrder() {
		preOrder(bst_root);
	}


	public void display() {
		printTree(bst_root);
	}
	private static < Item extends Comparable<Item> >  boolean search(Node<Item> subTree, Item d) {
		if(subTree==null)
			return false;	
		int t=d.compareTo(subTree.data);
		if(t == 0)
			return true;		
		if(t < 0)
			return search(subTree.left,d);
		if(t > 0)
			return search(subTree.right,d);
		return false;
	}
	private static < Item extends Comparable<Item> > Node<Item> insert(Node<Item> subTree, Item d) {
		if(subTree==null) {
			subTree = new Node<Item>(d);
			//Node<Item> n= new Node<Item>(d);
			//return n;
		} else if (d.compareTo(subTree.data)<0 ) {
			subTree.left=insert(subTree.left,d);
		} else if (d.compareTo(subTree.data)>0 ) {
			subTree.right=insert(subTree.right,d);
		}	
		return subTree;
	}	
	private static < Item extends Comparable<Item> > Node<Item> delete (Node<Item> subTree, Item d) {
		if(d.compareTo(subTree.data)<0)
			delete(subTree.left,d);
		else if (d.compareTo(subTree.data)>0)
			delete(subTree.right,d);
		else {
		    // found it
			if(subTree.right==null) {
				subTree=subTree.left;
			} else {
				Item successor = min(subTree.right);
				subTree.data=successor;
				delete(subTree.right,successor);
			}
		}
		return subTree;
	}
	private static < Item extends Comparable<Item> > Item min(Node<Item> subTree) {
		if(subTree.left==null)
			return subTree.data;
		else return min(subTree.left);
	}
	private static < Item extends Comparable<Item> > void printTree(Node<Item> tmpRoot) {

        Queue<Node<Item>> currentLevel = new LinkedList<Node<Item>>();
        Queue<Node<Item>> nextLevel = new LinkedList<Node<Item>>();

        currentLevel.add(tmpRoot);

        while (!currentLevel.isEmpty()) {
            Iterator<Node<Item>> iter = currentLevel.iterator();
            while (iter.hasNext()) {
                Node<Item> currentNode = iter.next();
                if (currentNode.left != null) {
                    nextLevel.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    nextLevel.add(currentNode.right);
                }
                currentNode.display();
          
            }
            System.out.println();
            currentLevel = nextLevel;
            nextLevel = new LinkedList<Node<Item>>();
        }

    }
	private static < Item extends Comparable<Item> > void preOrder(Node<Item> subTree){
		if(subTree==null)
			return;
		subTree.display();
		preOrder(subTree.left);
		preOrder(subTree.right);
	}
	

}
