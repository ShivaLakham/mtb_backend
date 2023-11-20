package com.cg.mts.dto;

import java.util.List;
import java.util.Objects;

import javax.validation.constraints.Positive;


public class TicketDTO {
    private int ticketId;
    @Positive(message = "Number of seats must be a positive integer")
    private int noOfSeats;
    private boolean ticketStatus;
    private List<SeatDTO> seats;
    private BookingDTO booking;
    
    
	public TicketDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TicketDTO(int ticketId, int noOfSeats,
			boolean ticketStatus, List<SeatDTO> seats, BookingDTO booking) {
		super();
		this.ticketId = ticketId;
		this.noOfSeats = noOfSeats;
		this.ticketStatus = ticketStatus;
		this.seats = seats;
		this.booking = booking;
	}
	public int getTicketId() {
		return ticketId;
	}
	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}
	public int getNoOfSeats() {
		return noOfSeats;
	}
	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}
	public boolean isTicketStatus() {
		return ticketStatus;
	}
	public void setTicketStatus(boolean ticketStatus) {
		this.ticketStatus = ticketStatus;
	}
	public List<SeatDTO> getSeats() {
		return seats;
	}
	public void setSeats(List<SeatDTO> seats) {
		this.seats = seats;
	}
	public BookingDTO getBooking() {
		return booking;
	}
	public void setBooking(BookingDTO booking) {
		this.booking = booking;
	}
	@Override
	public int hashCode() {
		return Objects.hash(booking, noOfSeats, seats, ticketId, ticketStatus);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TicketDTO other = (TicketDTO) obj;
		return Objects.equals(booking, other.booking) && noOfSeats == other.noOfSeats
				&& Objects.equals(seats, other.seats) && ticketId == other.ticketId
				&& ticketStatus == other.ticketStatus;
	}
    
	
    
}