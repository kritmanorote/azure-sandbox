package com.chill.azuresandbox;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface DummyRepository extends CrudRepository<Dummy, Long> {

  List<Dummy> findByVal(int val);

  Dummy findById(int id);
}