package org.example.algorithm.tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {

    /**
     * binary tree layout
     *
     * 0
     * |  \
     * 1   2
     * | \ | \
     * 3 4 5 6
     *
     */
    @Test
    void test1() {
        BinaryNode node6 = new BinaryNode(6, null, null);
        BinaryNode node5 = new BinaryNode(5, null, null);
        BinaryNode node4 = new BinaryNode(4, null, null);
        BinaryNode node3 = new BinaryNode(3, null, null);
        BinaryNode node2 = new BinaryNode(2, node5, node6);
        BinaryNode node1 = new BinaryNode(1, node3, node4);
        BinaryNode node0 = new BinaryNode(0, node1, node2);

        assertEquals("[0, 1, 3, 4, 2, 5, 6]", BinaryTree.traversePreorderRecursively(node0).toString());
        assertEquals("[3, 1, 4, 0, 5, 2, 6]", BinaryTree.traverseInorderRecursively(node0).toString());
        assertEquals("[3, 4, 1, 5, 6, 2, 0]", BinaryTree.traversePostorderRecursively(node0).toString());
        assertEquals("[0, 1, 2, 3, 4, 5, 6]", BinaryTree.traverseBfs(node0).toString());
        assertEquals("[0, 1, 3, 4, 2, 5, 6]", BinaryTree.traversePreorderByLoop(node0).toString());
        assertEquals("[3, 1, 4, 0, 5, 2, 6]", BinaryTree.traverseInorderByLoop(node0).toString());
        assertEquals("[3, 4, 1, 5, 6, 2, 0]", BinaryTree.traversePostorderByLoop(node0).toString());
    }

    @Test
    void test2() {
        BinaryNode node7 = new BinaryNode(7, null, null);
        BinaryNode node6 = new BinaryNode(6, null, node7);
        BinaryNode node5 = new BinaryNode(5, null, null);
        BinaryNode node4 = new BinaryNode(4, null, null);
        BinaryNode node3 = new BinaryNode(3, null, null);
        BinaryNode node2 = new BinaryNode(2, node5, node6);
        BinaryNode node1 = new BinaryNode(1, node3, node4);
        BinaryNode node0 = new BinaryNode(0, node1, node2);

        assertEquals("[3, 1, 4, 0, 5, 2, 6, 7]", BinaryTree.traverseInorderRecursively(node0).toString());
        assertEquals("[0, 1, 2, 3, 4, 5, 6, 7]", BinaryTree.traverseBfs(node0).toString());
    }
}