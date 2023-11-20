package com.cg.mts.entity;

import java.util.Objects;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity

public class Seat {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int seatId;
	private String seatNumber;
	private String type;
	private double price;
	@Enumerated(EnumType.STRING)
	private SeatStatus status;
	@JsonIgnore
	@ManyToOne
	private Ticket ticket;
	public Seat() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Seat(String seatNumber, String type, double price, SeatStatus status, Ticket tickett) {
		super();
		this.seatNumber = seatNumber;
		this.type = type;
		this.price = price;
		this.status = status;
		this.ticket = tickett;
	}
	public int getSeatId() {
		return seatId;
	}

	public void setSeatId(int seatId) {
		this.seatId = seatId;
	}

	public String getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public SeatStatus getStatus() {
		return status;
	}

	public void setStatus(SeatStatus status) {
		this.status = status;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}
	@Override
	public int hashCode() {
		return Objects.hash(price, seatId, seatNumber, status, ticket, type);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Seat other = (Seat) obj;
		return Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price) && seatId == other.seatId
				&& Objects.equals(seatNumber, other.seatNumber) && status == other.status
				&& Objects.equals(ticket, other.ticket) && Objects.equals(type, other.type);
	}

	

	
	
	
	}

