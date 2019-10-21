package model.entities;

import java.awt.Checkbox;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reservation {
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	private Integer roomNumber;
	private Date chekIn;
	private Date chekOut;

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getChekIn() {
		return chekIn;
	}

	public Date getChekOut() {
		return chekOut;
	}

	public Reservation() {

	}

	public Reservation(Integer roomNumber, Date chekIn, Date chekOut) throws DomainException {
		// caso aconteça o erro logo no começo e não no update
		if (!chekOut.after(chekIn)) {
			throw new DomainException("Check-out date must be after check-in date");
		}

		this.roomNumber = roomNumber;
		this.chekIn = chekIn;
		this.chekOut = chekOut;
	}

	public long duration() {
		long diff = chekOut.getTime() - chekIn.getTime(); // diferena das datas em milissegundos
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);

	} // PODE LANÇAR UMA EXCEÇÃO

	public void updateDates(Date chekIn, Date CheckOut) throws DomainException {
		Date now = new Date();
		if (chekIn.before(now) || chekOut.before(now)) {
			throw new DomainException("Reservation Dates for update must be future dates.");
		}
		if (!chekOut.after(chekIn)) {
			throw new DomainException("Check-out date must be after check-in date");
		}

		this.chekIn = chekIn;
		this.chekOut = CheckOut;

	}

	@Override
	public String toString() {
		return "Reservation: Room " + roomNumber + ", Check in: " + sdf.format(chekIn) + ", ChekOut: "
				+ sdf.format(chekOut) + ", " + duration() + " nights";
	}

}
