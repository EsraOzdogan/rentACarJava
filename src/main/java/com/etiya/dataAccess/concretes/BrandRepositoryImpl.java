package com.etiya.dataAccess.concretes;

import com.etiya.dataAccess.abstracts.BrandRepository;
import com.etiya.entities.Brand;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BrandRepositoryImpl implements BrandRepository {
    List<Brand> brands;  //typesafe, array

    public  BrandRepositoryImpl(){
        Brand brand1 = new Brand();
        brand1.setId(1);
        brand1.setName("BMW");
        brand1.setCreatedDate(LocalDateTime.now());

        Brand brand2 = new Brand();
        brand2.setId(2);
        brand2.setName("Audi");
        brand2.setCreatedDate(LocalDateTime.now());

        Brand brand3 = new Brand();
        brand3.setId(3);
        brand3.setName("Mercedes");
        brand3.setCreatedDate(LocalDateTime.now());

        brands =new ArrayList<>();
        brands.add(brand1);
        brands.add(brand2);
        brands.add(brand3);

    }
    @Override
    public Brand add(Brand brand){ //void yerine Brand yazildi Brand dönderecegi icin
        //Jpa kodlari
        System.out.println("Brand added to BrandRepositoryImpl");

        //brand.setId(10);
        brand.setId((int)Math.random());
        brands.add(brand);
        return brand; //veri tabaninda olusmus brandi dönderiyoruz
    }

    @Override
    public List<Brand> getAll() {
        return brands;
    }
}
