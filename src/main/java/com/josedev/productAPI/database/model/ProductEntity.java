package com.josedev.productAPI.database.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "product")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "Name is required")
    private String name;

    @Column(nullable = false)
    @NotBlank(message = "Description is required")
    private String description;
    @Column(nullable = false)
    @Positive(message = "Price must be a positive values!")
    @NotNull(message = "Price is required")
    private BigDecimal price;

    @Column(nullable = false)
    @NotNull
    @PositiveOrZero(message = "Stock must be a positive values or zero!")
    private Integer stock;
}
