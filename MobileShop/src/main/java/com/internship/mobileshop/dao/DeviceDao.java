package com.internship.mobileshop.dao;

import java.util.List;

import com.internship.mobileshop.model.Device;

public interface DeviceDao {
	Boolean createDevice(Device device);

	Boolean updateDeviceQty(Long id, int qty);
	
	Boolean updateStatus(Long id,String status);

	Boolean deleteDevice(Long id);

	Boolean updateDevice(Device device);

	List<Device> searchDevices(String device,Integer offset, Integer maxResult);

	List<Device> findAll(Integer offset, Integer maxResult);

	Long count();

	void indexDevices() throws Exception;

	Device getDevice(Long id);
}
