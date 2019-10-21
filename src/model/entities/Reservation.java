package model.entities;

import java.awt.Checkbox;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	private static SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
	
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
	public Reservation(Integer roomNumber, Date chekIn, Date chekOut) {
		this.roomNumber = roomNumber;
		this.chekIn = chekIn;
		this.chekOut = chekOut;
	}

	public long duration() {
		long diff= chekOut.getTime()- chekIn.getTime(); //diferena das datas em milissegundos
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
		
		
	}
	public String  updateDates(Date chekIn, Date ChekOut) {
		Date now = new Date();
		if(chekIn.before(now)|| chekOut.before(now)) {
			return "Reservation Dates for update must be future dates.";
		}if (!chekOut.after(chekIn)) {
			return "Check-out date must be after check-in date";
		}
		
		this.chekIn=chekIn;
		this.chekOut=chekOut;
		return null; //N DEU ERRO 
	}
	@Override
	public String toString() {
		return "Reservation: Room "+ roomNumber + ", Check in: " + sdf.format(chekIn) + ", ChekOut: " + sdf.format(chekOut) + ", " +duration() +" nights";
	}
	
	
	
}
