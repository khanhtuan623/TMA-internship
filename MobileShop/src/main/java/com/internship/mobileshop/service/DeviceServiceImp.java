package com.internship.mobileshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.internship.mobileshop.dao.DeviceDao;
import com.internship.mobileshop.model.Device;

@Service
@Transactional
public class DeviceServiceImp implements DeviceService{
	
	@Autowired
	private DeviceDao deviceDao;
	
	@Override
	public Boolean createDevice(Device device) {
		// TODO Auto-generated method stub
		return deviceDao.createDevice(device);
	}

	@Override
	public Boolean updateDeviceQty(Long id, int qty) {
		// TODO Auto-generated method stub
		return deviceDao.updateDeviceQty(id, qty);
	}

	@Override
	public Boolean deleteDevice(Long id) {
		// TODO Auto-generated method stub
		return deviceDao.deleteDevice(id);
	}

	@Override
	public List<Device> searchDevices(String device,Integer offset, Integer maxResult) {
		// TODO Auto-generated method stub
		return deviceDao.searchDevices(device,offset,maxResult);
	}

	@Override
	public Boolean updateDevice(Device device) {
		
		return deviceDao.updateDevice(device);
	}

	@Override
	public Device getDevice(Long id) {
		// TODO Auto-generated method stub
		return deviceDao.getDevice(id);
	}

	@Override
	public List<Device> findAll(Integer offset, Integer maxResult) {
		// TODO Auto-generated method stub
		return deviceDao.findAll(offset, maxResult);
	}

	@Override
	public Long count() {
		// TODO Auto-generated method stub
		return deviceDao.count();
	}

	@Override
	public void indexDevices() throws Exception {
		// TODO Auto-generated method stub
		deviceDao.indexDevices();
	}

	@Override
	public Boolean updateStatus(Long id, String status) {
		// TODO Auto-generated method stub
		return deviceDao.updateStatus(id, status);
	}
	
	
}
