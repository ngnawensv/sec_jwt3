/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.belrose.spring.sec_jwt.service;

import cm.belrose.spring.sec_jwt.entities.Roles;
import cm.belrose.spring.sec_jwt.entities.Users;

/**
 *
 * @author Ngnawen
 */
public interface AccountService {
    public Users saveUser(Users user);
    public Roles savaRoles(Roles role);
    public void addRoleToUser(String nomUser, String nomRole);
    public Users findUserByUserName(String nomUser);
    
    
}
