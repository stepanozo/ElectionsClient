/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ElectionsClient.model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.Objects;
import lombok.Getter;

/**
 *
 * @author чтепоноза
 */

public class User {
    
    
    //Всем полям даём пустые значения по умолчанию, т.к. это нужно для пустого конструктора, без которого не будет работать Hibernate.
    @Expose
    @SerializedName("login")
    @Getter
    private String login ="";
    
    @Expose
    @SerializedName("passwordHash")
    @Getter
    private String passwordHash = "";
    
    @Expose
    @SerializedName("voted")
    @Getter
    private boolean voted = false;
    
    @Expose
    @SerializedName("admin")
    @Getter
    private boolean isAdmin = false;
    
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
