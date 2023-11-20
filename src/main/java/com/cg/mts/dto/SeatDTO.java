package com.cg.mts.dto;

import java.util.Objects;

import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.cg.mts.entity.SeatStatus;

public class SeatDTO {
    private int seatId;
    @Size(max = 3, message = "Seat number must be at most 3 characters")
    private String seatNumber;
    @Size(max = 10, message = "Seat type must be at most 20 characters")
    private String type;
    @Positive(message = "Price must be a positive value")
    private double price;
    private SeatStatus status;
    private TicketDTO ticket;
	public SeatDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SeatDTO(int seatId, String seatNumber,
			 String type,double price, SeatStatus status, TicketDTO ticket) {
		super();
		this.seatId = seatId;
		this.seatNumber = seatNumber;
		this.type = type;
		this.price = price;
		this.status = status;
		this.ticket = ticket;
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
	public TicketDTO getTicket() {
		return ticket;
	}
	public void setTicket(TicketDTO ticket) {
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
		SeatDTO other = (SeatDTO) obj;
		return Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price) && seatId == other.seatId
				&& Objects.equals(seatNumber, other.seatNumber) && status == other.status
				&& Objects.equals(ticket, other.ticket) && Objects.equals(type, other.type);
	}
	    
    
}