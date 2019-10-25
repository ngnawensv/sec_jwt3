/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.belrose.spring.sec_jwt.serviceImpl;

import cm.belrose.spring.sec_jwt.dao.RolesRepository;
import cm.belrose.spring.sec_jwt.dao.UsersRepository;
import cm.belrose.spring.sec_jwt.entities.Roles;
import cm.belrose.spring.sec_jwt.entities.Users;
import cm.belrose.spring.sec_jwt.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Ngnawen
 */
@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private RolesRepository rolesRepository;

    @Override
    public Users saveUser(Users user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return usersRepository.save(user);

    }

    @Override
    public Roles savaRoles(Roles role) {
        return rolesRepository.save(role);
    }

    @Override
    public void addRoleToUser(String nomUser, String nomRole) {
        Users user = usersRepository.findByNomUser(nomUser);
        Roles role = rolesRepository.findByNomRole(nomRole);
        user.getRoles().add(role);
    }

    @Override
    public Users findUserByUserName(String nomUser) {
        return usersRepository.findByNomUser(nomUser);
    }

}
