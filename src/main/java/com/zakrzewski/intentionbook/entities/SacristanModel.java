package com.zakrzewski.intentionbook.entities;

import com.zakrzewski.intentionbook.abstractClass.ChurchWorker;
import com.zakrzewski.intentionbook.enums.AccessEnum;

import javax.persistence.Entity;

@Entity
public class SacristanModel extends ChurchWorker {

    public SacristanModel(String firstName, String lastName, AccessEnum accessEnum) {
        super(firstName, lastName, accessEnum);
    }

    public SacristanModel() {
    }
}
