import java.util.LinkedList;

public class BST {
    private No root;

    public void put(Integer key) {
        root = put(root, key);
    }

    private No put(No node, Integer key) {
        if (node == null) {
            return new No(key);
        }

        if (key < node.key) {
            node.left = put(node.left, key);
        } else if (key > node.key) {
            node.right = put(node.right, key);
        }

        return node;
    }

    public LinkedList<Integer> preorder() {
        return preorder(root);
    }

    private LinkedList<Integer> preorder(No node) {
        LinkedList<Integer> result = new LinkedList<>();
        if (node != null) {
            result.add(node.key);
            result.addAll(preorder(node.left));
            result.addAll(preorder(node.right));
        }
        return result;
    }

    public LinkedList<Integer> inorder() {
        return inorder(root);
    }

    private LinkedList<Integer> inorder(No node) {
        LinkedList<Integer> result = new LinkedList<>();
        if (node != null) {
            result.addAll(inorder(node.left));
            result.add(node.key);
            result.addAll(inorder(node.right));
        }
        return result;
    }

    public LinkedList<Integer> postorder() {
        return postorder(root);
    }

    private LinkedList<Integer> postorder(No node) {
        LinkedList<Integer> result = new LinkedList<>();
        if (node != null) {
            result.addAll(postorder(node.left));
            result.addAll(postorder(node.right));
            result.add(node.key);
        }
        return result;
    }
}
