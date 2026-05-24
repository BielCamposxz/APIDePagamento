package com.gabriel.APIDePagamento.entity;

import com.gabriel.APIDePagamento.objectvalue.TypeUserEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor

// indetifica a classe que vai representar um usuario auteticado
public class UserEntity implements UserDetails {
    private int id;
    private String name;
    private String login;
    private String password;
    private double userBalance;
    private TypeUserEnum TypeUser;

    public void deposit(double value) {
        this.userBalance += value;
    }

    public void withdraw(double value) {
        this.userBalance -= value;
    }

    public static UserEntity CreateNewUser(UserEntity user) {
        return new UserEntity(
                user.getId(),
                user.getName(),
                user.getLogin(),
                user.getPassword(),
                user.getUserBalance(),
                user.getTypeUser()
        );
    }

    // quais as roles do usuario (permicoes)
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(this.TypeUser == TypeUserEnum.Bancario) {
            // isso fala que se o usuario for admin ele vai ter as roles de admin e de user normal
            return List.of(new SimpleGrantedAuthority("ROLE_Bancario"), new SimpleGrantedAuthority("ROLE_Cliente"));
        }
        else return List.of(new SimpleGrantedAuthority("ROLE_Cliente"));
    }

    // aqui seria o login do usuario
    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
