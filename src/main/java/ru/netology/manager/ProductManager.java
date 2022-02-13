package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.domain.Product;
import ru.netology.repository.ProductRepository;

import java.util.Arrays;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductManager {
    private ProductRepository repository;

    public void add(Product product) {
        repository.save(product);
    }

    public Product[] searchBy(String search) {
        Product[] result = new Product[0];
        Product[] tmp;
        int length = 0;
        for (Product product : repository.findAll()) {
            if ((product.matches(search))) {
                length++;
                tmp = Arrays.copyOf(result, length);
                tmp[length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }
}