package binaryTree;

public class BinarySearchTree {
    private TreeNode root;

    public TreeNode find(Integer data) {
        if (root != null) {
            return root.find(data);
        }
        return null;
    }

    public Integer min() {
        if (root != null) {
            return root.minRecursion();
        }
        return null;
    }

    public Integer minLoop() {
        return root.minLoop();
    }

    public Integer maxLoop() {
        return root.maxLoop();
    }

    public Integer max() {
        if (root != null) {
            return root.maxRecursion();
        }
        return null;
    }

    public void delete(Integer data) {
        TreeNode toDelete = find(data);
        toDelete.delete();
    }

    public void add(Integer data) {
        if (root == null) {
            this.root = new TreeNode(data);
        } else {
            root.add(data);
        }
    }

/*
    public void delete(Integer data) {

        TreeNode current = this.root;
        TreeNode parent = this.root;
        boolean isLeft = false;

        if (current == null) {
            return;
        }
        while (current != null && !current.getData().equals(data)) {
            parent = current;
            if (data < current.getData()) {
                current = current.getLeftNode();
                isLeft = true;
            } else {
                current = current.getRightNode();
                isLeft = false;
            }
        }
        if (current == null) {
            return;
        }
        if (current.getLeftNode() == null && current.getRightNode() == null) {
            if (current == root) {
                root = null;
            } else {
                if (isLeft) {
                    parent.setLeftNode(null);
                } else {
                    parent.setRightNode(null);
                }
            }
        }
        else if (current.getRightNode() == null){
            if (current == root){
                root = current.getLeftNode();
            }
            else if (isLeft){
                parent.setLeftNode(current.getLeftNode());
            }
            else {
                parent.setRightNode(current.getLeftNode());
            }
        }
        else if (current.getLeftNode() == null){
            if (current == root){
                root = current.getRightNode();
            }
            else if (isLeft){
                parent.setLeftNode(current.getRightNode());
            }
            else {
                parent.setRightNode(current.getLeftNode());
            }
        }
    }
*/

    @Override
    public String toString() {
        return "BinarySearchTree{" +
                "root=" + root +
                '}';
    }
}