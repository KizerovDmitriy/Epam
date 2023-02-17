package com.epam.rd.autocode.bstprettyprint;


import java.util.LinkedHashSet;
import java.util.Set;


public class PrintableTreeImpl implements PrintableTree {

    private TreeNode root;
    Set<Integer> list = new LinkedHashSet<>();

    @Override
    public void add(int i) {
        list.add(i);
    }

    @Override
    public String prettyPrint() {
        insertData();
        return printPretty(this.root);
    }

    private String printPretty(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if (root != null) {
            String suffix = root.getLeft() != null && root.getRight() != null ? "┤" : root.getLeft() != null ? "┘" :
                    root.getRight() != null ? "┐" : "";
            printPretty(sb, root.getLeft(), " ".repeat(("" + root.getValue()).length()), false);
            sb.append(root.getValue()).append(suffix).append("\n");
            printPretty(sb, root.getRight(), " ".repeat(("" + root.getValue()).length()), true);
        }
        return sb.toString();
    }

    private void printPretty(StringBuilder sb, TreeNode node, String prefix, boolean rightChild) {
        if (node == null) {
            return;
        }
        String currPrefix = prefix + (rightChild ? "└" : "┌");

        String suffix = node.getLeft() != null && node.getRight() != null ? "┤" : node.getLeft() != null ? "┘" : node.getRight() != null ? "┐" : "";
        String indentRight = prefix + (!rightChild ? "│" + " ".repeat(("" + node.getValue()).length()) : " ".repeat(("" + node.getValue()).length() + 1));
        String indentLeft = prefix + (rightChild ? "│" + " ".repeat(("" + node.getValue()).length()) : " ".repeat(("" + node.getValue()).length() + 1));

        printPretty(sb, node.getLeft(), indentLeft, false);
        sb.append(currPrefix).append(node.getValue()).append(suffix).append("\n");
        printPretty(sb, node.getRight(), indentRight, true);
    }

    public void insertData() {
        for (Integer n : this.list) {
            if (root == null) {
                this.root = new TreeNode(n);
            } else {
                root.insertValue(n);
            }
        }
    }
}