package com.example.halo112_generic.service.impl;

import com.example.halo112_generic.dao.ActionRepository;
import com.example.halo112_generic.dao.ResponderRepository;
import com.example.halo112_generic.domain.Action;
import com.example.halo112_generic.domain.Comment;
import com.example.halo112_generic.domain.Task;
import com.example.halo112_generic.service.ActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ActionServiceJpa implements ActionService {
    @Autowired
    private ActionRepository actionRepo;

    @Override
    public List<Action> listAll() {
        return actionRepo.findAll();
    }

    @Override
    public Action createAction(Action action) {
        return actionRepo.save(action);
    }

    @Override
    public Optional<Action> findById(Long id) {
        return actionRepo.findActionById(id);
    }

    @Override
    public Optional<Action> editAction(Long id, Action action) {
        if(action.getLocation().getId()!=null) actionRepo.editActionLocation(action.getLocation().getId(),id);
        //if(!action.getTasks().isEmpty()) actionRepo.editActionTasks(action.getTasks(),id);
        //if(action.getTeam().isEmpty()) actionRepo.editActionTeam(action.getTeam(),id);
        actionRepo.editActionUrgency(action.getUrgency(),id);
        if(action.getDescription()!=null) actionRepo.editActionDescription(action.getDescription(), id);
        return actionRepo.findActionById(id);
    }

	@Override
	public boolean closeAction(Long id) {
		if (actionRepo.existsById(id)) {
			actionRepo.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public boolean addTask(Task task, Long id) {
		if (actionRepo.existsById(id)) {
			actionRepo.findById(id).ifPresent(x -> x.getTasks().add(task));;
			return true;
		}
		return false;
	}

	@Override
	public List<Comment> displayComments(Long id) {
		if (actionRepo.existsById(id)) {
			return actionRepo.findById(id).get().getComments();
		}
		return null;
	}

	@Override
	public boolean addImage(String imageUrl, Long id) {
		if (actionRepo.existsById(id)) {
			actionRepo.findById(id).get().getGallery().add(imageUrl);
			return true;
		}
		return false;
	}

	@Override
	public boolean addComment(Comment comment, Long id) {
		if (actionRepo.existsById(id)) {
			actionRepo.findById(id).get().getComments().add(comment);
			return true;
		}
		return false;
	}
}
