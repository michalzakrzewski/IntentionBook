package com.zakrzewski.intentionbook.entities;

import com.zakrzewski.intentionbook.abstractClass.ChurchWorker;
import com.zakrzewski.intentionbook.enums.AccessEnum;

import javax.persistence.Entity;

@Entity
public class PriestModel extends ChurchWorker {

    public PriestModel(String firstName, String lastName, AccessEnum accessEnum) {
        super(firstName, lastName, accessEnum);
    }

    public PriestModel() {
    }
}
