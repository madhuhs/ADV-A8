package com.jspiders.data.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private double price;
    private double rating;

    @ManyToMany
    @JoinTable(
            name = "product_category_map",
            joinColumns = @JoinColumn(name = "product_id"),         // FK to product
            inverseJoinColumns = @JoinColumn(name = "category_id")  // FK to category
    )
    private List<CategoryEntity> categories = new ArrayList<>();
    public long getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public List<CategoryEntity> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryEntity> categories) {
        this.categories = categories;
    }

    public void addCategory(CategoryEntity categoryEntity){
        categories.add(categoryEntity);
    }

    @Override
    public String toString() {
        return "ProductEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", rating=" + rating +
                ", categories=" + categories +
                '}';
    }
}
