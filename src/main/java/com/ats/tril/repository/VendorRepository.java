package com.ats.tril.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional; 

import com.ats.tril.model.Vendor;

public interface VendorRepository extends JpaRepository<Vendor, Integer>{

	Vendor findByVendorId(int vendorId);

	List<Vendor> findAllByIsUsed(int i);

	
	@Transactional
	@Modifying
	@Query("UPDATE Vendor SET isUsed=0 ,deleted_in=:deletedIn WHERE vendor_id=:vendorId")
	int deleteVendor(@Param("vendorId") int vendorId, @Param("deletedIn") int deletedIn);

	@Query(value=("select * from m_vendor where vendor_code = (select max(vendor_code) from m_vendor where vendor_code LIKE :str%)"),nativeQuery=true)
	Vendor getNextVendorNo(@Param("str") String str);

	@Query(value=("select * from m_vendor where vendor_id in (select supp_id from m_rm_rate_verif where rm_id in (select item_id from indtrans where ind_m_id =:indId and del_status=1))"),nativeQuery=true)
	List<Vendor> getVendorByIndendId(@Param("indId")int indId);
 
	
}
