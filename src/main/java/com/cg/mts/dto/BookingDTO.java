package com.cg.mts.dto;

import java.time.LocalDate;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
public class BookingDTO {
	private int transactionId;

    @Valid
    @JsonIgnore
    @JsonIgnoreProperties("booking")
    private ShowDTO show;

    @NotNull(message = "Booking date cannot be null")
    private LocalDate bookingDate;

    @Pattern(regexp = "(Online|Offline|)", message = "Invalid transaction mode")
    private String transactionMode;

    @Pattern(regexp = "(Pending|Completed|Cancelled)", message = "Invalid transaction status")
    private String transactionStatus;

    @Positive(message = "Total cost must be a positive value")
    private double totalCost;

    private CustomerDTO customer;

    private TicketDTO ticket;
    
    
	
   

	public BookingDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BookingDTO(int transactionId, @Valid ShowDTO show,
			 LocalDate bookingDate,
			 String transactionMode,
			 String transactionStatus,
			 double totalCost, CustomerDTO customer,
			TicketDTO ticket) {
		super();
		this.transactionId = transactionId;
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

	public ShowDTO getShow() {
		return show;
	}

	public void setShow(ShowDTO show) {
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

	public CustomerDTO getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerDTO customer) {
		this.customer = customer;
	}

	public TicketDTO getTicket() {
		return ticket;
	}

	public void setTicket(TicketDTO ticket) {
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
			BookingDTO other = (BookingDTO) obj;
			return Objects.equals(bookingDate, other.bookingDate) && Objects.equals(customer, other.customer)
					&& Objects.equals(show, other.show) && Objects.equals(ticket, other.ticket)
					&& Double.doubleToLongBits(totalCost) == Double.doubleToLongBits(other.totalCost)
					&& transactionId == other.transactionId && Objects.equals(transactionMode, other.transactionMode)
					&& Objects.equals(transactionStatus, other.transactionStatus);
		}
	
}
