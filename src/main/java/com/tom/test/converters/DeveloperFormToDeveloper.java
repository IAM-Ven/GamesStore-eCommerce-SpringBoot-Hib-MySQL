package com.tom.test.converters;

import com.tom.test.commands.DeveloperForm;
import com.tom.test.domain.Developer;
import com.tom.test.domain.Product;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tom on 6/26/2016.
 */
@Component
public class DeveloperFormToDeveloper implements Converter<DeveloperForm,Developer> {
    @Override
    public Developer convert(DeveloperForm developerForm) {
        System.out.println("We hitted the convertor");
        Developer developer = new Developer();

        developer.setId(developerForm.getDeveloperId());
        developer.setVersion(developerForm.getDeveloperVersion());
        developer.setName(developerForm.getDeveloperName());
        developer.setDescription(developerForm.getDeveloperDescription());
        developer.setImageUrl(developerForm.getDeveloperImageUrl());

        List<Product> productList;
        if (developerForm.getDeveloperProducts()!= null) {
            productList = new ArrayList<>(developerForm.getDeveloperProducts());
        }
        else{
            productList = new ArrayList<>();
        }
        developer.setProducts(productList);

        for (Product product:productList){
            product.setDeveloper(developer);
        }

        System.out.println("Before returnning converted developer");
        return developer;
    }
}
