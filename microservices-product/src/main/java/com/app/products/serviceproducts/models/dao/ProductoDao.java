package com.app.products.serviceproducts.models.dao;

import com.app.products.serviceproducts.models.entity.Producto;
import org.springframework.data.repository.CrudRepository;

public interface ProductoDao extends CrudRepository<Producto,Long> {


}
