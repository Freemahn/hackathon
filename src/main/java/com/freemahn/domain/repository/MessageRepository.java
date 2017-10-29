package com.freemahn.domain.repository;

import com.freemahn.domain.entity.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Message, Long> {
}