package exercise.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import exercise.model.Product;

import org.springframework.data.domain.Sort;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // BEGIN
    //Добавьте в репозиторий определение нужных методов, чтобы сделать выборку товаров по цене.
    List<Product> findAllByPrice(Integer price);

    List<Product> findByPriceLessThan(Integer price);

    List<Product> findByPriceLessThanEqual(Integer price);

    List<Product> findByPriceBetween(Integer startPrice, Integer endPrice);

    List<Product> findByPriceOrderByPrice(Integer price);

    List<Product> findByPriceOrderByPriceDesc(Integer price);

    // END
}
