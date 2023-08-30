package bt.picture_nasa.model.service;


import bt.picture_nasa.model.dto.FeedbackDto;
import bt.picture_nasa.model.entity.Feedback;
import bt.picture_nasa.model.repository.IFeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class FeedbackService implements IFeedbackService {
    @Autowired
    private IFeedbackRepository feedbackRepository;
    @Override
    public List<Feedback> findAll() {

        return feedbackRepository.findAll();
    }

    @Override
    public Feedback findById(Long id) {

        return feedbackRepository.findById(id);
    }
    public void like(Long id){
        Feedback feedback = feedbackRepository.findById(id);
        feedback.setLikes(feedback.getLikes()+1);
        feedbackRepository.save(feedback);
    }

    @Override
    public void save(FeedbackDto feedbackDto) {
        Feedback feedback = new Feedback(feedbackDto.getId(),
                feedbackDto.getRate(),feedbackDto.getAuthor(),
                feedbackDto.getContent(),feedbackDto.getCreationDate(), feedbackDto.getLikes());
        feedbackRepository.save(feedback);
    }

    @Override
    public void delete(Long id) {
        feedbackRepository.delete(id);
    }
}
