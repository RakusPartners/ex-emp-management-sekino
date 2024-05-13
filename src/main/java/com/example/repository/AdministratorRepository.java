package com.example.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Administrator;


@Repository
public class AdministratorRepository {
    @Autowired
    private NamedParameterJdbcTemplate template;

    private static final RowMapper<Administrator> ADMINISTRATOR_ROW_MAPPER = new BeanPropertyRowMapper<>(Administrator.class);

    /**
     * 管理者情報を挿⼊する。
     * @param administrator
     */
    public void insert(Administrator administrator){
        if(administrator.getId() == null){
        SqlParameterSource param = new BeanPropertySqlParameterSource(administrator);
        String sql = "INSERT INTO administrators(name,mail_address,password) VALUES(:name,:mailAddress,:password)";
        template.update(sql, param);
        }
    }

    /**
     * メールアドレスとパスワードから管理者情報を取得する
     * (1 件も存在しない場合は null を返す※)。
     * @param mailAddress
     * @param password
     * @return
     */
    public Administrator findBy(String mailAddress,String password){
    
        SqlParameterSource param = new MapSqlParameterSource().addValue("mailAddress", mailAddress).addValue("password", password);

        String sql = "SELECT id,name,mail_address,password FROM administrators WHERE mail_address LIKE '%:mailAddless%' AND password LIKE '%:password%'"; 

        java.util.List<Administrator> administratorList
        = template.query(sql, param, ADMINISTRATOR_ROW_MAPPER);
        if (administratorList.size() == 0) {
            return null;
        }
        return administratorList.get(0);
    }
}