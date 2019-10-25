/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.belrose.spring.sec_jwt.dao;

import cm.belrose.spring.sec_jwt.entities.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Ngnawen
 */
public interface RolesRepository extends JpaRepository<Roles, Long> {
    public Roles findByNomRole(String nomRole);
    
}
