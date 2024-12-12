package com.keyin.bst;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@CrossOrigin
public class BinarySearchTreeController {

    @Autowired
    private BinarySearchTreeService service;

    @PostMapping("/process-numbers")
    public ResponseEntity<?> processNumbers(@RequestBody Map<String, List<Integer>> request) {
        try {
            BinarySearchTree result = service.createTree(request.get("numbers"));
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/previous-trees")
    public ResponseEntity<List<BinarySearchTree>> getPreviousTrees() {
        return ResponseEntity.ok(service.getAllTrees());
    }
}