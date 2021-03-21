package com.example.codese_spring.controller;

import com.example.codese_spring.constant.Constant;
import com.example.codese_spring.dto.ProductDTO;
import com.example.codese_spring.dto.ProductHomepageDTO;
import com.example.codese_spring.dto.ProductWithPagingDTO;
import com.example.codese_spring.helper.Jwt.Jwt;
import com.example.codese_spring.helper.ResponseBuilder.ResponseForm;
import com.example.codese_spring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
    search: khong truyen gi => all product
            khong phan biet dau, upper case, lower case
            bắt các ký tự đặc biệt
            path: GET product/search?searchData=

     update: path PUT product/:id(body)
             không tồn tại id => báo là không tồn tại
             chỉ update những trường được truyền trong body, các trường khác giữ nguyên

     delete: path DELETE product/:id
             không tồn tại id => báo là không tồn tại

             receipt: id, accountID, totalMoney, createAt, updateAt, deleted, status
             receipt detail: receiptID, productID, amount

             tạo đơn hàng nhiều sp, mỗi sp có amount => tính tiền
 */

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;

    // get all
    @GetMapping("/all")
    public ResponseEntity<ResponseForm<List<ProductHomepageDTO>>> getAllProducts() {
        List<ProductHomepageDTO> productHomepageDTO = productService.getAllProducts();
        return ResponseEntity.ok(ResponseForm.buildCustomResponse(productHomepageDTO, 1, "okokok"));
    }

    // tim bang id
    @GetMapping("/:id")
    public @ResponseBody
    ResponseEntity<ResponseForm<ProductDTO>> getProductById(@RequestParam String idInput) {
        return ResponseEntity.ok(ResponseForm.buildCustomResponse(productService.getProductById(idInput), 1, "okokok"));
    }

    // sap xep priceOut
    @GetMapping("/priceout")
    public @ResponseBody
    ResponseEntity<ResponseForm<List<ProductDTO>>> getProductByPriceWithOrder(@RequestParam Integer sortType) {
        return ResponseEntity.ok(ResponseForm.buildCustomResponse(productService.getProductByPriceWithOrder(sortType), 1, "okokok"));
    }

    // sap xep display
    @GetMapping("/display")
    public @ResponseBody
    ResponseEntity<ResponseForm<List<ProductDTO>>> getProductByDisplayWithOrder(@RequestParam Integer sortType) {
        return ResponseEntity.ok(ResponseForm.buildCustomResponse(productService.getProductByDisplayWithOrder(sortType), 1, "okokok"));
    }

    // tim kiem theo ten khong phan biet hoa thuong
    @GetMapping("/name")
    public @ResponseBody
    ResponseEntity<ResponseForm<List<ProductDTO>>> getProductByDisplay(@RequestParam String display) {
        return ResponseEntity.ok(ResponseForm.buildCustomResponse(productService.getProductByDisplay(display), 1, "okokok"));
    }

    // paging
    @GetMapping("/order")
    public @ResponseBody
    ResponseEntity<ResponseForm<ProductWithPagingDTO>> getAllProductWithPaging(@RequestParam(required = false) Integer page, @RequestParam(required = false) Integer size, @RequestHeader String token) {
        String userId = Jwt.verifyToken(token, Constant.SECRET_KEY);
        //
        return ResponseEntity.ok(ResponseForm.buildResponse(null));
    }

    // add product
    @PostMapping("/add")
    public ResponseEntity<ResponseForm<Boolean>> addProduct(@RequestBody ProductDTO productDTO) {
        return ResponseEntity.ok(ResponseForm.buildCustomResponse(productService.addProduct(productDTO), 1, "okokok"));
    }

    // update product bang id
    @PutMapping("/update")
    public @ResponseBody
    ResponseEntity<ResponseForm<Boolean>> updateProduct(@RequestBody ProductDTO productDTO) {
        return ResponseEntity.ok(ResponseForm.buildCustomResponse(productService.updateProduct(productDTO), 1, "okokok"));
    }

    // delete product by id
    @DeleteMapping("/delete")
    public @ResponseBody
    ResponseEntity<ResponseForm<Boolean>> deleteProduct(@RequestParam String productID) {
        return ResponseEntity.ok(ResponseForm.buildCustomResponse(productService.deleteProduct(productID), 1, "okokok"));
    }

}
