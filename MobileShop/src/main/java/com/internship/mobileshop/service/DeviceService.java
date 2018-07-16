package com.internship.mobileshop.service;

import java.util.List;

import com.internship.mobileshop.model.Device;

public interface DeviceService {
	Boolean createDevice(Device device);

	Boolean updateDeviceQty(Long id, int qty);

	Boolean updateStatus(Long id,String status);
	
	Boolean updateDevice(Device device);

	Boolean deleteDevice(Long id);

	List<Device> searchDevices(String device,Integer offset, Integer maxResult);

	Device getDevice(Long id);

	void indexDevices() throws Exception;

	List<Device> findAll(Integer offset, Integer maxResult);

	Long count();
}
