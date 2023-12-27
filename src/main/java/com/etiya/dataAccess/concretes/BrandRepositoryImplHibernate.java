package com.etiya.dataAccess.concretes;

import com.etiya.dataAccess.abstracts.BrandRepository;
import com.etiya.entities.Brand;

import java.util.List;

public class BrandRepositoryImplHibernate implements BrandRepository {
    @Override
    public Brand add(Brand brand) {
        System.out.println("Brand added to BrandRepositoryImplHibernate");

        brand.setId(10);
        return brand;
    }

    @Override
    public List<Brand> getAll() {
        return null;
    }
}
