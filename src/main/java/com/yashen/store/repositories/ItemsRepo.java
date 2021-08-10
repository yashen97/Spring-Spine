package com.yashen.store.repositories;

import com.yashen.store.models.Items;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemsRepo extends JpaRepository<Items,Long> {
}
