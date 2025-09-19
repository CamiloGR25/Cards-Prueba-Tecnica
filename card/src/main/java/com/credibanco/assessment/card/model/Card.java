package com.credibanco.assessment.card.model;

import jakarta.persistence.*;
import lombok.*;

@Entity @Table(name = "cards")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Card {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 64)
    private String panHash;

    @Column(nullable = false, length = 20)
    private String holderName;
}
