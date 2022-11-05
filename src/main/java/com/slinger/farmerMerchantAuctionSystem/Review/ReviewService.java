package com.slinger.farmerMerchantAuctionSystem.Review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {
    ReviewRepository reviewRepository;
    @Autowired
    public ReviewService(ReviewRepository reviewRepository){
        this.reviewRepository=reviewRepository;
    }

    public Review createNewReview(Review reviewDetail){
        return reviewRepository.save(reviewDetail);
    }
    public List<Review> getAllReviews(){
        return reviewRepository.findAll();
    }
    public Review getReviewById(Integer reviewId){
        Review review=reviewRepository.findById(reviewId).orElseThrow(
                ()-> {
                    throw new IllegalStateException("review with id "+reviewId+" does not exist");
                }
        );
        return review;
    }
    public Review updateReviewById(Integer reviewId,Review reviewDetail){
        Review review=reviewRepository.findById(reviewId).orElseThrow(
                 ()-> {
                    throw new IllegalStateException("review with id "+reviewId+" does not exist");
                }
                );
        review.setReviewFarmerId(reviewDetail.getReviewFarmerId());
        review.setReviewMerchantId(reviewDetail.getReviewMerchantId());
        review.setReviewMessage(reviewDetail.getReviewMessage());
        review.setReviewRatings(reviewDetail.getReviewRatings());
        return review;
    }
    public void deleteReviewById(Integer reviewId){
        reviewRepository.deleteById(reviewId);
    }

}
