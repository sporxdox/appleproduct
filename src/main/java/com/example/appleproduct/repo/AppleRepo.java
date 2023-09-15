package com.example.appleproduct.repo;

import com.example.appleproduct.entity.Apple;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppleRepo extends JpaRepository<Apple, Long> {
}
