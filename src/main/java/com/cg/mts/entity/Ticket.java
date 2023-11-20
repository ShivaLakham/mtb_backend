package com.cg.mts.entity;

import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity

public class Ticket {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int ticketId;
	private int noOfSeats;
	private boolean ticketStatus;
	//@OneToMany(mappedBy = "ticket")
	@OneToMany
	@JsonIgnore
	private List<Seat> seats;
	@OneToOne
	@JsonIgnore
	private Booking booking;
	
	
	
	public Ticket() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Ticket(int noOfSeats, boolean ticketStatus, List<Seat> seats, Booking booking) {
		super();
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

	public List<Seat> getSeats() {
		return seats;
	}

	public void setSeats(List<Seat> seats) {
		this.seats = seats;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
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
		Ticket other = (Ticket) obj;
		return Objects.equals(booking, other.booking) && noOfSeats == other.noOfSeats
				&& Objects.equals(seats, other.seats) && ticketId == other.ticketId
				&& ticketStatus == other.ticketStatus;
	}

	

	
	}
