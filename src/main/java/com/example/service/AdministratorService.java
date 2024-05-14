package com.example.service;
/**
 * ログイン処理をする。
 * administratorRepository のfindByMailAddressAndPassword ()メソッドを呼ぶ処理を記述する。
 * 戻ってきた管理者情報をそのまま呼び出し元に返す。
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Administrator;

@Service
@Transactional
public class AdministratorService {

    @Autowired
    private com.example.repository.AdministratorRepository AdministratorRepository;

    public Administrator login(String mailAddres,String password){
        return AdministratorRepository.findByMailAddressAndPassword(mailAddres, password);
    }

    public void insert(Administrator administrator){
        AdministratorRepository.insert(administrator);
        
    }
}