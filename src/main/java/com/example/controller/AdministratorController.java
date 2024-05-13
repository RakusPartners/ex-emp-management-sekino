package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.form.InsertAdministratorForm;
import com.example.service.AdministratorService;

@Controller
@RequestMapping("/")
public class AdministratorController {
    @Autowired
    private AdministratorService administratorService;

    /**
     * 「administrator/insert.html」にフォワードする処理を記述する。
     * ※フォームを引数で受け取ることで従業員登録する際のリクエストパラメータが格納される
     * InsertAdministratorForm オブジェクトが Model オブジェクト(リクエストスコープ)に⾃動的に格納されます。
     * @param form
     * @param model
     * @return
     */
    @GetMapping("/toInsert")
    public String toInsert(InsertAdministratorForm form,Model model){
        model.addAttribute("administratorForm", form);

        return "administrator/insert.html";
    }


    
}