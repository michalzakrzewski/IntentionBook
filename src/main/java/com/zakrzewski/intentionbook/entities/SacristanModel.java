package com.zakrzewski.intentionbook.entities;

import com.zakrzewski.intentionbook.abstractClass.ChurchWorker;
import com.zakrzewski.intentionbook.enums.AccessEnum;

import javax.persistence.Entity;

@Entity
public class SacristanModel extends ChurchWorker {

    public SacristanModel(String workerLogin, String workerPassword, String firstName, String lastName, String accessEnum) {
        super(workerLogin, workerPassword, firstName, lastName, accessEnum);
    }

    public SacristanModel() {
    }
}
