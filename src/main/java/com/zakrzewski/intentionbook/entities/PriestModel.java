package com.zakrzewski.intentionbook.entities;

import com.zakrzewski.intentionbook.abstractClass.ChurchWorker;
import com.zakrzewski.intentionbook.enums.AccessEnum;

import javax.persistence.Entity;

@Entity
public class PriestModel extends ChurchWorker {

    public PriestModel(String workerLogin, String workerPassword, String firstName, String lastName, AccessEnum accessEnum) {
        super(workerLogin, workerPassword, firstName, lastName, accessEnum);
    }

    public PriestModel() {
    }
}
