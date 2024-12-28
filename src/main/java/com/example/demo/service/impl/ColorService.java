package com.example.demo.service.impl;


import com.example.demo.entity.Color;
import com.example.demo.repositories.ColorRepo;
import com.example.demo.service.ColorServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColorService implements ColorServices {

    @Autowired
    private ColorRepo colorRepo;

    @Override
    public List<Color> getAllColor() {
        return colorRepo.getAll();
    }

    @Override
    public Page<Color> pageColor(Pageable pageable) {
        return colorRepo.findAll(pageable);
    }

    @Override
    public Color add(Color nhaSanXuat) {
        nhaSanXuat.setColorName(nhaSanXuat.getColorName());
        return colorRepo.save(nhaSanXuat);
    }

    @Override
    public Color detail(Long id) {
        return colorRepo.findById(id).orElse(null);
    }
}
