package com.cg.mts.entity;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;


@Entity

public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int transactionId;
	
	@JsonIgnore
	@OneToOne(mappedBy = "booking")
	private Show show;
	
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate bookingDate;
	
	private String transactionMode;
	private String transactionStatus;
	private double totalCost;
	
	@JsonIgnore
	@ManyToOne
	private Customer customer;
	
	@JsonIgnore
	@OneToOne(mappedBy = "booking")
	private Ticket ticket;
	
	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Booking(Show show, LocalDate bookingDate, String transactionMode, String transactionStatus, double totalCost,
			Customer customer, Ticket ticket) {
		super();
		this.show = show;
		this.bookingDate = bookingDate;
		this.transactionMode = transactionMode;
		this.transactionStatus = transactionStatus;
		this.totalCost = totalCost;
		this.customer = customer;
		this.ticket = ticket;
	}
	

	public int getTransactionId() {
		return transactionId;
	}


	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}


	public Show getShow() {
		return show;
	}


	public void setShow(Show show) {
		this.show = show;
	}


	public LocalDate getBookingDate() {
		return bookingDate;
	}


	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}


	public String getTransactionMode() {
		return transactionMode;
	}


	public void setTransactionMode(String transactionMode) {
		this.transactionMode = transactionMode;
	}


	public String getTransactionStatus() {
		return transactionStatus;
	}


	public void setTransactionStatus(String transactionStatus) {
		this.transactionStatus = transactionStatus;
	}


	public double getTotalCost() {
		return totalCost;
	}


	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}


	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public Ticket getTicket() {
		return ticket;
	}


	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	@Override
	public int hashCode() {
		return Objects.hash(bookingDate, customer, show, ticket, totalCost, transactionId, transactionMode,
				transactionStatus);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Booking other = (Booking) obj;
		return Objects.equals(bookingDate, other.bookingDate) && Objects.equals(customer, other.customer)
				&& Objects.equals(show, other.show) && Objects.equals(ticket, other.ticket)
				&& Double.doubleToLongBits(totalCost) == Double.doubleToLongBits(other.totalCost)
				&& transactionId == other.transactionId && Objects.equals(transactionMode, other.transactionMode)
				&& Objects.equals(transactionStatus, other.transactionStatus);
	}




	
	}

	
