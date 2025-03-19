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
}

