package com.app.products.serviceproducts.models.service;

import com.app.products.serviceproducts.models.entity.Producto;

import java.util.List;

public interface IProductosService {

    public List<Producto> findAll();
    public Producto findById(Long id);
}
