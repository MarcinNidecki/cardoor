package com.mnidecki.cardoor.repository;

import com.mnidecki.cardoor.domain.car.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarRepository extends CrudRepository<Car, Integer> {

    @Override
    List<Car> findAll();

    Optional<Car> findById(Long id);

    @Override
    Car save(Car car);

    void deleteById(Long id);

}
