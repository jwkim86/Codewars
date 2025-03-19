package org.example.algorithm.tree;

import java.util.*;
import java.util.stream.Collectors;

public class BinaryTree {

    public static Stack<Integer> traverseDfsRecursively(BinaryNode node, Stack<Integer> result) {
        if(result == null) result = new Stack<>();
        if (node == null) return result;
        traverseDfsRecursively(node.left(), result);
        result.push(node.value());
        traverseDfsRecursively(node.right(), result);
        return result;
    }

    public static List<Integer> traverseBfs(BinaryNode root) {
        BinaryNode node = root;
        ArrayList<BinaryNode> result = new ArrayList<>();
        result.add(root);
        for(int i=0; i<result.size(); i++) {
            node = result.get(i);
            if(node.left() != null) result.add(node.left());
            if(node.right() != null) result.add(node.right());
        }
        return result.stream().map(BinaryNode::value).collect(Collectors.toList());
    }
}

