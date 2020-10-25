package com.awysocki.caloriecalculator.entity;

import javax.persistence.*;
import java.util.List;

/**
 * This is entity class representing Day.
 */
@Entity
@Table(name = "day")
public class Day {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    public List<DayIngredient> getDayIngredients() {
        return dayIngredients;
    }

    public void setDayIngredients(List<DayIngredient> dayIngredients) {
        this.dayIngredients = dayIngredients;
    }

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "day_id")
    private List<DayIngredient> dayIngredients;

    @Column(name = "description")
    private String description;

    @Override
    public String toString() {
        return "Day{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
