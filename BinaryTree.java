package DataStructure2;

public class BinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		// Binary Tree Node
		class TreeNode {
		    int data;
		    TreeNode left, right;

		    public TreeNode(int item) {
		        data = item;
		        left = right = null;
		    }
		}

		// Binary Tree class
		class BinaryTree {
		    TreeNode root;

		    BinaryTree() {
		        root = null;
		    }

		    // Insert a new data value into the binary tree
		    void insert(int data) {
		        root = insertRec(root, data);
		    }

		    // A recursive function to insert a new data value into the binary tree
		    TreeNode insertRec(TreeNode root, int data) {
		        // Base case: if the tree is empty, return a new node
		        if (root == null) {
		            root = new TreeNode(data);
		            return root;
		        }

		        // Otherwise, recur down the tree
		        if (data < root.data)
		            root.left = insertRec(root.left, data);
		        else if (data > root.data)
		            root.right = insertRec(root.right, data);

		        // Return the (unchanged) root node pointer
		        return root;
		    }

		    // Delete a data value from the binary tree
		    void delete(int data) {
		        root = deleteRec(root, data);
		    }

		    // A recursive function to delete a data value from the binary tree
		    TreeNode deleteRec(TreeNode root, int data) {
		        // Base case: if the tree is empty
		        if (root == null) return root;

		        // Otherwise, recur down the tree
		        if (data < root.data)
		            root.left = deleteRec(root.left, data);
		        else if (data > root.data)
		            root.right = deleteRec(root.right, data);
		        else {
		            // Node with only one child or no child
		            if (root.left == null)
		                return root.right;
		            else if (root.right == null)
		                return root.left;

		            // Node with two children: Get the inorder successor (smallest in the right subtree)
		            root.data = minValue(root.right);

		            // Delete the inorder successor
		            root.right = deleteRec(root.right, root.data);
		        }

		        return root;
		    }

		    int minValue(TreeNode root) {
		        int minValue = root.data;
		        while (root.left != null) {
		            minValue = root.left.data;
		            root = root.left;
		        }
		        return minValue;
		    }

		    // Pre-order traversal (root, left, right)
		    void preOrder() {
		        preOrderRec(root);
		        System.out.println();
		    }

		    void preOrderRec(TreeNode root) {
		        if (root != null) {
		            System.out.print(root.data + " ");
		            preOrderRec(root.left);
		            preOrderRec(root.right);
		        }
		    }

		    // In-order traversal (left, root, right)
		    void inOrder() {
		        inOrderRec(root);
		        System.out.println();
		    }

		    void inOrderRec(TreeNode root) {
		        if (root != null) {
		            inOrderRec(root.left);
		            System.out.print(root.data + " ");
		            inOrderRec(root.right);
		        }
		    }

		    // Post-order traversal (left, right, root)
		    void postOrder() {
		        postOrderRec(root);
		        System.out.println();
		    }

		    void postOrderRec(TreeNode root) {
		        if (root != null) {
		            postOrderRec(root.left);
		            postOrderRec(root.right);
		            System.out.print(root.data + " ");
		        }
		    }

		    // Driver code
		    public static void main(String[] args) {
		        BinaryTree tree = new BinaryTree();

		        // Insert nodes
		        tree.insert(15);
		        tree.insert(10);
		        tree.insert(25);
		        tree.insert(6);
		        tree.insert(12);
		        tree.insert(20);
		        tree.insert(30);

		        // Print traversals
		        System.out.print("Pre-order traversal: ");
		        tree.preOrder();

		        System.out.print("In-order traversal: ");
		        tree.inOrder();

		        System.out.print("Post-order traversal: ");
		        tree.postOrder();

		        // Delete a node
		        System.out.println("Delete 10");
		        tree.delete(10);
		        System.out.print("In-order traversal after deletion: ");
		        tree.inOrder();

		        System.out.println("Delete 25");
		        tree.delete(25);
		        System.out.print("In-order traversal after deletion: ");
		        tree.inOrder();

		        System.out.println("Delete 15");
		        tree.delete(15);
		        System.out.print("In-order traversal after deletion: ");
		        tree.inOrder();
		    }
		}


	}

}
