package binaryTree;

public class TreeNode {
    private final Integer data;
    private TreeNode leftNode;
    private TreeNode rightNode;
    private boolean isDeleted = false;

    public TreeNode(Integer data) {
        this.data = data;
    }

    public Integer minRecursion() {
        if (this.leftNode == null) {
            return this.data;
        }
        return this.leftNode.minRecursion();
    }

    public Integer maxRecursion() {
        if (this.rightNode == null) {
            return this.data;
        }
        return this.rightNode.maxRecursion();
    }

    public Integer minLoop() {
        TreeNode tmp = this.leftNode;
        while (tmp != null) {
            tmp = this.leftNode.getLeftNode();
            if (tmp == null) {
                return leftNode.getData();
            }
        }
        return null;
    }

    public Integer maxLoop() {
        TreeNode tmp = this.rightNode;
        while (tmp != null) {
            tmp = this.rightNode.getRightNode();
            if (tmp == null) {
                return rightNode.getData();
            }
        }
        return null;
    }

    /**
     * soft Deletion
     */
    public void delete() {
        this.isDeleted = true;
    }

    public TreeNode find(Integer data) {
        if (data.equals(this.data) && !isDeleted) {
            return this;
        }
        if (data < this.data && leftNode != null) {
            return leftNode.find(data);
        }
        if (rightNode != null) {
            return rightNode.find(data);
        }
        return null;
    }

    public void add(Integer data) {
        if (data >= this.data) {
            if (this.rightNode == null) {
                this.rightNode = new TreeNode(data);
            } else {
                this.rightNode.add(data);
            }
        } else {
            if (this.leftNode == null) {
                this.leftNode = new TreeNode(data);
            } else {
                this.leftNode.add(data);
            }
        }
    }

    public Integer getData() {
        return data;
    }

    public TreeNode getLeftNode() {
        return leftNode;
    }

    public TreeNode getRightNode() {
        return rightNode;
    }

    public void setLeftNode(TreeNode leftNode) {
        this.leftNode = leftNode;
    }

    public void setRightNode(TreeNode rightNode) {
        this.rightNode = rightNode;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "data=" + data +
                ", leftNode=" + leftNode +
                ", rightNode=" + rightNode +
                ", isDeleted=" + isDeleted +
                '}';
    }
}