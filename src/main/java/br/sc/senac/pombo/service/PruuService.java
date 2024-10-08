package br.sc.senac.pombo.service;

package com.pruu.pombo.service;

import br.sc.senac.pombo.exception.PomboException;
import br.sc.senac.pombo.model.entity.Pruu;
import br.sc.senac.pombo.model.entity.User;
import br.sc.senac.pombo.model.repository.PruuRepository;
import br.sc.senac.pombo.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
public class PruuService {

    @Autowired
    private PruuRepository pruuRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Pruu> findAll() {
        return pruuRepository.findAll();
    }

    public Pruu findById(String id) {
        return pruuRepository.findById(id).orElse(null);
    }

    //public Set<Pruu> fetchByUserId(UUID userId) {
    //  return pruuRepository.findByUserId(userId);
    //}

    public Pruu create(Pruu pruu) throws PomboException {
        verifyIfUserExists(pruu);

        return pruuRepository.save(pruu);
    }

    public void like(UUID userId, UUID pruuId) {
        Pruu pruu = pruuRepository.findById(pruuId.toString()).orElse(null);
        Set<User> likes = pruu.getLikes();
        User user = userRepository.findById(userId.toString()).orElse(null);

        if(likes.contains(user)) {
            likes.remove(user);
        } else {
            likes.add(user);
        }

        pruu.setLikes(likes);
        pruuRepository.save(pruu);
    }

    public void verifyIfUserExists(Pruu pruu) throws PomboException {
        User user = userRepository.findById(pruu.getUser().getId()).orElse(null);

        if(user == null) {
            throw new PomboException("Usuário não existente.");
        }
    }

}