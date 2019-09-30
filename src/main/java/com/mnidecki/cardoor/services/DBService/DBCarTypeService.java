package com.mnidecki.cardoor.services.DBService;

import com.mnidecki.cardoor.domain.car.CarType;
import com.mnidecki.cardoor.repository.CarTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DBCarTypeService {

    @Autowired
    private CarTypeRepository carTypeRepository;

    public CarType getDefaultCarType() {
        CarType unknown = carTypeRepository.findCarTypeByType("Unknown");
        if (unknown == null) {
            unknown = new CarType("Unknown");
            save(unknown);
        }
        return unknown;
    }

    public List<CarType> findAll() {
        return carTypeRepository.findAll();
    }

    public CarType getById(final Long id) {
        return carTypeRepository.findById(id).orElseGet(this::getDefaultCarType);
    }

    public CarType save(final CarType carType) {
        return carTypeRepository.save(carType);
    }

    public void deleteById(final Long id) {
        carTypeRepository.deleteById(id);
    }
}