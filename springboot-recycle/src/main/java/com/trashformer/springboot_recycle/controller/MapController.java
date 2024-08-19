package com.trashformer.springboot_recycle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import com.trashformer.springboot_recycle.entity.RecycleEntity;
import com.trashformer.springboot_recycle.repository.RecycleRepository;
@CrossOrigin
@Controller
public class MapController {
    @Autowired RecycleRepository recycleRepository;    
    @GetMapping("/dataload")
    @ResponseBody
    public List<RecycleEntity> mapdata(){
        List<RecycleEntity> latlng = recycleRepository.findAll();
        return latlng;
    }
}
