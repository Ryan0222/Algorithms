/*900. Closest Binary Search Tree Value
Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.

Example
Example1

Input: root = {5,4,9,2,#,8,10} and target = 6.124780
Output: 5
Explanation：
Binary tree {5,4,9,2,#,8,10},  denote the following structure:
        5
       / \
     4    9
    /    / \
   2    8  10
Example2

Input: root = {3,2,4,1} and target = 4.142857
Output: 4
Explanation：
Binary tree {3,2,4,1},  denote the following structure:
     3
    / \
  2    4
 /
1
Notice
Given target value is a floating point.
You are guaranteed to have only one unique value in the BST that is closest to the target.
*/

/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

 /* 1.The first solution is to use the lowerBound and upperBound, what these two functions do is to find the 
 target's position in the left subtree nad the right subtree. we want to find the largest node that smaller than target and the smallest node 
 that larger than target. If we find the two node, we compare it with the target to find the closest node. 

 The trick thing that I will solve is that in the lowerBound and upperBound when to use target <= or < .

 Time Complexity : O(h) h is the Tree's height. Binary Search Tree don't guarantee that height is O(logn). */


public class Solution {
    /**
     * @param root: the given BST
     * @param target: the given target
     * @return: the value in the BST that is closest to the target
     */
    public int closestValue(TreeNode root, double target) {
        // write your code here
        if (root == null) return 0;
        
        TreeNode lowerNode = lowerBound(root, target);
        TreeNode upperNode = upperBound(root, target);
        
        if (lowerNode == null) return upperNode.val;
        if (upperNode == null) return lowerNode.val;
        
        if (target - lowerNode.val > upperNode.val - target) {
            return upperNode.val;
        } else {
            return lowerNode.val;
        }
        
    }
    
    public TreeNode lowerBound(TreeNode root, double target) {
        if (root == null) return root;
        
        if (target <= root.val) {
            return lowerBound(root.left, target);
        }
        
        TreeNode lowerNode = lowerBound(root.right, target);
        if (lowerNode != null) return lowerNode;
        return root;
    }
    
    public TreeNode upperBound(TreeNode root, double target) {
        if (root == null) return root;
        
        if (target > root.val) {
            return upperBound(root.right, target);
        }
        
        TreeNode upperNode = upperBound(root.left, target);
        if (upperNode != null) return upperNode;
        return root;
    }
}