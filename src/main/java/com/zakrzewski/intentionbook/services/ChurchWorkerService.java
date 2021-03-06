package com.zakrzewski.intentionbook.services;

import com.zakrzewski.intentionbook.entities.ChurchWorker;
import com.zakrzewski.intentionbook.enums.AccessEnum;
import com.zakrzewski.intentionbook.repositories.ChurchWorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ChurchWorkerService {

    private ChurchWorkerRepository churchWorkerRepository;

    @Autowired
    public ChurchWorkerService(ChurchWorkerRepository churchWorkerRepository) {
        this.churchWorkerRepository = churchWorkerRepository;
    }

    public List<ChurchWorker> getAllChurchWorker(){
        List<ChurchWorker> allChurchWorkers = churchWorkerRepository.findAll();
        Collections.sort(allChurchWorkers, Comparator.comparing(ChurchWorker::getLastName).thenComparing(ChurchWorker::getAccessEnum));
        return allChurchWorkers;
    }

    public List<ChurchWorker> getAllSacristian(){
        List<ChurchWorker> workerList = churchWorkerRepository.findAll();
        workerList =  workerList.stream().filter(sacristian -> sacristian.getAccessEnum().equals(AccessEnum.USER_ZAKRYS.getRoleDescription())).collect(Collectors.toList());
        return workerList;
    }

    public List<ChurchWorker> getAllPriest(){
        List<ChurchWorker> workerList = churchWorkerRepository.findAll();
        workerList = workerList.stream().filter(priest -> priest.getAccessEnum().equals(AccessEnum.USER_KAPLAN.getRoleDescription())).collect(Collectors.toList());
        return workerList;
    }

    public ChurchWorker addNewChurchWorker(ChurchWorker churchWorker){
        churchWorker.setWorkerPassword(new BCryptPasswordEncoder().encode(churchWorker.getWorkerPassword()));
        churchWorker.setFullName(churchWorker.concatName());
        return churchWorkerRepository.save(churchWorker);
    }

    public void deleteChurchWorker(Long id){
        churchWorkerRepository.deleteById(id);
    }
}
