/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package electionsClient.model;
import java.util.Objects;
import lombok.Data;

/**
 *
 * @author чтепоноза
 */

public class User {
    
    
    //Всем полям даём пустые значения по умолчанию, т.к. это нужно для пустого конструктора, без которого не будет работать Hibernate.
    private String login ="";
    
    private String passwordHash = "";
    private boolean voted = false;
    
    private boolean isAdmin = false;
    
    
//    //Тот же метод, что и конструктор, но в него передаётся не хеш, а пароль, который хешируется
//    public static User hashAndCreate(String login, String password, boolean voted, boolean isAdmin){
//        return new User(login, MD5Hashing.hashPassword(password), voted, isAdmin);
//    }
    
    public User(){
        //Этот пустой конструктор попросил меня сделать Hibernate, без него он отказывается работать с базой данных.
    }
    
    public User(String login, String passwordHash, boolean voted, boolean isAdmin){
        this.login = login;
        this.passwordHash = passwordHash;
        this.voted = voted;
        this.isAdmin = isAdmin;
    }
    
    @Override
    public boolean equals(Object obj) {
        if(obj == this){
            return true;
        }
        if(obj == null || obj.getClass() != this.getClass()){
            return false;
        }
        User user = (User)obj;
        
        return 
            Objects.equals(user.login, this.login) && 
            Objects.equals(user.passwordHash, this.passwordHash) &&
            user.voted == this.voted && 
            user.isAdmin == this.isAdmin;
    }

    @Override
    public int hashCode() {
        return 
            login.hashCode() + 
            passwordHash.hashCode() +
            ((Boolean)voted).hashCode()+
            ((Boolean)isAdmin).hashCode();
    }
    
    @Override
    public String toString(){
        return login + (isAdmin ? ", админ" : "");
    }
}
