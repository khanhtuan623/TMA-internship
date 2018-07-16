package com.internship.mobileshop.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.internship.mobileshop.model.Device;
import com.internship.mobileshop.model.InforPayment;
import com.internship.mobileshop.model.Invoice;
import com.internship.mobileshop.model.Login;
import com.internship.mobileshop.service.DeviceService;
import com.internship.mobileshop.service.InvoiceService;

@Controller
public class MobileController {

	@Autowired
	private DeviceService deviceService;

	// @Autowired
	// private BankAccountService bankAccountService;

	@Autowired
	private InvoiceService invoiceService;

	@RequestMapping(value = "/")
	public String main(Model model) {
		// model.addAttribute("device", new Device());
		return "redirect:/Home";
	}

	@RequestMapping(value = "/New-Device")
	public String show(Model model) {
		model.addAttribute("device", new Device());
		return "SaveDevice";
	}

	/*-----GET ALL DEVICE AT VIEW ADMIN-----*/
	@RequestMapping(value = "/Home-Admin")
	public String findAllAtHome(Model model, Integer offset, Integer maxResults) {
		List<Device> listDevices = deviceService.findAll(offset, maxResults);
		model.addAttribute("count", deviceService.count());
		model.addAttribute("offset", offset);
		model.addAttribute("listDevices", listDevices);
		return "HomeAdmin";
	}

	/*----GET ALL DEVICE AT HOME PAGE---*/
	@RequestMapping(value = "/Home", method = RequestMethod.GET)
	public String findAll(Model model, Integer offset, Integer maxResults) {
		try {
			deviceService.indexDevices();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Device> listDevices = deviceService.findAll(offset, maxResults);
		model.addAttribute("count", deviceService.count());
		model.addAttribute("offset", offset);
		model.addAttribute("listDevices", listDevices);
		return "Home";
	}

	/*----Add New Device-----*/
	@RequestMapping(value = "/Save", method = RequestMethod.POST)
	public String saveUser(@Validated @ModelAttribute("device") Device device) {
		if (this.deviceService.createDevice(device) == true) {
			System.out.println("Brand: " + device.getBrand());
			System.out.println("Name: " + device.getName());
			System.out.println("Color: " + device.getColor());
			return "redirect:/Home-Admin";
		} else {
			System.out.println("Brand: " + device.getBrand());
			System.out.println("Name: " + device.getName());
			System.out.println("Color: " + device.getColor());
			return "redirect:/New-Device";
		}
	}

	/*----DELETE---------*/
	@RequestMapping(value = "/Delete-Device/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable long id) {
		this.deviceService.deleteDevice(id);
		return "redirect:/Home-Admin";
	}

	/*---SHOW LOGIN-------*/
	@RequestMapping(value = "/Login")
	public String showLogin(Model model) {
		model.addAttribute("login", new Login());
		return "Login";
	}

	/*----CHECK LOGIN TRUE OR FASLE*/
	@RequestMapping(value = "/Check-Login", method = RequestMethod.POST)
	public String checkLogin(@Validated @ModelAttribute("login") Login login) {
		if (login.getUserName().equals("admin") && login.getPassWord().equals("admin"))
			return "redirect:/Home-Admin";
		return "redirect:/Login";
	}

	/*---GET DEVICE BY ID---------*/
	@RequestMapping(value = "/Get-Device/{id}")
	public String getDevice(@PathVariable Long id, Model model) {
		Device device = this.deviceService.getDevice(id);
		model.addAttribute("device", device);
		return "EditDevice";
	}

	/*----SEARCH-----*/
	@RequestMapping(value = "/Search-Device")
	public String searchDevice(@RequestParam(value = "search", required = false) String search, Model model,
			Integer offset, Integer maxResult) {
		try {
			List<Device> listDevices = this.deviceService.searchDevices(search, offset, maxResult);
			model.addAttribute("count", deviceService.count());
			model.addAttribute("offset", offset);
			model.addAttribute("listDevices", listDevices);
			return "Home";
		} catch (Exception e) {
			return "redirect:/Home";
			// TODO: handle exception
		}

	}

	/*----Tab-----*/
	@RequestMapping(value = "/Tab/{tab}")
	public String tabDevice(@PathVariable String tab, Model model, Integer offset, Integer maxResult) {
		try {
			List<Device> listDevices = this.deviceService.searchDevices(tab, offset, maxResult);
			model.addAttribute("count", deviceService.count());
			model.addAttribute("offset", offset);
			model.addAttribute("listDevices", listDevices);
			return "Home";
		} catch (Exception e) {
			return "redirect:/Home";
			// TODO: handle exception
		}

	}

	/* SAVE DEVICE AFTER EDIT */
	@RequestMapping(value = "/Edit-Save", method = RequestMethod.POST)
	public String saveEdit(@ModelAttribute("device") Device device) {
		if (this.deviceService.updateDevice(device) == true) {
			return "redirect:/Home-Admin";
		}
		return null;
	}

	/*---Buy Device----*/
	@RequestMapping(value = "/Buy-Device/{id}")
	public String buyDevice(@PathVariable Long id, Model model) {
		Device device = this.deviceService.getDevice(id);
		model.addAttribute("device", device);
		model.addAttribute("inforPayment", new InforPayment());
		return "Infor";
	}

	/*----CHECK PAYMENT-----*/
	@RequestMapping(value = "/Check-Payment", method = RequestMethod.POST)
	public String checkPayment(@ModelAttribute("inforPayment") InforPayment info ,Model model,Integer offset, Integer maxResults) {
		String paymentURl = new String("http://localhost:8888/payment");
		HttpHeaders headers = new HttpHeaders();
		headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.setContentType(MediaType.APPLICATION_JSON);
		if (info.getQty() > 0) {
			try {
				RestTemplate rt = new RestTemplate();
				rt.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
				rt.getMessageConverters().add(new StringHttpMessageConverter());

				HttpHeaders httpHeaders = new HttpHeaders();
				httpHeaders.set("Content-Type", "application/json");

				JSONObject json = new JSONObject();
				json.put("name", info.getNameCard());
				json.put("numberCard", info.getNumberCard());
				json.put("cvc", info.getSecurityCard());
				json.put("expDate", info.getExpDate());
				json.put("price", info.getPrice());
				HttpEntity<String> httpEntity = new HttpEntity<String>(json.toString(), httpHeaders);

				String response = rt.postForObject(paymentURl, httpEntity, String.class);

				JSONObject jsonObj = new JSONObject(response);
				long idHisBank=jsonObj.getLong("id");
				String name=jsonObj.getString("name").toString();
				int price=jsonObj.getInt("price");
				String date=jsonObj.getString("datePayment").toString();
				
				System.out.println("Successfull");
				int updateQty = info.getQty() - 1;
				this.deviceService.updateDeviceQty(info.getIdDevice(), updateQty);
				if(updateQty==0) {
					this.deviceService.updateStatus(info.getIdDevice(), "Unvailable");
				}
				Invoice invoice = new Invoice();
				invoice.setIdDevice(info.getIdDevice());
				invoice.setIdHisBank(idHisBank);
				invoice.setNameCustomer(info.getName());
				invoice.setPhoneCustomer(info.getPhone());
				invoice.setQuantity(1);
				invoice.setTotal(info.getPrice());
				invoice.setAddressCustomer(info.getAddress());
				invoice.setDate(this.getNow());
				this.invoiceService.createInvoice(invoice);
				InforPayment infoConfirm=new InforPayment(name, info.getPhone(), info.getEmail(), info.getAddress(), info.getBrandDevice(), info.getNameDevice(), info.getColorDevice(), info.getMemoryDevice(), price, date);
				model.addAttribute("result",1);
				model.addAttribute("confirm", infoConfirm);
				return "Confirm";
			} catch (Exception e) {
				e.printStackTrace();
				model.addAttribute("result",0);
				return "Confirm";
			}
		}
		return "redirect:/Home";
	}

	private String getNow() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		return formatter.format(date).toString();
	}
}
