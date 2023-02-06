package binaryTree;

public class TreeSearchProgram {
    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.add(15);
        binarySearchTree.add(2);
        binarySearchTree.add(5);
        binarySearchTree.add(28);
        binarySearchTree.add(22);

        System.out.println(binarySearchTree.minLoop());
        System.out.println(binarySearchTree.maxLoop());

    }
}
