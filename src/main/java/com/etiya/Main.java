package com.etiya;

import com.etiya.business.concretes.BrandServiceImpl;
import com.etiya.business.dtos.requests.CreateBrandRequest;
import com.etiya.business.dtos.responses.CreatedBrandResponse;
import com.etiya.business.dtos.responses.GetAllBrandResponse;
import com.etiya.dataAccess.concretes.BrandRepositoryImpl;
import com.etiya.dataAccess.concretes.BrandRepositoryImplHibernate;
import com.etiya.entities.Brand;
import com.etiya.entities.Car;
import com.etiya.entities.Model;
import com.etiya.entities.Transmission;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Brand brand1 = new Brand();
        brand1.setId(1);
        brand1.setName("BMW");

        Model model1 = new Model();
        model1.setId(1);
        model1.setName("Series 1");
        model1.setBrand(brand1);

        Car car1 = new Car();
        car1.setId(1);
        car1.setPlate("06ABC01");
        car1.setModel(model1);


        Brand brand2 = new Brand();
        brand2.setId(2);
        brand2.setName("Mercedes");


        Model model2 = new Model();
        model2.setId(2);
        model2.setName("Series 2");
        model2.setBrand(brand1);

        Car car2 = new Car();
        car2.setId(2);
        car2.setPlate("06ABC02");
        car2.setModel(model1);

        Transmission transmission1 = new Transmission();
        transmission1.setId(1);
        transmission1.setName("manuel");


        //interfaceler new'lenemez

        //BRAND
        CreateBrandRequest request = new CreateBrandRequest();
        request.setName("BMW");
        //default repository
        BrandServiceImpl brandService = new BrandServiceImpl(new BrandRepositoryImpl());
        brandService.add(request);
        //Hibernate olan
        BrandServiceImpl brandService2 = new BrandServiceImpl(new BrandRepositoryImplHibernate());
        brandService2.add(request);


        CreatedBrandResponse response = brandService.add(request);
        System.out.println(response.getName());
        System.out.println("--------------------------------------");


        List<GetAllBrandResponse> allBrands = brandService.getAll();

        for (var brand:allBrands) {
            System.out.println(brand.getId()+"/"+ brand.getName()+"/"+brand.getCreatedDate());
        }

/*
        //FUEL
        CreateFuelRequest fuelRequest = new CreateFuelRequest();
        fuelRequest.setName("Diesel");
        FuelServiceImpl fuelService = new FuelServiceImpl(new FuelRepositoryImpl());
        fuelService.add(fuelRequest);
        //hibernate
        FuelServiceImpl fuelService2 = new FuelServiceImpl(new FuelRepositoryImplHibernate());
        fuelService2.add(fuelRequest);


        //TRANSMISSION
        CreateTransmissionRequest transmissionRequest = new CreateTransmissionRequest();
        transmissionRequest.setName("Manuel");
        TransmissionServiceImpl transmissionService = new TransmissionServiceImpl(new TransmissionRepositoryImpl());
        transmissionService.add(transmissionRequest);
        //hibernate
        TransmissionServiceImpl transmissionService2 = new TransmissionServiceImpl(new TransmissionRepositoryImplHibernate());
        transmissionService2.add(transmissionRequest);

        CreatedTransmissionResponse response2 = new CreatedTransmissionResponse();
        System.out.println(response2.getName());*/
    }
}