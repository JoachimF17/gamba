package be.pandapp.gamba.models.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "country")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false, unique = true, length = 50)
    private String name;

    @Column(name = "flag", nullable = false, unique = true)
    private String flag;

    @Column(name = "color_code", nullable = false, length = 50)
    private String color_code;
}