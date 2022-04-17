package com.example.demo.dto;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Maersk")
public class Booking {

	@Id
	@Column(name = "id")
	private UUID id;

	@Column(name = "container_size")
	private int containerSize;

	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "container_type")
	private ContainerType containerType;

	@Size(min = 5, max = 20)
	@Column(name = "origin")
	private String origin;

	@Size(min = 5, max = 20)
	@Column(name = "destination")
	private String destination;

	@Min(1)
	@Max(100)
	@Column(name = "quantity")
	private int quantity;

	@Column(name = "timestamp")
	private String timestamp;

	public Booking() {
		super();
	}

	public Booking(UUID id, int containerSize, @NotNull ContainerType containerType,
			@Size(min = 5, max = 20) String origin, @Size(min = 5, max = 20) String destination,
			@Min(1) @Max(100) int quantity, String timestamp) {
		super();
		this.id = id;
		this.containerSize = containerSize;
		this.containerType = containerType;
		this.origin = origin;
		this.destination = destination;
		this.quantity = quantity;
		this.timestamp = timestamp;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public int getContainerSize() {
		return containerSize;
	}

	public void setContainerSize(int containerSize) {
		this.containerSize = containerSize;
	}

	public ContainerType getContainerType() {
		return containerType;
	}

	public void setContainerType(ContainerType containerType) {
		this.containerType = containerType;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "Booking [id=" + id + ", containerSize=" + containerSize + ", containerType=" + containerType
				+ ", origin=" + origin + ", destination=" + destination + ", quantity=" + quantity + ", timestamp="
				+ timestamp + "]";
	}

	

}
