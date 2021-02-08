class Balance{
    public static void main(String args[]){ 
        Node root = new Node(12); 
        root.left = new Node(14); 
        root.right = new Node(16); 
        root.right.left = new Node(50); 
        root.right.right = new Node(150); 
        root.right.left.left = new Node(40); 
        System.out.println(isBalanced(root) ?  "Balanced" : "Not Balanced");
    }  
    static class Node{ 
    int key; 
    Node left, right; 
        Node(int key){ 
            left = null; 
            right = null; 
            this.key = key; 
        } 
    } 
    static class INT{ 
    static int d; 
        INT(){ 
            d = 0; 
        } 
    }
    static boolean isBalanced(Node root){ 
        INT maxh=new INT(), minh=new INT(); 
        return isBalancedUtil(root, maxh, minh); 
    }  
    
    static boolean isBalancedUtil(Node root, INT maxh, INT minh){ 
        if (root == null){ 
            maxh.d = minh.d = 0; 
            return true; 
        } 
        // To store max and min heights of left subtree
        INT lmxh=new INT(), lmnh=new INT();  
      // To store max and min heights of right subtree 
        INT rmxh=new INT(), rmnh=new INT();  
        // Check if left subtree is balanced,  
        // also set lmxh and lmnh
        if (isBalancedUtil(root.left, lmxh, lmnh) == false) 
            return false; 
        // Check if right subtree is balanced, 
        // also set rmxh and rmnh
        if (isBalancedUtil(root.right, rmxh, rmnh) == false) 
            return false; 
        // Set the max and min heights  
         // of this node for the parent call 
        maxh.d = Math.max(lmxh.d, rmxh.d) + 1; 
        minh.d = Math.min(lmnh.d, rmnh.d) + 1; 
         //  if this node is balanced
        if (maxh.d <= 2 * minh.d) 
            return true; 
  
        return false; 
    }  
} 