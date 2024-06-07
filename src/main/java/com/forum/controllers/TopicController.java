package com.forum.controllers;

import com.forum.dtos.RequestTopicDTO;
import com.forum.dtos.ResponseTopicDTO;
import com.forum.services.TopicServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/topics")
public class TopicController {

    @Autowired
    private TopicServices services;

    @GetMapping("/")
    public ResponseEntity<Page<ResponseTopicDTO>> getTopicList(Pageable pageable) {
        return ResponseEntity.ok().body(services.getTopicList(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseTopicDTO> getTopic(@PathVariable Long id) {
        return ResponseEntity.ok().body(services.getTopic(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTopic(@PathVariable Long id) {
        services.deleteTopic(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/")
    public ResponseEntity<ResponseTopicDTO> saveTopic(@RequestBody RequestTopicDTO requestTopicDTO) {
        ResponseTopicDTO responseTopicDTO = services.saveTopic(requestTopicDTO);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(responseTopicDTO.id())
                .toUri();
        return ResponseEntity.created(location).body(responseTopicDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseTopicDTO> updateTopic(@PathVariable Long id,
            @RequestBody RequestTopicDTO requestTopicDTO) {
        return ResponseEntity.ok().body(services.updateTopic(id, requestTopicDTO));
    }
}
