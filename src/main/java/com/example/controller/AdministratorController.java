package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.example.domain.Administrator;
import com.example.form.InsertAdministratorForm;
import com.example.form.LoginForm;
import com.example.service.AdministratorService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class AdministratorController {
    @Autowired
    private AdministratorService administratorService;
    @Autowired
    private HttpSession session;

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

    @PostMapping("/insert")
    public String insert(InsertAdministratorForm form){
        Administrator administrator = new Administrator();
        administrator.setName(form.getName());
        administrator.setMailAddress(form.getMailAddress());
        administrator.setPassword(form.getPassword());
        
        administratorService.insert(administrator);
        return "redirect:/";
    }







    // @PostMapping("/login")
    // public String login(LoginForm form,Model model){
    //     administratorService.login(form.getMailAddress(), form.getPassword());
    //     if(form == null){
    //         String error = "メールアドレスまたはパスワードが不正です";
    //         model.addAttribute("error", error);
    //         return "administrator/insert.html";
    //     }
    //     return ""
    // }


    
}