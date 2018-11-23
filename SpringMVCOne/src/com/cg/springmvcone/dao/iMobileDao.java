package com.cg.springmvcone.dao;

import java.util.List;

import com.cg.springmvcone.dto.Mobile;

public interface iMobileDao {
	
	public void addMobile(Mobile mobile);
	public List<Mobile>showAllMobile();
	public void deleteMobile(int mobId);
	public Mobile searchMobile(int mobId);
	public void updateMobile(int mobId, double mobPrice);	


}
