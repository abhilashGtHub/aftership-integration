package com.abhi.poc.demo.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * checkpoint pojo class
 * 
 * @author agalipally
 *
 */
public class Checkpoint {
	public String slug;
	public String city;
	public Date created_at;
	public String location;
	public String country_name;
	public String message;
	public String country_iso3;
	public String tag;
	public String subtag;
	public String subtag_message;
	public Date checkpoint_time;
	public List<String> coordinates;
	public String state;
	public String zip;

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCountry_name() {
		return country_name;
	}

	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCountry_iso3() {
		return country_iso3;
	}

	public void setCountry_iso3(String country_iso3) {
		this.country_iso3 = country_iso3;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getSubtag() {
		return subtag;
	}

	public void setSubtag(String subtag) {
		this.subtag = subtag;
	}

	public String getSubtag_message() {
		return subtag_message;
	}

	public void setSubtag_message(String subtag_message) {
		this.subtag_message = subtag_message;
	}

	public Date getCheckpoint_time() {
		return checkpoint_time;
	}

	public void setCheckpoint_time(Date checkpoint_time) {
		this.checkpoint_time = checkpoint_time;
	}

	public List<String> getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(List<String> coordinates) {
		this.coordinates = new ArrayList<>(coordinates);
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getRaw_tag() {
		return raw_tag;
	}

	public void setRaw_tag(String raw_tag) {
		this.raw_tag = raw_tag;
	}

	public String raw_tag;
}