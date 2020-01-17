package com.zakrzewski.intentionbook.repositories;

import com.zakrzewski.intentionbook.entities.SacristanModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SacristianRepository extends JpaRepository <SacristanModel, Long> {
}
