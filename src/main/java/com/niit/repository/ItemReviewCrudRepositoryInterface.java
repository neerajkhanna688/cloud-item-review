package com.niit.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.niit.model.ItemReview;

@Repository
public interface ItemReviewCrudRepositoryInterface extends CrudRepository<ItemReview, Integer>, ReviewCustomRepotoryInterface {

}
