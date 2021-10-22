package com.example.kino.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "candy")

public class Candy {
    @Id
    @Column(name = "candy_id")
    @GeneratedValue
    @SequenceGenerator(name = "candy_seq_gen", sequenceName = "candy_seq_gen", allocationSize = 1)
    private Long candyID;

    @Column(name = "candy_name")
    private String candyName;

    @Column(name = "candy_price")
    private Double candyPrice;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Candy candy = (Candy) o;
        return candyID.equals(candy.candyID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(candyID);
    }
}
