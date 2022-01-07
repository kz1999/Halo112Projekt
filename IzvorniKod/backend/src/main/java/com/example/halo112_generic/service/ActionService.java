package com.example.halo112_generic.service;

import com.example.halo112_generic.domain.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface ActionService {
    List<Action> listAll();

    Action createAction(Action action);

    Optional<Action> findById(Long id);

    Action editAction(Action action);

	boolean closeAction(Long id);

	boolean addTask(Long task_id, Long id);

	List<Task> displayTasks(Long id);

	List<Comment> displayComments(Long id);

	List<String> displayImages(Long id);

	boolean addImage(String imageUrl, Long id);

	boolean addComment(Comment comment, Long id);

	List<Responder> displayResponders(Long id);

	boolean addResponderToAction(Long responder_id, Long id);

	boolean removeResponderFromAction(Long actionID, Long responderID);

	boolean rejectAction(Action action, Long id);

	Location displayLocation(Long id);

	boolean setLocation(Long location_id, Long id);
}
