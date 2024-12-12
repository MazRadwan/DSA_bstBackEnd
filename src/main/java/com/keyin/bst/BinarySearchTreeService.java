package com.keyin.bst;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.*;

@Service
public class BinarySearchTreeService {
    @Autowired
    private BinarySearchTreeRepository repository;
    private ObjectMapper objectMapper = new ObjectMapper();

    public BinarySearchTree createTree(List<Integer> numbers, boolean shouldBalance) throws Exception {
        Node root = null;
        for (int num : numbers) {
            root = insert(root, num);
        }

        // Balance the tree if requested
        if (shouldBalance) {
            root = balanceTree(root);
        }

        BinarySearchTree bst = new BinarySearchTree();
        bst.setInputNumbers(numbers.toString());
        bst.setTreeStructure(objectMapper.writeValueAsString(root));
        bst.setCreatedAt(java.time.LocalDateTime.now());

        return repository.save(bst);
    }

    private Node insert(Node root, int value) {
        if (root == null) {
            return new Node(value);
        }

        if (value < root.getValue()) {
            root.setLeft(insert(root.getLeft(), value));
        } else if (value > root.getValue()) {
            root.setRight(insert(root.getRight(), value));
        }

        return root;
    }

    public List<BinarySearchTree> getAllTrees() {
        return repository.findAll();
    }

    public Node balanceTree(Node root) {
        List<Integer> values = new ArrayList<>();
        inOrderTraversal(root, values);
        return buildBalancedBST(values, 0, values.size() - 1);
    }

    private void inOrderTraversal(Node root, List<Integer> values) {
        if (root == null) return;
        inOrderTraversal(root.getLeft(), values);
        values.add(root.getValue());
        inOrderTraversal(root.getRight(), values);
    }

    private Node buildBalancedBST(List<Integer> values, int start, int end) {
        if (start > end) return null;

        int mid = (start + end) / 2;
        Node root = new Node(values.get(mid));

        root.setLeft(buildBalancedBST(values, start, mid - 1));
        root.setRight(buildBalancedBST(values, mid + 1, end));

        return root;
    }
}