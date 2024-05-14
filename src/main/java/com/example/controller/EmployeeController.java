package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    /**
     * employeeService の showList()メソッドを呼び出し、従業員⼀覧(List)を取得する。
     * 次の画⾯に表⽰するために request スコープに取得した従業員⼀覧を「employeeList」という名前を付けて格納する。
     * @param model
     * @return
     */
    @GetMapping("/showList")
    public String showList(Model model){
        model.addAttribute("employeeList", employeeService.showList());
        return "employee/list.html";

    }
}