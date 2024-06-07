package com.forum.mappers;

import com.forum.dtos.RequestTopicDTO;
import com.forum.dtos.ResponseTopicDTO;
import com.forum.models.Topic;
import org.springframework.data.domain.Page;


public class TopicMapper {

    public static Topic fromDTO(RequestTopicDTO requestTopicDTO) {
        return new Topic(requestTopicDTO.title(), requestTopicDTO.course(), requestTopicDTO.message());
    }

    public static ResponseTopicDTO toDTO(Topic topic) {
        return new ResponseTopicDTO(topic.getId(), topic.getTitle(), topic.getMessage(), topic.getCreationDateTime());
    }

    public static Page<ResponseTopicDTO> toDTO(Page<Topic> topics) {
        return topics
                .map(topic -> toDTO(topic));
    }
}
