package ru.netology.domain;

import lombok.NoArgsConstructor;
import lombok.Data;

@NoArgsConstructor
@Data
public class Book extends Product {
    private String author;

    public Book(int id, String name, int price, String author) {
        super(id, name, price);
        this.author = author;
    }

    @Override
    public boolean matches(String search) {
        if (super.matches(search)) { // вызов метода matches в Product
            return true;
        }
        return author.contains(search);
    }
}