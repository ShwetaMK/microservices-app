package com.smk.store.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.smk.store.model.Store;

@Repository
public interface StoreRepository extends CrudRepository<Store, Long> {

}
