package Kumar_sir.genric_bst;
import com.sun.source.tree.Tree;

class TreeNode<T extends Comparable<T>>{
    T key;
    TreeNode<T> left,right;

    TreeNode(T item){
        key = item;
        left = right = null;
    }
}

class BST<T extends Comparable<T>>{
    private TreeNode<T> root;

    // insert a new Key
    public void insert(T key){
        root = insertRec(root,key);
    }
    private TreeNode<T> insertRec(TreeNode<T>root,T key){
        if(root == null){
            root = new TreeNode<>(key);
            return root;
        }
        if(key.compareTo(root.key) < 0){
            root.left = insertRec(root.left,key);
        }
        else if(key.compareTo(root.key) > 0){
            root.right = insertRec(root.right, key);
        }
        return root;
    }

    // search for a key
    public boolean search(T key){
        return searchRec(root,key);
    }
    private boolean searchRec(TreeNode<T> root,T key){
        if(root == null) return false;

        if(root.key.equals(key)){
            return true;
        }
        return key.compareTo(root.key) < 0 ? searchRec(root.left,key) : searchRec(root.right,key);
    }

    // delete a Key
    public void delete(T key){
        root = deleteRec(root,key);
    }
    private TreeNode<T> deleteRec(TreeNode<T> root, T key){
        if(root == null) return root;

        if(key.compareTo(root.key) < 0){
            root.left = deleteRec(root.left, key);
        }
        else if(key.compareTo(root.key) > 0){
            root.right = deleteRec(root.right,key);
        }
        else {
            // node with one child or no child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            // node with two children get inorder successor from the right tree
            root.key = minValue(root.right);
            // delete the inorder successor
            root.right = deleteRec(root.right, root.key);
        }
        return root;
    }
    private T minValue(TreeNode<T> root){
        T minValue = root.key;
        while (root.left != null){
            minValue = root.left.key;
            root = root.left;
        }
        return minValue;
    }
    public void inorder(){
        inorderRec(root);
        System.out.println();
    }
    private void inorderRec(TreeNode<T> root){
        if(root == null) return ;
        inorderRec(root.left);
        System.out.print(root.key + " ");
        inorderRec(root.right);
    }
}
public class Main {
    public static void main(String[] args) {
      BST<String>bst = new BST<>();
      bst.insert("jitendra");
      bst.insert("jitendr");
      bst.inorder();
      boolean ans = bst.search("jitendre");
        System.out.println(ans);
    }
}
