package com.niit.service;

import java.util.List;

import com.niit.model.ItemReview;
public interface ItemReviewServiceInterface {
	public List<ItemReview> getRewiewsById(Integer id);
	public Iterable<ItemReview> getAllReviews();
	 public ItemReview saveItemReview(ItemReview itemReview) throws Exception;
}




