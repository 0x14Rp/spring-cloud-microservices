package com.app.products.serviceproducts.controller;

import com.app.products.serviceproducts.models.entity.Producto;
import com.app.products.serviceproducts.models.service.IProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ProductoController {

    //@Autowired
    //private Environment env;

    @Value("${server.port}")
    private Integer port;

    @Autowired
    private IProductosService productoService;

    @GetMapping("/listar")
    public List<Producto> listar() {
        return productoService.findAll().stream().map(producto -> {
            //producto.setPort(Integer.parseInt(env.getProperty("local.server.port")));
            producto.setPort(port);
            return producto;
        }).collect(Collectors.toList());
    }

    @GetMapping("/ver/{id}")
    public Producto detalle(@PathVariable Long id) {
        Producto producto = productoService.findById(id);
        //producto.setPort(Integer.parseInt(env.getProperty("local.server.port")));
        producto.setPort(port);
        return producto;
    }

}