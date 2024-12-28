package com.example.demo.service;

import com.example.demo.entity.Color;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ColorServices {

    public List<Color> getAllColor();

    public Page<Color> pageColor(Pageable pageable);

    public Color add(Color nhaSanXuat);


}
