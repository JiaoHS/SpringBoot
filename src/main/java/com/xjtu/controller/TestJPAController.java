package com.xjtu.controller;

import com.xjtu.entities.TestJPA;
import com.xjtu.repository.TestJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * @auther coraljiao
 * @date 2018/12/28 14:52
 * @description
 */
@RestController
@RequestMapping(value = "/jpa")
public class TestJPAController {
    @Autowired
    TestJpaRepository testJpaRepository;
//    @RequestMapping("/jpa/{id}")
//    public TestJPA getTestJPA(@PathVariable("id") Integer id){
//        Optional<TestJPA> byId = testJpaRepository.findById(id);
//        return byId;
//    }

    @RequestMapping(value = "/save", method = RequestMethod.GET)
    public TestJPA save(TestJPA user) {
        return testJpaRepository.save(user);
    }

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<TestJPA> list(){
        return testJpaRepository.findAll();
    }

    @RequestMapping(value = "/delete/{id}",method = RequestMethod.GET)
    public List<TestJPA> delete(@PathVariable(name = "id") Integer id){
        testJpaRepository.deleteById(id);
        return testJpaRepository.findAll();
    }

    @RequestMapping(value = "/find/{id}",method = RequestMethod.GET)
    public TestJPA find(@PathVariable(name = "id") Integer id){
        Optional<TestJPA> byId = testJpaRepository.findById(id);

        return byId.get();
    }
}

