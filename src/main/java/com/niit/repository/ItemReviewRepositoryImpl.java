package com.niit.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.niit.model.ItemReview;

@Repository
public class ItemReviewRepositoryImpl implements ReviewCustomRepotoryInterface {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<ItemReview> getReviewByItemId(Integer id) {
		// TODO Auto-generated method stub
		System.out.println("  ID to fetch review  "+ id);
		
		List resultList = entityManager.createQuery("select ir from ItemReview ir where ir.itemId ="+ id).getResultList();
		System.out.println( "        result from database "+ resultList.size() );
		return resultList;
	}

}
 