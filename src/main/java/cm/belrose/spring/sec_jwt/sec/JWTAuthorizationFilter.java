/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.belrose.spring.sec_jwt.sec;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 *
 * @author Ngnawen
 */
public class JWTAuthorizationFilter extends OncePerRequestFilter{

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
    String jwtToken=request.getHeader(SecurityConstants.HEADER_STRING);
        System.out.println(jwtToken);
        if (jwtToken==null || !jwtToken.startsWith(SecurityConstants.TOKEN_PREFIX)) {
            filterChain.doFilter(request, response);
            return;//pour dire je quitte la methode
            
        }
        Claims claims=Jwts.parser()
                .setSigningKey(SecurityConstants.SECRET)
                .parseClaimsJws(jwtToken.replace(SecurityConstants.TOKEN_PREFIX, ""))
                .getBody();
        String username=claims.getSubject();
        ArrayList<Map<String,String>> roles=(ArrayList<Map<String,String>>) claims.get("roles");
        Collection<GrantedAuthority> authorities=new ArrayList<>();
        roles.forEach(r->{
        authorities.add(new SimpleGrantedAuthority(r.get("authority")));
        });
        UsernamePasswordAuthenticationToken authenticationUser=new UsernamePasswordAuthenticationToken(username,null, authorities);
        SecurityContextHolder.getContext().setAuthentication(authenticationUser);
        filterChain.doFilter(request, response);
        
    }
    
}
