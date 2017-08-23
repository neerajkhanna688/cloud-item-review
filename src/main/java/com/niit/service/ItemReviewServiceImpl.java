package com.niit.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.niit.model.ItemReview;
import com.niit.repository.ItemReviewCrudRepositoryInterface;
import com.niit.repository.ItemReviewRepositoryImpl;


@Service
public class ItemReviewServiceImpl implements ItemReviewServiceInterface {

	@Resource
	private ItemReviewRepositoryImpl itemReviewRepositoryImpl;
	
	@Resource
	private ItemReviewCrudRepositoryInterface itemReviewCrudRepositoryInterface;
	
	@Override
	@HystrixCommand
	public List<ItemReview> getRewiewsById(Integer id) {
		// TODO Auto-generated method stub
		return itemReviewRepositoryImpl.getReviewByItemId(id);
	}
	
	@Override
	@Transactional
	public Iterable<ItemReview> getAllReviews() {
		// TODO Auto-generated method stub
		return itemReviewCrudRepositoryInterface.findAll();
	}


	@Override
	@Transactional
	@HystrixCommand
	public ItemReview saveItemReview(ItemReview itemReview) throws Exception {
		return itemReviewCrudRepositoryInterface.save(itemReview);
		
	}


}
