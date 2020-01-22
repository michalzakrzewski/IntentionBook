package com.zakrzewski.intentionbook.services;

import com.zakrzewski.intentionbook.abstractClass.ChurchWorker;
import com.zakrzewski.intentionbook.enums.AccessEnum;
import com.zakrzewski.intentionbook.repositories.ChurchWorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChurchWorkerServiceImpl {

    private ChurchWorkerRepository churchWorkerRepository;

    @Autowired
    public ChurchWorkerServiceImpl(ChurchWorkerRepository churchWorkerRepository) {
        this.churchWorkerRepository = churchWorkerRepository;
    }

    public List<ChurchWorker> getAllChurchWorker(){
        return churchWorkerRepository.findAll();
    }

    public List<ChurchWorker> getAllSacristian(){
        List<ChurchWorker> workerList = churchWorkerRepository.findAll();
        workerList =  workerList.stream().filter(sacristian -> sacristian.getAccessEnum().equals(AccessEnum.USER_ZAKRYS)).collect(Collectors.toList());
        return workerList;
    }

    public List<ChurchWorker> getAllPriest(){
        List<ChurchWorker> workerList = churchWorkerRepository.findAll();
        workerList = workerList.stream().filter(priest -> priest.getAccessEnum().equals(AccessEnum.USER_KAPLAN)).collect(Collectors.toList());
        return workerList;
    }
}
