/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.belrose.spring.sec_jwt.web;

import cm.belrose.spring.sec_jwt.entities.Users;
import cm.belrose.spring.sec_jwt.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Ngnawen
 */
@RestController
public class AccountRestController {
    @Autowired
    private AccountService  accountService;
    @PostMapping("/register")
    public Users resgister (@RequestBody RegisterForm registerForm){
        if(!registerForm.getPasseword().equals(registerForm.getRepasseword()))
            throw new RuntimeException("you must confirm your password");
        Users user1=accountService.findUserByUserName(registerForm.getUsername());
        if(user1!=null) throw new RuntimeException("This user is already exist!!!!");
        Users user=new Users();
        user.setNomUser(registerForm.getUsername());
        user.setPassword(registerForm.getPasseword());
        accountService.saveUser(user);
       accountService.addRoleToUser(registerForm.getUsername(), "USER");
        return user;
        
        
    }
    
}
