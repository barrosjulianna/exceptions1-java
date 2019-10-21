package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Principal {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);

		System.out.println("Room number:");
		int roomNumber = sc.nextInt();
		System.out.println("Check in date (dd/MM/yyyy");
		Date chekIn = sdf.parse(sc.next());
		System.out.println("Check Out  date (dd/MM/yyyy");
		Date chekOut = sdf.parse(sc.next());

		if (!chekOut.after(chekIn)) { // data chekout maior q a de chekin
			System.out.println("Error in reservation: Check-out date must be after check-in date");
		} else {

			Reservation rs = new Reservation(roomNumber, chekIn, chekOut);
			System.out.println(rs);

			System.out.println("\nEnter data to update the reservation:");
			System.out.println("Check in date (dd/MM/yyyy");
			chekIn = sdf.parse(sc.next());
			System.out.println("Check Out  date (dd/MM/yyyy");
			chekOut = sdf.parse(sc.next());

			Date now = new Date();
			if (chekIn.before(now) || chekOut.before(now)) {// SE DATA CHEKIN FOR ANTES DA DATA ATUAL QUE E NOW
				System.out.println("Error in reservation: Reservation dates for update must be future dates");
			} else if (!chekOut.after(chekIn)) {
				System.out.println("Error in reservation: Check-out date must be after check-in date");

			} else {
				rs.updateDates(chekIn, chekOut);
				System.out.println(rs);
			}

		}

	}

}
