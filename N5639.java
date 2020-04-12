import java.io.*;
import java.util.*;


public class N5639 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		BST bst = new BST();
		
		int s;
		while(sc.hasNextInt()) {
			s = sc.nextInt();
			bst.insertBST(s);
		} bst.printBST();
	}

}

class Tree {
	int data;
	Tree left;
	Tree right;
	
	public Tree() {
		this.left = null;
		this.right = null;
	}
	
	public Tree(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
	
	public int getData() {
		return data;
	}
}

class BST {
	private Tree root = new Tree();
	
	public Tree insertKey(Tree root, int x) {
		Tree p = root;
		Tree newNode = new Tree(x);
		
		if(p==null) {
			return newNode;
		} else if(p.data>newNode.data) {
			p.left = insertKey(p.left, x);
			return p;
		} else if(p.data<newNode.data) {
			p.right = insertKey(p.right, x);
			return p;
		} else {return p;}
	}
	
	public void insertBST(int x) {
		root = insertKey(root, x);
	}
	
	public Tree searchBST(int x) {
		Tree p = root;
		while(p!=null) {
			if(x<p.data) {p=p.left;}
			else if(x>p.data) {p=p.right;}
			else {return p;}
		}
		return p;
	}
	
	public void inorder(Tree root) {
		if(root!=null) {
			inorder(root.left);
			inorder(root.right);
			if(root.data!=0) {
				System.out.println(root.data+" ");
			}			
		}
	}
	
	public void printBST() {
		inorder(root);
		System.out.println();
	}
}