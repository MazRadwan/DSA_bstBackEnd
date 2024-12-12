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

    public BinarySearchTree createTree(List<Integer> numbers) throws Exception {
        // Sort numbers first
        Collections.sort(numbers);


        Node root = buildBalancedBST(numbers, 0, numbers.size() - 1);

        BinarySearchTree bst = new BinarySearchTree();
        bst.setInputNumbers(numbers.toString());
        bst.setTreeStructure(objectMapper.writeValueAsString(root));
        bst.setCreatedAt(java.time.LocalDateTime.now());

        return repository.save(bst);
    }

    public List<BinarySearchTree> getAllTrees() {
        return repository.findAll();
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