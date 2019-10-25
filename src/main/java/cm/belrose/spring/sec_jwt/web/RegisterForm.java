/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.belrose.spring.sec_jwt.web;

import lombok.Data;

/**
 *
 * @author Ngnawen
 */
@Data
public class RegisterForm {
    private String username;
    private String passeword;
    private String repasseword;
    
}
