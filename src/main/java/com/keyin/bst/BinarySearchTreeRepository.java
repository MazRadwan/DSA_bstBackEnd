// BinarySearchTreeRepository.java
package com.keyin.bst;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BinarySearchTreeRepository extends JpaRepository<BinarySearchTree, Long> {
}