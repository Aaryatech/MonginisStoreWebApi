package com.ats.tril.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.tril.model.OpeningStockModel;
 



public interface AddOpeningStock extends JpaRepository<OpeningStockModel, Integer>
{
	@Query(value = "SELECT m_item.item_id, m_item.item_code, m_item.item_desc,m_item.item_uom,m_item.item_uom2,m_item.item_op_rate,m_item.item_op_qty,m_tax_form.tax_desc,m_tax_form.cgst_per,m_tax_form.sgst_per,m_tax_form.igst_per FROM `m_item`,m_tax_form WHERE m_item.cat_id=:cat_id AND m_item.item_is_capital=m_tax_form.tax_id", nativeQuery = true)
	/*@Query(value = "SELECT\r\n" + 
			"        m_item.item_id,\r\n" + 
			"        m_item.item_code,\r\n" + 
			"        m_item.item_desc,\r\n" + 
			"        m_item.item_uom,\r\n" + 
			"        m_item.item_uom2,\r\n" + 
			"        m_item.item_op_rate,\r\n" + 
			"        m_item.item_op_qty,\r\n" + 
			"        m_tax_form.tax_desc,\r\n" + 
			"        m_tax_form.cgst_per,\r\n" + 
			"        m_tax_form.sgst_per,\r\n" + 
			"        m_tax_form.igst_per \r\n" + 
			"    FROM\r\n" + 
			"        `m_item`,\r\n" + 
			"        m_tax_form,\r\n" + 
			"        m_rm_rate_verif,\r\n" + 
			"        m_vendor\r\n" + 
			"    WHERE\r\n" + 
			"        m_item.cat_id=1 \r\n" + 
			"        AND m_item.item_is_capital=m_tax_form.tax_id and m_rm_rate_verif.rm_id=m_item.item_id and m_vendor.vendor_id=m_rm_rate_verif.supp_id and m_rm_rate_verif.supp_id=1", nativeQuery = true)*/
	List<OpeningStockModel> getIteminfoOPeningStock(@Param("cat_id") int cat_id);
}
