package com.sap.jnc.marketing.persistence.repositories.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sap.jnc.marketing.persistence.models.Wine;

public interface WineRepository extends JpaRepository<Wine, String>{

}
