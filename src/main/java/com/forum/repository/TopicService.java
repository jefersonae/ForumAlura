package com.forum.repository;

import com.forum.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicService extends JpaRepository<Topic,Long> {
}
