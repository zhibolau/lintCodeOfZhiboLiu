// Java program to connect nodes at same level using extended
// pre-order traversal

// A binary tree node
class Node {

	int data;
	Node left, right, nextRight;

	Node(int item) {
		data = item;
		left = right = nextRight = null;
	}
}

class BinaryTree {

	static Node root;

	// Sets the nextRight of root and calls connectRecur() for other nodes
	void connect(Node p) {

		// Set the nextRight for root
		p.nextRight = null;

		// Set the next right for rest of the nodes (other than root)
		connectRecur(p);
	}

	/* Set next right of all descendents of p.
	Assumption: p is a compete binary tree */
	void connectRecur(Node p) {

		// Base case
		if (p == null) {
			return;
		}

		// Set the nextRight pointer for p's left child
		if (p.left != null) {
			p.left.nextRight = p.right;
		}

		// Set the nextRight pointer for p's right child
		// p->nextRight will be NULL if p is the right most child at its level
		if (p.right != null) {
			p.right.nextRight = (p.nextRight != null) ? p.nextRight.left : null;
		}

		// Set nextRight for other nodes in pre order fashion
		connectRecur(p.left);
		connectRecur(p.right);
	}

	public static void main(String args[]) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(10);
		tree.root.left = new Node(8);
		tree.root.right = new Node(2);
		tree.root.left.left = new Node(3);

		// Populates nextRight pointer in all nodes
		tree.connect(root);

		// Let us check the values of nextRight pointers
		System.out.println("Following are populated nextRight pointers in the tree "
				+ "(-1 is printed if there is no nextRight)");
		int a = root.nextRight != null ? root.nextRight.data : -1;
		System.out.println("nextRight of " + root.data + " is "
				+ a);
		int b = root.left.nextRight != null ? root.left.nextRight.data : -1;
		System.out.println("nextRight of " + root.left.data + " is "
				+ b);
		int c=root.right.nextRight != null ? root.right.nextRight.data : -1;
		System.out.println("nextRight of " + root.right.data + " is "
				+ c);
		int d = root.left.left.nextRight != null ? root.left.left.nextRight.data : -1;
		System.out.println("nextRight of " + root.left.left.data + " is "
				+ d);

	}
}

// This code has been contributed by Mayank Jaiswal



recursive

// Recursive Java program to connect nodes at same level
// using constant extra space

// A binary tree node
class Node {

	int data;
	Node left, right, nextRight;

	Node(int item) {
		data = item;
		left = right = nextRight = null;
	}
}

class BinaryTree {

	static Node root;

	/* Set next right of all descendents of p. This function makes sure that
	nextRight of nodes ar level i is set before level i+1 nodes. */
	void connectRecur(Node p) {

		// Base case
		if (p == null) {
			return;
		}

		/* Before setting nextRight of left and right children, set nextRight
		of children of other nodes at same level (because we can access 
		children of other nodes using p's nextRight only) */
		if (p.nextRight != null) {
			connectRecur(p.nextRight);
		}

		/* Set the nextRight pointer for p's left child */
		if (p.left != null) {
			if (p.right != null) {
				p.left.nextRight = p.right;
				p.right.nextRight = getNextRight(p);
			} else {
				p.left.nextRight = getNextRight(p);
			}

			/* Recursively call for next level nodes. Note that we call only
			for left child. The call for left child will call for right child */
			connectRecur(p.left);
		}
		
		/* If left child is NULL then first node of next level will either be
		p->right or getNextRight(p) */
		else if (p.right != null) {
			p.right.nextRight = getNextRight(p);
			connectRecur(p.right);
		} else {
			connectRecur(getNextRight(p));
		}
	}

	/* This function returns the leftmost child of nodes at the same level as p.
	This function is used to getNExt right of p's right child
	If right child of p is NULL then this can also be used for the left child */
	Node getNextRight(Node p) {
		Node temp = p.nextRight;

		/* Traverse nodes at p's level and find and return
		the first node's first child */
		while (temp != null) {
			if (temp.left != null) {
				return temp.left;
			}
			if (temp.right != null) {
				return temp.right;
			}
			temp = temp.nextRight;
		}

		// If all the nodes at p's level are leaf nodes then return NULL
		return null;
	}

	public static void main(String args[]) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(10);
		tree.root.left = new Node(8);
		tree.root.right = new Node(2);
		tree.root.left.left = new Node(3);
		tree.root.right.right = new Node(90);

		// Populates nextRight pointer in all nodes
		tree.connectRecur(root);

		// Let us check the values of nextRight pointers
		int a = root.nextRight != null ? root.nextRight.data : -1;
		int b = root.left.nextRight != null ? root.left.nextRight.data : -1;
		int c = root.right.nextRight != null ? root.right.nextRight.data : -1;
		int d = root.left.left.nextRight != null ? root.left.left.nextRight.data : -1;
		int e = root.right.right.nextRight != null ? root.right.right.nextRight.data : -1;
		
		// Now lets print the values
		System.out.println("Following are populated nextRight pointers in "
				+ " the tree(-1 is printed if there is no nextRight)");
		System.out.println("nextRight of " + root.data + " is " + a);
		System.out.println("nextRight of " + root.left.data + " is " + b);
		System.out.println("nextRight of " + root.right.data + " is " + c);
		System.out.println("nextRight of " + root.left.left.data + " is " + d);
		System.out.println("nextRight of " + root.right.right.data + " is " + e);
	}
}

O（1） space！！！！！

// Iterative Java program to connect nodes at same level
// using constant extra space

// A binary tree node
class Node {

	int data;
	Node left, right, nextRight;

	Node(int item) {
		data = item;
		left = right = nextRight = null;
	}
}

class BinaryTree {

	static Node root;

	/* This function returns the leftmost child of nodes at the same level as p.
	This function is used to getNExt right of p's right child
	If right child of is NULL then this can also be sued for the left child */
	Node getNextRight(Node p) {
		Node temp = p.nextRight;

		/* Traverse nodes at p's level and find and return
		the first node's first child */
		while (temp != null) {
			if (temp.left != null) {
				return temp.left;
			}
			if (temp.right != null) {
				return temp.right;
			}
			temp = temp.nextRight;
		}

		// If all the nodes at p's level are leaf nodes then return NULL
		return null;
	}

	/* Sets nextRight of all nodes of a tree with root as p */
	void connect(Node p) {
		Node temp = null;

		if (p == null) {
			return;
		}

		// Set nextRight for root
		p.nextRight = null;

		// set nextRight of all levels one by one
		while (p != null) {
			Node q = p;

			/* Connect all childrem nodes of p and children nodes of all other nodes
			at same level as p */
			while (q != null) {
				
				// Set the nextRight pointer for p's left child
				if (q.left != null) {
				
					// If q has right child, then right child is nextRight of
					// p and we also need to set nextRight of right child
					if (q.right != null) {
						q.left.nextRight = q.right;
					} else {
						q.left.nextRight = getNextRight(q);
					}
				}

				if (q.right != null) {
					q.right.nextRight = getNextRight(q);
				}

				// Set nextRight for other nodes in pre order fashion
				q = q.nextRight;
			}

			// start from the first node of next level
			if (p.left != null) {
				p = p.left;
			} else if (p.right != null) {
				p = p.right;
			} else {
				p = getNextRight(p);
			}
		}
	}

	public static void main(String args[]) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(10);
		tree.root.left = new Node(8);
		tree.root.right = new Node(2);
		tree.root.left.left = new Node(3);
		tree.root.right.right = new Node(90);

		// Populates nextRight pointer in all nodes
		tree.connect(root);
		
		// Let us check the values of nextRight pointers
		int a = root.nextRight != null ? root.nextRight.data : -1;
		int b = root.left.nextRight != null ? root.left.nextRight.data : -1;
		int c = root.right.nextRight != null ? root.right.nextRight.data : -1;
		int d = root.left.left.nextRight != null ? root.left.left.nextRight.data : -1;
		int e = root.right.right.nextRight != null ? root.right.right.nextRight.data : -1;
		
		// Now lets print the values
		System.out.println("Following are populated nextRight pointers in "
				+ " the tree(-1 is printed if there is no nextRight)");
		System.out.println("nextRight of " + root.data + " is " + a);
		System.out.println("nextRight of " + root.left.data + " is " + b);
		System.out.println("nextRight of " + root.right.data + " is " + c);
		System.out.println("nextRight of " + root.left.left.data + " is " + d);
		System.out.println("nextRight of " + root.right.right.data + " is " + e);
	}
}


