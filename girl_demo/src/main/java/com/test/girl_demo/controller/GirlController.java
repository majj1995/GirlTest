package com.test.girl_demo.controller;

import com.test.girl_demo.domain.Girl;
import com.test.girl_demo.domain.Result;
import com.test.girl_demo.repository.GirlRepository;
import com.test.girl_demo.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class GirlController {

    @Autowired
    private GirlRepository girlRepository;

    @GetMapping(value = "/girl/{id}")
    public Result girlFindOne(@PathVariable("id") Integer id) {
        return ResultUtils.success(girlRepository.findById(id).orElse(null));
    }

    @GetMapping(value = "/girl/age/{age}")
    public List<Girl> gilrListByAge(@PathVariable("age") Integer age) {
        return girlRepository.findByAge(age);
    }

    @GetMapping(value = "/girl")
    public List<Girl> girlList() {
        return girlRepository.findAll();
    }



    @PostMapping(value = "/girl")
    public Result<Girl> girlAdd(@Valid Girl girl, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResultUtils.error(1, bindingResult.getFieldError().getDefaultMessage());
        }

        girl.setName(girl.getName());
        girl.setAge(girl.getAge());
        return ResultUtils.success(girlRepository.save(girl));
    }

    @PutMapping(value = "/girl")
    public Girl girlUpdate(Girl girl) {
        girl.setId(girl.getId());
        girl.setAge(girl.getAge());
        girl.setName(girl.getName());

        return girlRepository.save(girl);
    }






}
