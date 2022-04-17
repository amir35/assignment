package com.example.demo.dto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CustomerQuery {
	
	@NotNull
	private int containerSize;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private ContainerType containerType;
	
	@Size(min = 5, max = 20)
	private String origin;
	
	@Size(min = 5, max = 20)
	private String destination;
	
	@Min(1)
	@Max(100)
	private int quantity;

	public CustomerQuery(@NotNull int containerSize, @NotNull ContainerType containerType,
			@Size(min = 5, max = 20) String origin, @Size(min = 5, max = 20) String destination,
			@Min(1) @Max(100) int quantity) {
		super();
		this.containerSize = containerSize;
		this.containerType = containerType;
		this.origin = origin;
		this.destination = destination;
		this.quantity = quantity;
	}

	public CustomerQuery() {
		super();
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

	@Override
	public String toString() {
		return "CustomerQuery [containerSize=" + containerSize + ", containerType=" + containerType + ", origin="
				+ origin + ", destination=" + destination + ", quantity=" + quantity + "]";
	}
	
	

	
	
	
	
	

}
