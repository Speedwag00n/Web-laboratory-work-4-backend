package ilia.nemankov.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Point {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private double x;

    private double y;

    private int r;

    private boolean hit;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

}
