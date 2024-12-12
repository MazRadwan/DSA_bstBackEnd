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
    public ResponseEntity<?> processNumbers(
            @RequestBody Map<String, List<Integer>> request,
            @RequestParam(defaultValue = "true") boolean balanced) { // i was going to make it so you could toggle between balanced and unbalanced trees but it was too much to implement
        try {
            BinarySearchTree result = service.createTree(request.get("numbers"), balanced);
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