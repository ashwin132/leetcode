class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return root;

        if (root.val == p.val || root.val == q.val) {
            return root;
        }
        
        if (root.left != null && root.right != null) {
            if ((root.left.val == p.val || root.left.val == q.val)
                    && (root.right.val == p.val || root.right.val == q.val)) {
                return root;
            }
            if (root.left.val == p.val) {
                if (q.val > root.val) return root;
                return root.left;
            }
            if (root.left.val == q.val) {
                if (p.val > root.val) return root;
                return root.left;
            }
            if (root.right.val == p.val) {
                if (q.val < root.val) return root;
                return root.right;
            }
            if (root.right.val == q.val) {
                if (p.val < root.val) return root;
                return root.right;
            }
        }
        
        if (root.left != null) {
            if (root.left.val == p.val || root.left.val == q.val) {
                return root.left;
            }
        }
        
        if (root.right != null) {
            if (root.right.val == p.val || root.right.val == q.val) {
                return root.right;
            }
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }
        return (left != null) ? left : right;
    }
}