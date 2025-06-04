package com.example.BroadcastSystem.repo;

import com.example.BroadcastSystem.model.BroadcastMessage;
import org.apache.logging.log4j.message.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

@EnableJpaRepositories
public interface BroadcastMessageRepo extends JpaRepository<BroadcastMessage, Long> {

}
