package com.epam.rd.autocode.bstprettyprint;

public class TreeNode {
    private int value;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(int value) {
        this.value = value;
    }

    public void insertValue(int value) {
        if (value >= this.value) {
            if (this.right == null) {
                this.right = new TreeNode(value);
            } else {
                this.right.insertValue(value);
            }
        } else {
            if (this.left == null) {
                this.left = new TreeNode(value);
            } else {
                this.left.insertValue(value);
            }
        }
    }

    public int getValue() {
        return value;
    }

    public TreeNode getLeft() {
        return left;
    }

    public TreeNode getRight() {
        return right;
    }
}