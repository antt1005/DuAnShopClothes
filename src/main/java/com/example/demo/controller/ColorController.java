package com.example.demo.controller;


import com.example.demo.entity.Color;
import com.example.demo.entity.propertis.Status;
import com.example.demo.repositories.ColorRepo;
import com.example.demo.service.impl.ColorService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Random;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/coler")
@Tag(name = "Coler", description = "( Rest API Hiển thị, thêm, sửa, xóa mau sac )")
@Validated
public class ColorController {

    @Autowired
    private ColorService colorService;

    @Autowired
    private ColorRepo colorRepo;


    @GetMapping("/hien-thi")
    public ResponseEntity<?> hienThi() {
        return ResponseEntity.ok(colorService.getAllColor());
    }


    @GetMapping("/hien-thi-page")
    public ResponseEntity<?> hienThiPage(@RequestParam(defaultValue = "0") Integer page) {
        Pageable pageable = PageRequest.of(page, 10);
        Page<Color> producerPage = colorRepo.getAllByStatus(Status.DANG_HOAT_DONG, pageable);
        return ResponseEntity.ok(producerPage.getContent());
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Color Color) {
        String ma = "MS" + new Random().nextInt(100000);
        Color.setCode(ma);
        Color.setDateCreate(new Date());
        return ResponseEntity.ok(colorService.add(Color));
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id, @RequestBody(required = false) Color cl) {
        try {
            Color existingProducer = colorRepo.findById(id).orElse(null);
            if (existingProducer != null) {
                existingProducer.setDateCreate(existingProducer.getDateCreate());
                existingProducer.setDateUpdate(new Date());
                existingProducer.setStatus(Status.NGUNG_HOAT_DONG);
                return ResponseEntity.ok(colorService.xoa(id));
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            e.printStackTrace();


            return ResponseEntity.ok(colorService.detail(id));
        }

    }
}
