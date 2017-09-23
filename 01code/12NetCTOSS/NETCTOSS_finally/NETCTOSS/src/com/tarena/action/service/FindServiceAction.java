package com.tarena.action.service;

import java.util.List;

import com.tarena.dao.DAOException;
import com.tarena.dao.DAOFactory;
import com.tarena.vo.ServiceVO;

public class FindServiceAction {

	private String osUserName;
	private String unixHost;
	private String idCardNo;
	private String status = "-1";

	private int page = 1;
	private int pageSize;
	private int totalPages;

	private List<ServiceVO> services;

	public String execute() {
		try {
			services = DAOFactory.getServiceDAO().findByCondition(osUserName,
					unixHost, idCardNo, status, page, pageSize);
			totalPages = DAOFactory.getServiceDAO().findTotalPage(osUserName,
					unixHost, idCardNo, status, pageSize);
		} catch (DAOException e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}

	public List<ServiceVO> getServices() {
		return services;
	}

	public void setServices(List<ServiceVO> services) {
		this.services = services;
	}

	public String getIdCardNo() {
		return idCardNo;
	}

	public void setIdCardNo(String idCardNo) {
		this.idCardNo = idCardNo;
	}

	public String getOsUserName() {
		return osUserName;
	}

	public void setOsUserName(String osUserName) {
		this.osUserName = osUserName;
	}

	public String getUnixHost() {
		return unixHost;
	}

	public void setUnixHost(String unixHost) {
		this.unixHost = unixHost;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getPage() {
		return page;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

}
