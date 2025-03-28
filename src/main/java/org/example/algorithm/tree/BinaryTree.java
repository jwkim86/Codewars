package org.example.algorithm.tree;

import java.util.*;
import java.util.stream.Collectors;

public class BinaryTree {

    // DFS(Depth First Search)
    public static Stack<Integer> traversePreorderRecursively(BinaryNode node) {
        Stack<Integer> result = new Stack<>();
        traversePreorderRecursivelySub(node, result);
        return result;
    }

    private static void traversePreorderRecursivelySub(BinaryNode node, Stack<Integer> result) {
        if (node == null) return;
        result.push(node.value());
        traversePreorderRecursivelySub(node.left(), result);
        traversePreorderRecursivelySub(node.right(), result);
    }

    // DFS 2
    public static Stack<Integer> traverseInorderRecursively(BinaryNode node) {
        Stack<Integer> result = new Stack<>();
        traverseInorderRecursivelySub(node, result);
        return result;
    }

    private static void traverseInorderRecursivelySub(BinaryNode node, Stack<Integer> result) {
        if (node == null) return;
        traverseInorderRecursivelySub(node.left(), result);
        result.push(node.value());
        traverseInorderRecursivelySub(node.right(), result);
    }

    // DFS 3
    public static Stack<Integer> traversePostorderRecursively(BinaryNode node) {
        Stack<Integer> result = new Stack<>();
        traversePostorderRecursivelySub(node, result);
        return result;
    }

    public static void traversePostorderRecursivelySub(BinaryNode node, Stack<Integer> result) {
        if (node == null) return;
        traversePostorderRecursivelySub(node.left(), result);
        traversePostorderRecursivelySub(node.right(), result);
        result.push(node.value());
    }

    // BFS can't implement by recursion
    public static List<Integer> traverseBfs(BinaryNode root) {
        ArrayList<BinaryNode> result = new ArrayList<>();
        result.add(root);
        BinaryNode node;
        for(int i=0; i<result.size(); i++) {
            node = result.get(i);
            if(node.left() != null) result.add(node.left());
            if(node.right() != null) result.add(node.right());
        }
        return result.stream().map(BinaryNode::value).collect(Collectors.toList());
    }

    public static Stack<Integer> traversePreorderByLoop(BinaryNode root) {
        Stack<Integer> result = new Stack<>();
        Stack<BinaryNode> stack = new Stack<>();
        BinaryNode current = root;
        while(current != null || !stack.isEmpty()) {
            if(current == null) {
                BinaryNode n = stack.pop();
                current = n.right();
            } else {
                stack.push(current);
                result.push(current.value());
                current = current.left();
            }
        }
        return result;
    }

    public static Stack<Integer> traverseInorderByLoop(BinaryNode root) {
        Stack<Integer> result = new Stack<>();
        Stack<BinaryNode> stack = new Stack<>();
        BinaryNode current = root;
        while(current != null || !stack.isEmpty()) {
            if(current == null) {
                BinaryNode n = stack.pop();
                result.push(n.value());
                current = n.right();
            } else {
                stack.push(current);
                current = current.left();
            }
        }
        return result;
    }

    // ref. https://www.geeksforgeeks.org/iterative-postorder-traversal/
    public static Stack<Integer> traversePostorderByLoop(BinaryNode root) {
        Stack<Integer> result = new Stack<>();
        Stack<BinaryNode> stack1 = new Stack<>();
        stack1.push(root);
        while(!stack1.isEmpty()) {
            BinaryNode n = stack1.pop();
            result.push(n.value());
            if(n.left()!=null) stack1.push(n.left());
            if(n.right()!=null) stack1.push(n.right());
        }
        Collections.reverse(result);
        return result;
    }

    public static String[] getAllCombinations(BinaryNode root) {
        Stack<Integer> current = new Stack<>();
        List<String> results = new ArrayList<>();
        getAllCombinationsSub(root, current, results);
        return results.toArray(new String[]{});
    }

    private static void getAllCombinationsSub(BinaryNode node, Stack<Integer> current, List<String> results) {
        if (node == null) return;
        current.push(node.value());
        getAllCombinationsSub(node.left(), current, results);
        getAllCombinationsSub(node.right(), current, results);
        if (node.left() == null && node.right() == null) {
            results.add(current.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining()));
        }
        current.pop();
    }
}

