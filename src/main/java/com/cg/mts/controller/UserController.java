package com.cg.mts.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.mts.exception.CustomerNotFoundException;
import com.cg.mts.exception.MovieNotFoundException;
import com.cg.mts.exception.ScreenNotFoundException;
import com.cg.mts.exception.SeatNotFoundException;
import com.cg.mts.exception.ShowNotFoundException;
import com.cg.mts.exception.TheatreNotFoundException;
import com.cg.mts.exception.TicketNotFoundException;
import com.cg.mts.dto.BookingDTO;
import com.cg.mts.dto.CustomerDTO;
import com.cg.mts.dto.MovieDTO;
import com.cg.mts.dto.ScreenDTO;
import com.cg.mts.dto.SeatDTO;
import com.cg.mts.dto.ShowDTO;
import com.cg.mts.dto.TheatreDTO;
import com.cg.mts.dto.TicketDTO;
import com.cg.mts.dto.UserDTO;
import com.cg.mts.entity.Booking;
import com.cg.mts.entity.Customer;
import com.cg.mts.entity.Movie;
import com.cg.mts.entity.Screen;
import com.cg.mts.entity.Seat;
import com.cg.mts.entity.Show;
import com.cg.mts.entity.Theatre;
import com.cg.mts.entity.Ticket;
import com.cg.mts.entity.User;
import com.cg.mts.exception.AccessForbiddenException;
import com.cg.mts.exception.BookingNotFoundException;
import com.cg.mts.exception.UserCreationError;
import com.cg.mts.mapper.EntityDtoMapper;
import com.cg.mts.repository.CustomerRepository;
import com.cg.mts.service.CustomerService;
import com.cg.mts.service.IBookingService;
import com.cg.mts.service.ISeatService;
import com.cg.mts.service.IUserService;
import com.cg.mts.service.MoviesService;
import com.cg.mts.service.ScreenService;
import com.cg.mts.service.ShowService;
import com.cg.mts.service.TheatreService;
import com.cg.mts.service.TicketService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/user")
@Api(value = "Swagger2DemoRestController")
@Validated
public class UserController {

	Logger logger = LoggerFactory.getLogger(UserController.class);
	@Autowired
	IUserService userService;
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	private IBookingService bookingService;
	
	@Autowired
	private MoviesService moviesService;
	@Autowired
	private CustomerService customerService;
	@Autowired
	private ScreenService screenService;
	@Autowired
	private ISeatService seatService;
	@Autowired
	private ShowService showService;
	@Autowired
	private TheatreService theatreservice;
	@Autowired
	private TicketService ticketService;


	@PostMapping("/adduser")
	@ApiOperation(value = "add a user")
	public ResponseEntity<UserDTO> addUser(@Valid @RequestBody UserDTO userDTO)
			throws AccessForbiddenException, CustomerNotFoundException, UserCreationError {
		User user=EntityDtoMapper.convertToEntity(userDTO, User.class);
		if (userDTO.getRole().equalsIgnoreCase("CUSTOMER")) {
			Customer customer = new Customer(user.getUsername(), null, null, null, user.getPassword());
			logger.info("-----------------Customer Added---------------------");
			customerRepository.save(customer);
			user.setCustomer(customer);
		}
		logger.info("-----------------User Added---------------------");
		userService.addUser(user);
		UserDTO addedUserDTO=EntityDtoMapper.convertToDTO(user, UserDTO.class);
		return ResponseEntity.ok(addedUserDTO);
	}

	
	@DeleteMapping("/removeuser")
	public ResponseEntity<UserDTO> removeUser(@Valid @RequestBody UserDTO userDTO) throws AccessForbiddenException {
		
		User user=EntityDtoMapper.convertToEntity(userDTO, User.class);
		logger.info("--------------------User Deleted------------------");
		User remUser=userService.removeUser(user);
		UserDTO remUserDTO=EntityDtoMapper.convertToDTO(remUser, UserDTO.class);
		return ResponseEntity.ok(remUserDTO);
	}
	
	@PostMapping(value = "/insert", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BookingDTO> addTicketBooking(@Valid @RequestBody BookingDTO bookingDTO,
			@RequestParam(required = false) Integer customerId,@RequestParam(required = false) Integer showId)
			throws AccessForbiddenException, BookingNotFoundException {
		Booking booking = EntityDtoMapper.convertToEntity(bookingDTO, Booking.class);
		Booking addedBooking=bookingService.addBooking(booking, customerId,showId);
		BookingDTO addedBookingDTO = EntityDtoMapper.convertToDTO(addedBooking, BookingDTO.class);
		return ResponseEntity.ok(addedBookingDTO);
	}
	
	@GetMapping("/findall")
	public ResponseEntity<List<CustomerDTO>> viewCustomerList() throws AccessForbiddenException {
		
		logger.info("---------------Customer List-----------------");
		List<Customer> customer=customerService.viewCustomerList();
		List<CustomerDTO> resultDTO=EntityDtoMapper.convertToDTOList(customer, CustomerDTO.class);
		return ResponseEntity.ok(resultDTO);
	}
	
	
	@GetMapping("/view/{customerId}")
	public ResponseEntity<CustomerDTO> viewACustomer(@PathVariable int customerId) throws CustomerNotFoundException {

		ResponseEntity<CustomerDTO> response = null;
		try {
			Customer customer = customerService.viewCustomer(customerId);
			CustomerDTO resultDTO=EntityDtoMapper.convertToDTO(customer, CustomerDTO.class);
			response = new ResponseEntity<>(resultDTO, HttpStatus.OK);
			logger.info("-------Movie With Movie id " + customerId + " Found---------");
		} catch (Exception e) {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			throw new CustomerNotFoundException("Customer with " + customerId + " id dosen't exist");
		}
		return response;
	}
	
	
	@GetMapping("/viewbooking/{bookingId}")
	public ResponseEntity<BookingDTO> viewBooking(@PathVariable int bookingId)
			throws BookingNotFoundException {
		ResponseEntity<BookingDTO> response = null;
		
		try {
			Booking booking = bookingService.viewBooking(bookingId);
			BookingDTO resultDTO=EntityDtoMapper.convertToDTO(booking, BookingDTO.class);
			response = new ResponseEntity<>(resultDTO, HttpStatus.OK);
			logger.info("-------Screen Found---------");
		} catch (Exception e) {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			throw new BookingNotFoundException("Booking dosen't exist");
		}
		return response;
	}
	
	
	@GetMapping("/movies/by/{movieId}")
	public ResponseEntity<List<BookingDTO>> viewMovieByMovieId(@PathVariable int movieId)
			throws AccessForbiddenException, BookingNotFoundException {
		
		logger.info("-------Bookings With MovieId " + movieId + " Fetched Successfully---------");
		List<Booking> booking=bookingService.showAllBookings(movieId);
		List<BookingDTO> resultDTO=EntityDtoMapper.convertToDTOList(booking, BookingDTO.class);
		return ResponseEntity.ok(resultDTO);
	}

	
	@GetMapping("/movies/by/{date}")
	public ResponseEntity<List<BookingDTO>> viewMovieByLocalDate(
			@RequestParam("bookingDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date)
			throws AccessForbiddenException, BookingNotFoundException {
		
		logger.info("-------Bookings With Date " + date + " Fetched Successfully---------");
		List<Booking> booking=bookingService.showAllBookings(date);
		List<BookingDTO> resultDTO=EntityDtoMapper.convertToDTOList(booking, BookingDTO.class);
		return ResponseEntity.ok(resultDTO);
	}

	
	@GetMapping("/movies/cost/{bookingId}")
	public double TotalBookingCost(@PathVariable int bookingId)
			throws AccessForbiddenException, BookingNotFoundException {
		
		logger.info("-------Total Cost Of Booking displayed Successfully---------");
		return bookingService.calculateTotalCost(bookingId);
	}
	

	@GetMapping("/movies/by/{theatreId}")
	public ResponseEntity<List<MovieDTO>> viewMovieByTheatreId(@PathVariable int theatreId)  {
		logger.info("-------Movies With TheatreId " + theatreId + " Found---------");
		List<Movie> movie=moviesService.viewMovieList(theatreId);
		List<MovieDTO> resultDTO=EntityDtoMapper.convertToDTOList(movie, MovieDTO.class);
		return ResponseEntity.ok(resultDTO);
	}


	@GetMapping("/movies/byLoc/{date}")
	public ResponseEntity<List<MovieDTO>> viewMoviesListByLocalDate(
			@RequestParam("movieDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
		logger.info("-------Movies With Date " + date + " Found---------");
		List<Movie> movie=moviesService.viewMovieList(date);
		List<MovieDTO> resultDTO=EntityDtoMapper.convertToDTOList(movie, MovieDTO.class);
		return ResponseEntity.ok(resultDTO);
	}
	
	@GetMapping("/movies/findallmovies")
	public ResponseEntity<List<MovieDTO>> viewMovieList() throws MovieNotFoundException {

		logger.info("-------Movie List Fetched---------");
		List<Movie> movie=moviesService.viewMovieList();
		List<MovieDTO> resultDTO=EntityDtoMapper.convertToDTOList(movie, MovieDTO.class);
		return ResponseEntity.ok(resultDTO);
	}
	
	@GetMapping("/viewMovie/{movieId}")
	public ResponseEntity<MovieDTO> viewMovie(@PathVariable int movieId)
			throws MovieNotFoundException {

		ResponseEntity<MovieDTO> response = null;
		try {
			Movie movie = moviesService.viewMovie(movieId);
			MovieDTO resultDTO=EntityDtoMapper.convertToDTO(movie, MovieDTO.class);
			response = new ResponseEntity<>(resultDTO, HttpStatus.OK);
			logger.info("-------Movie With Movie id " + movieId + " Found---------");
		} catch (Exception e) {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			throw new MovieNotFoundException("Movie with " + movieId + " id dosen't exist");
		}
		return response;
	}
	
	@GetMapping("/findallscr")
	public ResponseEntity<List<ScreenDTO>> viewScreenList() throws  ScreenNotFoundException {

		logger.info("-------List Of Screens Fetched Successfully---------");
		List<Screen> viewScreeenList=screenService.viewScreenList();
		List<ScreenDTO> viewScreeenListDTO=EntityDtoMapper.convertToDTOList(viewScreeenList, ScreenDTO.class);
		return ResponseEntity.ok(viewScreeenListDTO);
	}
	
	@GetMapping("/theatre/{screenId}")
	public ResponseEntity<TheatreDTO>  getTheatreById(@PathVariable int screenId) throws ScreenNotFoundException {
		ResponseEntity<TheatreDTO> response = null;
		try {
			Theatre theatre = screenService.getTheatre(screenId);
			TheatreDTO theatreDTO=EntityDtoMapper.convertToDTO(theatre, TheatreDTO.class);
			response = new ResponseEntity<>(theatreDTO, HttpStatus.OK);
		} catch (Exception e) {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return response;
	}
	
	@GetMapping("/viewScreen/{screenId}")
	public ResponseEntity<ScreenDTO> viewScreen(@PathVariable int screenId)
			throws ScreenNotFoundException {
		ResponseEntity<ScreenDTO> response = null;
		try {
			Screen screen = screenService.viewScreen(screenId);
			ScreenDTO viewscreenDTO=EntityDtoMapper.convertToDTO(screen, ScreenDTO.class);
			response = new ResponseEntity<>(viewscreenDTO, HttpStatus.OK);
			logger.info("-------Screen Found---------");
		} catch (Exception e) {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			throw new ScreenNotFoundException("Screen dosen't exist");
		}
		return response;
	}
	

	@GetMapping("/findallseat")
	public ResponseEntity<List<SeatDTO>> viewSeatList() throws AccessForbiddenException, SeatNotFoundException {
		
		logger.info("-------List of Seats Fetched Successfully---------");
		List<Seat> seat=seatService.viewSeatList();
		List<SeatDTO> viewSeatDTO=EntityDtoMapper.convertToDTOList(seat, SeatDTO.class);
		return ResponseEntity.ok(viewSeatDTO);
	}

	
	@PutMapping("/updateseat")
	public ResponseEntity<SeatDTO> updateSeat(@Valid @RequestBody SeatDTO seatDTO)
			throws AccessForbiddenException, SeatNotFoundException {
	
		ResponseEntity<SeatDTO> response = null;
		Seat seat=EntityDtoMapper.convertToEntity(seatDTO, Seat.class);
		if (seat == null) {
			response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			seat = seatService.updateSeat(seat);
			SeatDTO resultSeatDTO=EntityDtoMapper.convertToDTO(seat, SeatDTO.class);
			response = new ResponseEntity<>(resultSeatDTO, HttpStatus.OK);
			logger.info("-------Seat Updated Successfully---------");
		}
		return response;
	}

	
	@PutMapping("/bookseat")
	public ResponseEntity<SeatDTO> BookASeat(@Valid @RequestBody SeatDTO seatDTO)
			throws AccessForbiddenException, SeatNotFoundException {
		Seat seat=EntityDtoMapper.convertToEntity(seatDTO, Seat.class);
		seat = seatService.bookSeat(seat);
		logger.info("-------Seat booking Successfull---------");
		SeatDTO resultSeatDTO=EntityDtoMapper.convertToDTO(seat, SeatDTO.class);
		return new ResponseEntity<>(resultSeatDTO, HttpStatus.OK);
	}

	
	@PutMapping("/cancelseat")
	public ResponseEntity<SeatDTO> CancelASeat(@Valid @RequestBody SeatDTO seatDTO)
			throws AccessForbiddenException, SeatNotFoundException {
		Seat seat=EntityDtoMapper.convertToEntity(seatDTO, Seat.class);
		seat = seatService.cancelSeatBooking(seat);
		SeatDTO resultSeatDTO=EntityDtoMapper.convertToDTO(seat, SeatDTO.class);
		logger.info("-------Seat Cancellation Successfull---------");
		return new ResponseEntity<>(resultSeatDTO, HttpStatus.OK);
	}

	
	@PutMapping("/blockseat")
	public ResponseEntity<SeatDTO> BloclASeat(@Valid @RequestBody SeatDTO seatDTO)
			throws AccessForbiddenException, SeatNotFoundException {
		Seat seat=EntityDtoMapper.convertToEntity(seatDTO, Seat.class);
		seat = seatService.blockSeat(seat);
		SeatDTO resultSeatDTO=EntityDtoMapper.convertToDTO(seat, SeatDTO.class);
		logger.info("-------Seat blocking Successfull---------");
		return new ResponseEntity<>(resultSeatDTO, HttpStatus.OK);
	}
	
	@GetMapping("/viewShow/{showId}")
	public ResponseEntity<ShowDTO> viewShow(@PathVariable int showId)
			throws  ShowNotFoundException {

		ResponseEntity<ShowDTO> response = null;
		try {
			Show viewShow = showService.viewShow(showId);
			ShowDTO viewShowDTO=EntityDtoMapper.convertToDTO(viewShow, ShowDTO.class);
			response = new ResponseEntity<>(viewShowDTO, HttpStatus.OK);
			logger.info("-------Show with ShowId " + showId + " Found Successfully---------");
		} catch (Exception e) {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			throw new ShowNotFoundException("Show with " + showId + " id dosen't exist");
		}
		return response;
	}


	@GetMapping("/findallShow")
	public ResponseEntity<List<ShowDTO>> viewShowList() {

		logger.info("-------List Of Shows Fetched Successfully---------");
		//Show allShows=EntityDtoMapper.convertToEntity(showDTO, Show.class);
		List<Show> allShows=showService.viewAllShows();
		List<ShowDTO> allShowsDTO=EntityDtoMapper.convertToDTOList(allShows, ShowDTO.class);
		return ResponseEntity.ok(allShowsDTO);
	}

	
	@GetMapping("/show_theatre/{theatreId}")
	public ResponseEntity<List<ShowDTO>> viewShowByTheatreId(@PathVariable int theatreId) {
		List<Show> viewShowByTid = showService.viewShowList(theatreId);
		List<ShowDTO> viewShowByTidDTO=EntityDtoMapper.convertToDTOList(viewShowByTid, ShowDTO.class);
		logger.info("-------List Of Shows With TheatreId " + theatreId + " Fetched Successfully---------");
		return ResponseEntity.ok(viewShowByTidDTO);
	}


	@GetMapping("/dateShow/{date}")
	public ResponseEntity<List<ShowDTO>> viewShowByLocalDate(@PathVariable int date) {

		List<Show> viewShowByLocDate=showService.viewShowList(date);
		List<ShowDTO> viewShowByLocDateDTO=EntityDtoMapper.convertToDTOList(viewShowByLocDate, ShowDTO.class);
		logger.info("-------List Of Shows With Date " + date + " Fetched Successfully---------");
		return ResponseEntity.ok(viewShowByLocDateDTO);
	}

	@GetMapping("/allTheatre")
	public ResponseEntity<List<TheatreDTO>> getAlltheatres() throws  TheatreNotFoundException {

		logger.info("-------Theatre List Fetched---------");
		List<Theatre> allTheatres=theatreservice.getAllTheatres();
		List<TheatreDTO> allTheatresDTO=EntityDtoMapper.convertToDTOList(allTheatres, TheatreDTO.class);
		return ResponseEntity.ok(allTheatresDTO);
	}

	
	
	
	@GetMapping("/findTheatre/{theatreId}")
	public ResponseEntity<TheatreDTO> findTheatre(@PathVariable int theatreId)
			throws  TheatreNotFoundException {

		logger.info("-------Theatre Found with Theatre id" + theatreId + "---------");
		Theatre theatre= theatreservice.findTheatres(theatreId);
		TheatreDTO findtheatreDTO=EntityDtoMapper.convertToDTO(theatre, TheatreDTO.class);
		return ResponseEntity.ok(findtheatreDTO);
		
	}
	
	@GetMapping("/theatre/FindbyMovie/{movieId}")
	public ResponseEntity<List<TheatreDTO>> findTheatreByMovieId(@PathVariable int movieId)
			throws  TheatreNotFoundException {
		List<Theatre> theatre=theatreservice.findTheatresByMovie(movieId);
		List<TheatreDTO> byIdtheaatreDTO=EntityDtoMapper.convertToDTOList(theatre, TheatreDTO.class);
		return ResponseEntity.ok(byIdtheaatreDTO);
	}
	
	@GetMapping("/findallTicket")
	public ResponseEntity<List<TicketDTO>> viewTicketList() throws AccessForbiddenException, TicketNotFoundException {
		
		logger.info("-------List of Tickets Found Successfully---------");
		List<Ticket> viewTicket=ticketService.viewTicketList();
		List<TicketDTO> viewTicketDTO=EntityDtoMapper.convertToDTOList(viewTicket, TicketDTO.class);
		return ResponseEntity.ok(viewTicketDTO);
	}

	
	@GetMapping("/findTicket/{ticketId}")
	public ResponseEntity<TicketDTO> findATicket(@PathVariable int ticketId) throws TicketNotFoundException, AccessForbiddenException {	
		Ticket t = null;
		TicketDTO tDTO=null;
		try {
			t = ticketService.findTicket(ticketId);
			tDTO=EntityDtoMapper.convertToDTO(t, TicketDTO.class);
			logger.info("-------Ticket with ticketId " + ticketId + " Foound Successfully---------");
		} catch (Exception e) {
			throw new TicketNotFoundException("Invalid Ticket ID");
		}
		return ResponseEntity.ok(tDTO);

	}
	
	@PostMapping("/addTicket")
	public ResponseEntity<TicketDTO> addATicket(@Valid @RequestBody TicketDTO ticketDTO,@RequestParam(required = false) Integer bookingId)
			throws AccessForbiddenException, TicketNotFoundException {
		Ticket ticket=EntityDtoMapper.convertToEntity(ticketDTO, Ticket.class);
		Ticket addedTicket = ticketService.addTicket(ticket,bookingId);
		TicketDTO addedTicketDTO=EntityDtoMapper.convertToDTO(addedTicket, TicketDTO.class);
		logger.info("-------Ticked Created Successfully---------");
		return new ResponseEntity<>(addedTicketDTO, HttpStatus.CREATED);
	}
	
}