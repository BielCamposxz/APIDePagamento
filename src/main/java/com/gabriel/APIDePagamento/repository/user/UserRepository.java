package com.gabriel.APIDePagamento.repository.user;

import com.gabriel.APIDePagamento.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Repository
public class UserRepository implements IUserRepository {
    List<UserEntity> users = new LinkedList<>();

    public void saveUser(UserEntity user)
    {
        this.users.add(user);
    }

    public List<UserEntity> getAllUsers() {
        return this.users;
    }

    public UserEntity getUserById(int userId) {
        return this.users.stream().filter(x -> x.getId() == userId).findFirst().orElse(null);
    }

    public UserEntity findUserByLogin(String login) {
        return this.users.stream()
                .filter(x -> x.getLogin().equals(login))
                .findFirst()
                .orElse(null);
    }
}
