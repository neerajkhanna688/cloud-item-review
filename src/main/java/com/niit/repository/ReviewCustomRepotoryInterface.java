package com.niit.repository;

import java.util.List;

import com.niit.model.ItemReview;

public interface ReviewCustomRepotoryInterface {
	
	public List<ItemReview> getReviewByItemId(Integer id); 

}
