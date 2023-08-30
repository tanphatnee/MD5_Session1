package bt.picture_nasa.model.service;

import bt.picture_nasa.model.dto.FeedbackDto;
import bt.picture_nasa.model.entity.Feedback;

import java.util.List;

public interface IFeedbackService {
    List<Feedback> findAll();
    Feedback findById(Long id);
    void save(FeedbackDto feedbackDto);
    void delete(Long id);
    void like(Long id);
}
