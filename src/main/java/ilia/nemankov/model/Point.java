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

    private double r;

    private boolean hit;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;

}
