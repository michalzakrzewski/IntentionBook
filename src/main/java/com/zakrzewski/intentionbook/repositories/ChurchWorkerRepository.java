package com.zakrzewski.intentionbook.repositories;

import com.zakrzewski.intentionbook.entities.ChurchWorker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChurchWorkerRepository extends JpaRepository<ChurchWorker, Long> {

    ChurchWorker findByWorkerLogin(String workerLogin);
}
