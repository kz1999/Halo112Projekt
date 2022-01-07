package com.example.halo112_generic.service.impl;

import com.example.halo112_generic.dao.ActionRepository;
import com.example.halo112_generic.dao.LocationRepository;
import com.example.halo112_generic.dao.ResponderRepository;
import com.example.halo112_generic.dao.TaskRepository;
import com.example.halo112_generic.domain.*;
import com.example.halo112_generic.service.ActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ActionServiceJpa implements ActionService {
    @Autowired
    private ActionRepository actionRepo;
    
    @Autowired
    private ResponderRepository responderRepo;

	@Autowired
	private LocationRepository locationRepo;

	@Autowired
	private TaskRepository taskRepo;

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
    public Action editAction(Action action) {
    	/*
        if(action.getLocation().getId()!=null) actionRepo.editActionLocation(action.getLocation().getId(),id);
        //if(!action.getTasks().isEmpty()) actionRepo.editActionTasks(action.getTasks(),id);
        //if(action.getTeam().isEmpty()) actionRepo.editActionTeam(action.getTeam(),id);
        actionRepo.editActionUrgency(action.getUrgency(),id);
        if(action.getDescription()!=null) actionRepo.editActionDescription(action.getDescription(), id);
        return actionRepo.findActionById(id);
        */
    	
    	return actionRepo.save(action);    
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
	public boolean addTask(Long task_id, Long id) {
		if (actionRepo.existsById(id)) {
			Action action = actionRepo.findById(id).get();
			action.getTasks().add(taskRepo.findById(task_id).get());
			actionRepo.save(action);
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
	public List<String> displayImages(Long id) {
		if (actionRepo.existsById(id)) {
			return actionRepo.findById(id).get().getGallery();
		}
		return null;
	}

	@Override
	public boolean addImage(String imageUrl, Long id) {
		if (actionRepo.existsById(id)) {
			Action action = actionRepo.findById(id).get();
			action.getGallery().add(imageUrl);
			actionRepo.save(action);
			return true;
		}
		return false;
	}

	@Override
	public boolean addComment(Comment comment, Long id) {
		if (actionRepo.existsById(id)) {
			Action action = actionRepo.findById(id).get();
			action.getComments().add(comment);
			actionRepo.save(action);
			return true;
		}
		return false;
	}

	@Override
	public List<Responder> displayResponders(Long id) {
		if (actionRepo.existsById(id)) {
			return actionRepo.findById(id).get().getTeam();
		}
		return null;
	}

	@Override
	public boolean addResponderToAction(Long responder_id, Long id) {
		if (actionRepo.existsById(id)) {
			Action action = actionRepo.findById(id).get();
			action.getTeam().add(responderRepo.findById(responder_id).get());
			actionRepo.save(action);
			return true;
		}
		return false;
	}

	@Override
	public boolean removeResponderFromAction(Long actionID, Long responderID) {
		if (actionRepo.existsById(actionID) && responderRepo.existsById(responderID)) {
			Action action = actionRepo.findById(actionID).get();
			return action.getTeam().remove(responderRepo.findById(responderID).get());
		}
		return false;
	}

	@Override
	public boolean rejectAction(Action action, Long id) {
		if (action != null && action.getTeam() != null) {
			Responder r = null;
			boolean found = false;
			for(var responder : action.getTeam()) {
				if (responder.getId() == id) {
					found = true;
					r = responder;
				}
			}
			
			if (found) {
				List<Responder> team = action.getTeam();
				team.remove(r);
				action.setTeam(team);
				actionRepo.save(action);
				return true;
			}
		}
		return false;
	}

	@Override
	public Location displayLocation(Long id) {
		if (actionRepo.existsById(id)) {
			return actionRepo.findById(id).get().getLocation();
		}
		return null;
	}

	@Override
	public boolean setLocation(Long location_id, Long id) {
		Location location;
		if(locationRepo.existsById(location_id)) {
			System.out.println("EXISTS");
			location = locationRepo.findById(location_id).get();
			Action action = actionRepo.findById(id).get();
			action.setLocation(location);
			actionRepo.save(action);
			return true;
		}
		else return false;

	}

	@Override
	public List<Task> displayTasks(Long id) {
		if (actionRepo.existsById(id)) {
			return actionRepo.findById(id).get().getTasks();
		}
		return null;
	}


}
