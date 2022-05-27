package com.example.service;

import com.example.routes.Emp;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@ApplicationScoped
@Named("empService")
public class EmpService {
    public void testEmp(Emp e) {
        System.out.println(Thread.currentThread().getName() + " : " + e);
    }
}
