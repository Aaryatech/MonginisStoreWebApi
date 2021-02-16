package com.ats.tril.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.tril.model.ApproveBy;

public interface ApproveByRepo extends JpaRepository<ApproveBy, Integer> {

	List<ApproveBy> findByDelStatusOrderByApprovByIdDesc(int del);
	
	ApproveBy findByApprovById(int apprvId);
	
	@Transactional
	@Modifying
	@Query(value="UPDATE `m_approve_by` SET del_status=1 WHERE approv_by_id=:apprvId", nativeQuery=true)
	int deleteApproveBy(@Param("apprvId") int apprvId);
}
