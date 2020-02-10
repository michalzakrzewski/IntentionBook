package com.zakrzewski.intentionbook.services;

import com.zakrzewski.intentionbook.abstractClass.ChurchWorker;
import com.zakrzewski.intentionbook.repositories.ChurchWorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ChurchWorkerDetailsServiceImpl implements UserDetailsService {

    private ChurchWorkerRepository churchWorkerRepository;

    @Autowired
    public ChurchWorkerDetailsServiceImpl(ChurchWorkerRepository churchWorkerRepository) {
        this.churchWorkerRepository = churchWorkerRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        ChurchWorker user = churchWorkerRepository.findByWorkerLogin(s);
        if (user == null){
            throw new UsernameNotFoundException("Username not found");
        }else {
            return churchWorkerRepository.findByWorkerLogin(s);
        }
    }
}
