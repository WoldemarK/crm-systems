package com.example.crmsystems.company.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Builder
@Table(name = "products")
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    /**
     * Стоимость за единицу
     */
    private Long cost;

    /**
     *  Тип продукции. Холодильник, телефон итд
     */
    private String type;

    /**
     * Samsung galaxy s10
     */
    private String model;

    /**
     * Samsung
     */
    private String brand;

    /**
     * Количество в наличие
     */
    private Long quantity;

    /**
     * описание / характеристики товара
     */
    private String description;
}
