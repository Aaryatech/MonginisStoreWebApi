package com.ats.tril.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.tril.model.RmRateVerificationList;

public interface RmRateVerificationListRepo extends JpaRepository<RmRateVerificationList, Integer>{

	RmRateVerificationList findByRmIdAndSuppId(int itemId, int vendId);

	List<RmRateVerificationList> findByRmIdAndSuppId(int vendId);

}
