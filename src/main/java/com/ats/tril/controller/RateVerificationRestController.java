package com.ats.tril.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.tril.common.DateConvertor;
import com.ats.tril.model.RmRateVerificationList; 
import com.ats.tril.repository.RmRateVerificationListRepo; 

@RestController
public class RateVerificationRestController {
	 
	 @Autowired
	 RmRateVerificationListRepo rmRateVerificationListRepo;
	
	@RequestMapping(value = { "/saveRmRateVarification" }, method = RequestMethod.POST)
	public @ResponseBody RmRateVerificationList  saveRmRateVarification(@RequestBody RmRateVerificationList rmRateVerification) {
 
		RmRateVerificationList save = new RmRateVerificationList();

		try {

			 
			save = rmRateVerificationListRepo.save(rmRateVerification);
 
		} catch (Exception e) {
 
			e.printStackTrace();

		}

		return save;

	} 
	
	@RequestMapping(value = { "/rmVarificationListByItemIdAndVendId" }, method = RequestMethod.POST)
	public @ResponseBody RmRateVerificationList  rmVarificationListByItemIdAndVendId(@RequestParam("itemId") int itemId,
			@RequestParam("vendId") int vendId) {
 
		RmRateVerificationList rmVarificationListByItemIdAndVendId = new RmRateVerificationList();

		try {

			 
			rmVarificationListByItemIdAndVendId = rmRateVerificationListRepo.findByRmIdAndSuppId(itemId,vendId);
			
			if(rmVarificationListByItemIdAndVendId==null) {
				rmVarificationListByItemIdAndVendId = new RmRateVerificationList();
				Date date = new Date();
				SimpleDateFormat sf = new SimpleDateFormat("dd-MM-yyyy");
				rmVarificationListByItemIdAndVendId = new RmRateVerificationList();
				rmVarificationListByItemIdAndVendId.setRateDate(sf.format(date));
				rmVarificationListByItemIdAndVendId.setDate1(sf.format(date));
				rmVarificationListByItemIdAndVendId.setDate2(sf.format(date));
			}
			else {
				rmVarificationListByItemIdAndVendId.setRateDate(DateConvertor.convertToDMY(rmVarificationListByItemIdAndVendId.getRateDate()));
				rmVarificationListByItemIdAndVendId.setDate1(DateConvertor.convertToDMY(rmVarificationListByItemIdAndVendId.getDate1()));
				rmVarificationListByItemIdAndVendId.setDate2(DateConvertor.convertToDMY(rmVarificationListByItemIdAndVendId.getDate2()));
			}
 
		} catch (Exception e) {
 
			e.printStackTrace();
			Date date = new Date();
			SimpleDateFormat sf = new SimpleDateFormat("dd-MM-yyyy");
			rmVarificationListByItemIdAndVendId = new RmRateVerificationList();
			rmVarificationListByItemIdAndVendId.setRateDate(sf.format(date));
			rmVarificationListByItemIdAndVendId.setDate1(sf.format(date));
			rmVarificationListByItemIdAndVendId.setDate2(sf.format(date));
		}

		return rmVarificationListByItemIdAndVendId;

	} 
	
	@RequestMapping(value = { "/rmVarificationListByVendId" }, method = RequestMethod.POST)
	public @ResponseBody List<RmRateVerificationList>  rmVarificationListByVendId( @RequestParam("vendId") int vendId) {
 
		List<RmRateVerificationList> rmVarificationListByVendId = new ArrayList<>();

		try {

			 
			rmVarificationListByVendId = rmRateVerificationListRepo.findStsteCodeTaxPerBySuppId(vendId);
			 
 
		} catch (Exception e) {
 
			e.printStackTrace();
			 
		}

		return rmVarificationListByVendId;

	} 

}
