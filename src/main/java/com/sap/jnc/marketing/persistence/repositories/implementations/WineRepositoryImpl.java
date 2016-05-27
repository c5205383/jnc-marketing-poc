package com.sap.jnc.marketing.persistence.repositories.implementations;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;

import com.sap.jnc.marketing.persistence.models.Wine;
import com.sap.jnc.marketing.persistence.repositories.interfaces.WineRepository;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class WineRepositoryImpl extends SimpleJpaRepository<Wine, String>implements WineRepository {

	@Autowired
	public WineRepositoryImpl(EntityManager em) {
		super(Wine.class, em);
	}
}
