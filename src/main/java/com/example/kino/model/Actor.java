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
@Table(name = "actor")
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "actor_seq_gen")
    @SequenceGenerator(name = "actor_seq_gen", sequenceName = "actor_seq_gen", allocationSize = 1)
    @Column(name = "actor_id")
    private Long actorID;

    @Column(name = "actor_name")
    private String actorName;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Actor actor = (Actor) o;
        return Objects.equals(actorID, actor.actorID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(actorID);
    }
}
