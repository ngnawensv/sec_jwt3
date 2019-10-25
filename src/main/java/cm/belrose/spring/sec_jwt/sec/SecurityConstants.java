/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.belrose.spring.sec_jwt.sec;

/**
 *
 * @author Ngnawen
 */
public class SecurityConstants {
    public static final String SECRET="ver@ngnawen.net";
    public static final long EXPIRATION_TIME= 864_000_000;
    public static final String TOKEN_PREFIX="Bearer ";
    public static final String HEADER_STRING="Authorization";
    
}
