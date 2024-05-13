package com.example.form;
/**
 * ログイン時に使⽤するフォーム
 */
public class LoginForm {

    private String mailAddress;/** メールアドレス */
    private String password;/** パスワード */


    
    @Override
    public String toString() {
        return "LoginForm [mailAddress=" + mailAddress + ", password=" + password + "]";
    }
    public String getMailAddress() {
        return mailAddress;
    }
    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }


    
}