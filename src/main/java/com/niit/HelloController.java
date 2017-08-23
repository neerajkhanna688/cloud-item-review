package com.niit;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.model.ItemReview;
import com.niit.service.ItemReviewServiceInterface;

@RestController
public class HelloController {
  
	@Autowired
	private ItemReviewServiceInterface itemReviewService;
	
    @RequestMapping("/")
    String hello() {
        return "Hello World!";
    }

    @RequestMapping(method= RequestMethod.GET, value="/itemreview/{id}")
    public List<ItemReview> getReviews(@PathVariable("id") Integer id)  {
    	return itemReviewService.getRewiewsById(id);
    }

    @RequestMapping(method= RequestMethod.GET, value="/itemreviews")
    public Iterable<ItemReview> getAllReviews()  {
    	return itemReviewService.getAllReviews();
    }
	@RequestMapping(method=RequestMethod.POST, value="/itemreview/create")
	public void addItem(@RequestBody ItemReview itemReview) throws Exception{
		itemReviewService.saveItemReview(itemReview);
	}

}
