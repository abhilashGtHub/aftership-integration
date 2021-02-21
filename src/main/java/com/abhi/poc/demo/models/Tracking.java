package com.abhi.poc.demo.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * tracking pojo class
 *  
 * @author agalipally
 *
 */
public class Tracking {
	/**
	 * Date and time of the tracking created.
	 *
	 * <p>
	 * DateTime
	 */
	private Date createdAt;
	/**
	 * Date and time of the tracking last updated.
	 *
	 * <p>
	 * DateTime
	 */
	private Date updatedAt;
	/**
	 * A unique identifier generated by AfterShip for the tracking.
	 *
	 * <p>
	 * String
	 */
	private String id;
	/**
	 * The postal code of receiver's address. Required by some couriers, such
	 * asdeutsch-post
	 *
	 * <p>
	 * String
	 */
	private String trackingPostalCode;
	/**
	 * Shipping date inYYYYMMDDformat. Required by some couriers, such
	 * asdeutsch-post
	 *
	 * <p>
	 * String
	 */
	private String trackingShipDate;
	/**
	 * Account number of the shipper for a specific courier. Required by some
	 * couriers, such asdynamic-logistics
	 *
	 * <p>
	 * String
	 */
	private String trackingAccountNumber;
	/**
	 * Origin Country of the shipment for a specific courier. Required by some
	 * couriers, such asdhl
	 *
	 * <p>
	 * String
	 */
	private String trackingOriginCountry;
	/**
	 * Destination Country of the shipment for a specific courier. Required by some
	 * couriers, such aspostnl-3s
	 *
	 * <p>
	 * String
	 */
	private String trackingDestinationCountry;
	/**
	 * Located state of the shipment for a specific courier. Required by some
	 * couriers, such asstar-track-courier
	 *
	 * <p>
	 * String
	 */
	private String trackingState;
	/**
	 * Key of the shipment for a specific courier. Required by some couriers, such
	 * assic-teliway
	 *
	 * <p>
	 * String>
	 */
	private String trackingKey;
	/**
	 * Unique code of courier. Get courier slug here
	 *
	 * <p>
	 * String
	 */
	private String slug;
	/** Tracking number of a shipment. */
	@JsonProperty("tracking_number")
	private String trackingNumber;
	/**
	 * Whether or not AfterShip will continue tracking the shipments. Value is false
	 * when tag (status) is Delivered, Expired, or further updates for 30 days since
	 * last update.
	 *
	 * <p>
	 * Boolean
	 */
	private boolean active;
	/**
	 * Google cloud message registration IDs to receive the push notifications.
	 * Accept either array or comma separated as input.
	 *
	 * <p>
	 * <b>Array or String</b>
	 */
	private List<String> android;
	/**
	 * Custom fields of the tracking.
	 *
	 * <p>
	 * <b>Hash</b>
	 */
	@JsonProperty("custom_fields")
	private Map<String, String> customFields;
	/**
	 * Customer name of the tracking.
	 *
	 * <p>
	 * String
	 */
	private String customerName;
	/**
	 * Total delivery time in days. - Difference of 1st checkpoint time and
	 * delivered time for delivered shipments - Difference of 1st checkpoint time
	 * and current time for non-delivered shipments Value as 0 for pending shipments
	 * or delivered shipment with only one checkpoint.
	 *
	 * <p>
	 * Number
	 */
	private int deliveryTime;
	/**
	 * Destination country of the tracking. ISO Alpha-3 (three letters). If you use
	 * postal service to send international shipments, AfterShip will automatically
	 * get tracking results from destination postal service based on destination
	 * country.
	 *
	 * <p>
	 * String
	 */
	private String destinationCountryIso3;
	/**
	 * Destination country of the tracking detected from the courier. ISO Alpha-3
	 * (three letters). Value will be null if the courier doesn't provide the
	 * destination country.
	 *
	 * <p>
	 * String
	 */
	private String courierDestinationCountryIso3;
	/**
	 * Email address(es) to receive email notifications. Comma separated for
	 * multiple values.
	 *
	 * <p>
	 * Array
	 */
	private List<String> emails;
	/**
	 * Expected delivery date (nullable). Available format: YYYY-MM-DD,
	 * YYYY-MM-DDTHH:MM:SS, or YYYY-MM-DDTHH:MM:SS+TIMEZONE
	 *
	 * <p>
	 * String
	 */
	private String expectedDelivery;
	/**
	 * Apple iOS device IDs to receive the push notifications. Accept either array
	 * or comma separated as input.
	 *
	 * <p>
	 * <b>Array or String</b>
	 */
	private List<String> ios;
	/**
	 * Text field for order ID
	 *
	 * <p>
	 * order_id
	 */
	@JsonProperty("order_id")
	private String orderId;
	/**
	 * Text field for order path
	 *
	 * <p>
	 * String
	 */
	@JsonProperty("order_id_path")
	private String orderIdPath;
	/**
	 * Origin country of the tracking. ISO Alpha-3 (three letters).
	 *
	 * <p>
	 * String
	 */
	private String originCountryIso3;
	/**
	 * The token to generate the direct tracking link:
	 * https://yourusername.aftership.com/unique_token or
	 * https://www.aftership.com/unique_token
	 *
	 * <p>
	 * String
	 */
	private String uniqueToken;
	/**
	 * Number of packages under the tracking (if any).
	 *
	 * <p>
	 * Number
	 */
	private int shipmentPackageCount;
	/**
	 * Shipment type provided by carrier (if any).
	 *
	 * <p>
	 * String
	 */
	private String shipmentType;
	/**
	 * Shipment weight provied by carrier (if any)
	 *
	 * <p>
	 * Number
	 */
	private int shipmentWeight;
	/**
	 * Weight unit provied by carrier, either in kg or lb (if any)
	 *
	 * <p>
	 * String
	 */
	private String shipmentWeightUnit;
	/**
	 * Date and time the tracking was last updated
	 *
	 * <p>
	 * DateTime
	 */
	private Date lastUpdatedAt;
	/**
	 * Date and time the tracking was picked up
	 *
	 * <p>
	 * DateTime
	 */
	private Date shipmentPickupDate;
	/**
	 * Date and time the tracking was delivered
	 *
	 * <p>
	 * DateTime
	 */
	private Date shipmentDeliveryDate;
	/**
	 * Phone number(s) subscribed to receive sms notifications. Comma separated for
	 * multiple values
	 *
	 * <p>
	 * Array
	 */
	private List<String> subscribedSmses;
	/**
	 * Email address(es) subscribed to receive email notifications. Comma separated
	 * for multiple values
	 *
	 * <p>
	 * Array
	 */
	private List<String> subscribedEmails;
	/**
	 * Signed by information for delivered shipment (if any).
	 *
	 * <p>
	 * String
	 */
	private String signedBy;
	/**
	 * Phone number(s) to receive sms notifications. The phone number(s) to receive
	 * sms notifications. Phone number should begin with `+` and `Area Code` before
	 * phone number. Comma separated for multiple values.
	 *
	 * <p>
	 * Array
	 */
	private List<String> smses;
	/**
	 * Source of how this tracking is added.
	 *
	 * <p>
	 * source
	 */
	private String source;
	/**
	 * Current status of tracking. Values include Pending InfoReceived InTransit
	 * OutForDelivery AttemptFail Delivered AvailableForPickup Exception Expired
	 * (See tag definition) @link https://docs.aftership.com/api/4/delivery-status
	 *
	 * <p>
	 * String
	 */
	private String tag;
	/**
	 * Current subtag of tracking. (See subtag definition)
	 *
	 * @link https://help.aftership.com/hc/en-us/articles/360007823253
	 *       <p>
	 *       String
	 */
	private String subtag;
	/**
	 * Normalized tracking message. (See subtag definition)
	 *
	 * @link https://help.aftership.com/hc/en-us/articles/360007823253
	 *       <p>
	 *       String
	 */
	private String subtagMessage;
	/**
	 * Title of the tracking.
	 *
	 * <p>
	 * String
	 */
	private String title;
	/**
	 * Number of attempts AfterShip tracks at courier's system.
	 *
	 * <p>
	 * Number
	 */
	private int trackedCount;
	/**
	 * Indicates if the shipment is trackable till the final destination. Three
	 * possible values: true false null
	 *
	 * <p>
	 * Boolean or Null
	 */
	private Boolean lastMileTrackingSupported;
	/**
	 * Store, customer, or order language of the tracking. ISO 639-1 Language Code .
	 *
	 * @link https://help.aftership.com/hc/en-us/articles/360001623287-Supported-Language-Parameters
	 *       <p>
	 *       String or Null
	 */
	private String language;
	/**
	 * Whether or not the shipment is returned to sender. Value is true when any of
	 * its checkpoints has subtagException_010(returning to sender) orException_011
	 * (returned to sender). Otherwise value is false
	 *
	 * <p>
	 * <font color="red">Boolean</font>
	 */
	private Boolean returnToSender;
	/**
	 * Promised delivery date of an order inYYYY-MM-DDformat.
	 *
	 * <p>
	 * String
	 */
	@JsonProperty("order_promised_delivery_date")
	private String orderPromisedDeliveryDate;
	/**
	 * Shipment delivery type pickup_at_store pickup_at_courier door_to_door
	 *
	 * <p>
	 * String
	 */
	@JsonProperty("delivery_type")
	private String deliveryType;
	/**
	 * Shipment pickup location for receiver
	 *
	 * <p>
	 * String
	 */
	@JsonProperty("pickup_location")
	private String pickupLocation;
	/**
	 * Shipment pickup note for receiver
	 *
	 * <p>
	 * String
	 */
	@JsonProperty("pickup_note")
	private String pickupNote;
	/**
	 * Official tracking URL of the courier (if any)
	 *
	 * <p>
	 * String
	 */
	private String courierTrackingLink;
	/**
	 * Delivery instructions (delivery date or address) can be modified by visiting
	 * the link if supported by a carrier.
	 */
	private String courierRedirectLink;
	/**
	 * date and time of the first attempt by the carrier to deliver the package to
	 * the addressee Available format: YYYY-MM-DDTHH:MM:SS, or
	 * YYYY-MM-DDTHH:MM:SS+TIMEZONE
	 *
	 * <p>
	 * <font color="red">String or Null</font>
	 */
	private String firstAttemptedAt;
	/**
	 * Array of Hash describes the checkpoint information.
	 *
	 * <p>
	 * Array of Checkpoint Object
	 */
	private List<Checkpoint> checkpoints;

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTrackingPostalCode() {
		return trackingPostalCode;
	}

	public void setTrackingPostalCode(String trackingPostalCode) {
		this.trackingPostalCode = trackingPostalCode;
	}

	public String getTrackingShipDate() {
		return trackingShipDate;
	}

	public void setTrackingShipDate(String trackingShipDate) {
		this.trackingShipDate = trackingShipDate;
	}

	public String getTrackingAccountNumber() {
		return trackingAccountNumber;
	}

	public void setTrackingAccountNumber(String trackingAccountNumber) {
		this.trackingAccountNumber = trackingAccountNumber;
	}

	public String getTrackingOriginCountry() {
		return trackingOriginCountry;
	}

	public void setTrackingOriginCountry(String trackingOriginCountry) {
		this.trackingOriginCountry = trackingOriginCountry;
	}

	public String getTrackingDestinationCountry() {
		return trackingDestinationCountry;
	}

	public void setTrackingDestinationCountry(String trackingDestinationCountry) {
		this.trackingDestinationCountry = trackingDestinationCountry;
	}

	public String getTrackingState() {
		return trackingState;
	}

	public void setTrackingState(String trackingState) {
		this.trackingState = trackingState;
	}

	public String getTrackingKey() {
		return trackingKey;
	}

	public void setTrackingKey(String trackingKey) {
		this.trackingKey = trackingKey;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public String getTrackingNumber() {
		return trackingNumber;
	}

	public void setTrackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public List<String> getAndroid() {
		return android;
	}

	public void setAndroid(List<String> android) {
		this.android = new ArrayList<>(android);
	}

	public Map<String, String> getCustomFields() {
		return customFields;
	}

	public void setCustomFields(Map<String, String> customFields) {
		this.customFields = new HashMap<>(customFields);
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public int getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(int deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	public String getDestinationCountryIso3() {
		return destinationCountryIso3;
	}

	public void setDestinationCountryIso3(String destinationCountryIso3) {
		this.destinationCountryIso3 = destinationCountryIso3;
	}

	public String getCourierDestinationCountryIso3() {
		return courierDestinationCountryIso3;
	}

	public void setCourierDestinationCountryIso3(String courierDestinationCountryIso3) {
		this.courierDestinationCountryIso3 = courierDestinationCountryIso3;
	}

	public List<String> getEmails() {
		return emails;
	}

	public void setEmails(List<String> emails) {
		this.emails = new ArrayList<>(emails);
	}

	public String getExpectedDelivery() {
		return expectedDelivery;
	}

	public void setExpectedDelivery(String expectedDelivery) {
		this.expectedDelivery = expectedDelivery;
	}

	public List<String> getIos() {
		return ios;
	}

	public void setIos(List<String> ios) {
		this.ios = new ArrayList<>(ios);
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getOrderIdPath() {
		return orderIdPath;
	}

	public void setOrderIdPath(String orderIdPath) {
		this.orderIdPath = orderIdPath;
	}

	public String getOriginCountryIso3() {
		return originCountryIso3;
	}

	public void setOriginCountryIso3(String originCountryIso3) {
		this.originCountryIso3 = originCountryIso3;
	}

	public String getUniqueToken() {
		return uniqueToken;
	}

	public void setUniqueToken(String uniqueToken) {
		this.uniqueToken = uniqueToken;
	}

	public int getShipmentPackageCount() {
		return shipmentPackageCount;
	}

	public void setShipmentPackageCount(int shipmentPackageCount) {
		this.shipmentPackageCount = shipmentPackageCount;
	}

	public String getShipmentType() {
		return shipmentType;
	}

	public void setShipmentType(String shipmentType) {
		this.shipmentType = shipmentType;
	}

	public int getShipmentWeight() {
		return shipmentWeight;
	}

	public void setShipmentWeight(int shipmentWeight) {
		this.shipmentWeight = shipmentWeight;
	}

	public String getShipmentWeightUnit() {
		return shipmentWeightUnit;
	}

	public void setShipmentWeightUnit(String shipmentWeightUnit) {
		this.shipmentWeightUnit = shipmentWeightUnit;
	}

	public Date getLastUpdatedAt() {
		return lastUpdatedAt;
	}

	public void setLastUpdatedAt(Date lastUpdatedAt) {
		this.lastUpdatedAt = lastUpdatedAt;
	}

	public Date getShipmentPickupDate() {
		return shipmentPickupDate;
	}

	public void setShipmentPickupDate(Date shipmentPickupDate) {
		this.shipmentPickupDate = shipmentPickupDate;
	}

	public Date getShipmentDeliveryDate() {
		return shipmentDeliveryDate;
	}

	public void setShipmentDeliveryDate(Date shipmentDeliveryDate) {
		this.shipmentDeliveryDate = shipmentDeliveryDate;
	}

	public List<String> getSubscribedSmses() {
		return subscribedSmses;
	}

	public void setSubscribedSmses(List<String> subscribedSmses) {
		this.subscribedSmses = new ArrayList<>(subscribedSmses);
	}

	public List<String> getSubscribedEmails() {
		return subscribedEmails;
	}

	public void setSubscribedEmails(List<String> subscribedEmails) {
		this.subscribedEmails = new ArrayList<>(subscribedEmails);
	}

	public String getSignedBy() {
		return signedBy;
	}

	public void setSignedBy(String signedBy) {
		this.signedBy = signedBy;
	}

	public List<String> getSmses() {
		return smses;
	}

	public void setSmses(List<String> smses) {
		this.smses = new ArrayList<>(smses);
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
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

	public String getSubtagMessage() {
		return subtagMessage;
	}

	public void setSubtagMessage(String subtagMessage) {
		this.subtagMessage = subtagMessage;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getTrackedCount() {
		return trackedCount;
	}

	public void setTrackedCount(int trackedCount) {
		this.trackedCount = trackedCount;
	}

	public Boolean getLastMileTrackingSupported() {
		return lastMileTrackingSupported;
	}

	public void setLastMileTrackingSupported(Boolean lastMileTrackingSupported) {
		this.lastMileTrackingSupported = lastMileTrackingSupported;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Boolean getReturnToSender() {
		return returnToSender;
	}

	public void setReturnToSender(Boolean returnToSender) {
		this.returnToSender = returnToSender;
	}

	public String getOrderPromisedDeliveryDate() {
		return orderPromisedDeliveryDate;
	}

	public void setOrderPromisedDeliveryDate(String orderPromisedDeliveryDate) {
		this.orderPromisedDeliveryDate = orderPromisedDeliveryDate;
	}

	public String getDeliveryType() {
		return deliveryType;
	}

	public void setDeliveryType(String deliveryType) {
		this.deliveryType = deliveryType;
	}

	public String getPickupLocation() {
		return pickupLocation;
	}

	public void setPickupLocation(String pickupLocation) {
		this.pickupLocation = pickupLocation;
	}

	public String getPickupNote() {
		return pickupNote;
	}

	public void setPickupNote(String pickupNote) {
		this.pickupNote = pickupNote;
	}

	public String getCourierTrackingLink() {
		return courierTrackingLink;
	}

	public void setCourierTrackingLink(String courierTrackingLink) {
		this.courierTrackingLink = courierTrackingLink;
	}

	public String getCourierRedirectLink() {
		return courierRedirectLink;
	}

	public void setCourierRedirectLink(String courierRedirectLink) {
		this.courierRedirectLink = courierRedirectLink;
	}

	public String getFirstAttemptedAt() {
		return firstAttemptedAt;
	}

	public void setFirstAttemptedAt(String firstAttemptedAt) {
		this.firstAttemptedAt = firstAttemptedAt;
	}

	public List<Checkpoint> getCheckpoints() {
		return checkpoints;
	}

	public void setCheckpoints(List<Checkpoint> checkpoints) {
		this.checkpoints = new ArrayList<>(checkpoints);
	}

}