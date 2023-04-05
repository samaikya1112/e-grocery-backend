package com.onlinegrocery.entity;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Embeddable
public class Address {
//	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long addressId;
	private Long housenumber;
	private String street;
	private String landmark;
	private String district;
	private String state;
	private long pin;
	public Long getAddressId() {
		return addressId;
	}
	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}
	public Long getHousenumber() {
		return housenumber;
	}
	public void setHousenumber(Long housenumber) {
		this.housenumber = housenumber;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getLandmark() {
		return landmark;
	}
	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public long getPin() {
		return pin;
	}
	public void setPin(long pin) {
		this.pin = pin;
	}
	public Address() {
		super();
	}
	public Address(Long addressId, Long housenumber, String street, String landmark, String district, String state,
			long pin) {
		super();
		this.addressId = addressId;
		this.housenumber = housenumber;
		this.street = street;
		this.landmark = landmark;
		this.district = district;
		this.state = state;
		this.pin = pin;
	}
	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", housenumber=" + housenumber + ", street=" + street + ", landmark="
				+ landmark + ", district=" + district + ", state=" + state + ", pin=" + pin + "]";
	}
	
}
