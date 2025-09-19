package com.credibanco.assessment.card.repository;

import com.credibanco.assessment.card.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Long> {
    boolean existsByPanHash(String panHash);
}
