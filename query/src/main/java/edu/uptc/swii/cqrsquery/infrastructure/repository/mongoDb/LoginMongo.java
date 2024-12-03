package edu.uptc.swii.cqrsquery.infrastructure.repository.mongoDb;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

@Document(collection="login")
public class LoginMongo {
    

    @Id
    @JsonProperty("id")
    private Long id;
    @JsonProperty("customerId")
    private String customerId;
    @JsonProperty("password")
    private String password;


    public LoginMongo(){

    }

    public LoginMongo(Long id, String customerId, String password){
        this.id = id;
        this.customerId = customerId;
        this.password = password;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getCustomerId(){
        return customerId;
    }

    public void setCustomerId(String customerId){
        this.customerId = customerId;
    }
    
    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }
}
