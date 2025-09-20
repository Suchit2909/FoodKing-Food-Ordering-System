package com.foodKing.demoFoodking.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodKing.demoFoodking.bean.AddressRequest;
import com.foodKing.demoFoodking.entity.Address;
import com.foodKing.demoFoodking.entity.User;
import com.foodKing.demoFoodking.repository.AddressRepository;
import com.foodKing.demoFoodking.services.AddressService;

@Service
public class AddressServiceImpl implements AddressService{
	
	@Autowired
	private AddressRepository addressRepository;
	

	@Override
	public Address addAddress(User user, AddressRequest addressRequest) {
	Address address = Address.builder()
			.fullName(addressRequest.getFullName())
			.street(addressRequest.getStreet())
            .city(addressRequest.getCity())
            .state(addressRequest.getState())
            .pinCode(addressRequest.getPinCode())
            .phone(addressRequest.getPhone())
            .user(user)
            .build();
		return addressRepository.save(address);
	}

	@Override
	public List<Address> getAllAddresses(User user) {
		// TODO Auto-generated method stub
		return addressRepository.findByUser(user);
	}

	@Override
	public void deleteAddress(User user, Long AddressId) {
		// TODO Auto-generated method stub
		
		Address address =addressRepository.findById(AddressId)
				.orElseThrow(()-> new RuntimeException("Address Not Found"));
		
		if(!address.getUser().getId().equals(user.getId())) {
			 throw new RuntimeException("Unauthorized to delete this address");
		}
		
		addressRepository.delete(address);
		
	}
	

}
