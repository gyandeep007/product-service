package com.example.productservice.controller;

import com.example.productservice.entity.ProductCategory;
import com.example.productservice.service.ProductCategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product-category")
public class ProductCategoryController {

    private ProductCategoryService productCategoryService;

    public ProductCategoryController(ProductCategoryService productCategoryService) {
        this.productCategoryService = productCategoryService;
    }

    @GetMapping()
    public List<ProductCategory> listProductCategoryById(){

        return productCategoryService.listProductCategory();
    }

    @GetMapping("/{categoryId}")
    public ProductCategory getProductCategoryById(@PathVariable("categoryId") Integer categoryId){

        return productCategoryService.getProductCategoryById(categoryId);
    }

    @PostMapping
    public ProductCategory createProductCategory(@RequestBody ProductCategory productCategory){

      return   productCategoryService.addProductCategory(productCategory);
    }
    @PutMapping
    public ProductCategory updateProductCategory(@RequestBody ProductCategory productCategory){

        return   productCategoryService.updateProductCategory(productCategory);
    }

    @DeleteMapping("/{categoryId}")
    public void deleteProductCategory(@PathVariable("categoryId") Integer categoryId){
        productCategoryService.deleteProductCategory(categoryId);
    }
}
