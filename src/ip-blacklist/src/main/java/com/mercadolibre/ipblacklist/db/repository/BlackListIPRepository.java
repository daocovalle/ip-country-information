package com.mercadolibre.ipblacklist.db.repository;

import org.springframework.data.repository.CrudRepository;

import com.mercadolibre.ipblacklist.db.entity.BlackListIpEntity;

public interface BlackListIPRepository extends CrudRepository<BlackListIpEntity, String> {
	public BlackListIpEntity findByIpNumber(String ip);

}
