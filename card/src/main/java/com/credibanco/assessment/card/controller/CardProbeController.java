package com.credibanco.assessment.card.controller;

import com.credibanco.assessment.card.model.Card;
import com.credibanco.assessment.card.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/probe/cards")
@RequiredArgsConstructor
public class CardProbeController {

    private final CardRepository repo;

    // Verifica que la tabla exista y que la app se conecta (debería devolver 0 al inicio)
    @GetMapping("/count")
    public long count() {
        return repo.count();
    }

    @PostMapping
    public ResponseEntity<Card> create(@RequestBody Card body) {
        body.setId(null);
        if (repo.existsByPanHash(body.getPanHash())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(repo.save(body));
    }
}
