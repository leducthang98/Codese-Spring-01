package com.example.codese_spring.controller;

import com.example.codese_spring.dto.ProductDTO;
import com.example.codese_spring.dto.ReceiptRequestDTO;
import com.example.codese_spring.helper.ResponseBuilder.ResponseForm;
import com.example.codese_spring.service.ReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/receipt")
public class ReceiptController {
    @Autowired
    ReceiptService receiptService;

    @PostMapping("/new")
    public @ResponseBody
    ResponseEntity<ResponseForm<Boolean>> addReceipt(@RequestBody ReceiptRequestDTO receiptRequestDTO, @RequestParam String token) {
        return ResponseEntity.ok(ResponseForm.buildCustomResponse(receiptService.addReceipt(receiptRequestDTO, token), 1, "okokok"));
    }
}
