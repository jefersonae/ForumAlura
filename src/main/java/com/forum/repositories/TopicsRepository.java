package com.forum.repositories;

import com.forum.models.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicsRepository extends JpaRepository<Topic, Long>{
    
}
