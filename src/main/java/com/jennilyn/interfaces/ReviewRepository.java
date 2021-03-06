package com.jennilyn.interfaces;

import com.jennilyn.models.Review;
import com.jennilyn.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends CrudRepository<Review, Long>{
    List<Review> findAllByUser(User user);
}
