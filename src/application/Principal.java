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
			System.out.println("Check in date (dd/MM/yyyy)");
			chekIn = sdf.parse(sc.next());
			System.out.println("Check Out  date (dd/MM/yyyy)");
			chekOut = sdf.parse(sc.next());

			//mostrando o erro utilizando a classe reservation não a princjpal 
			// String mostra se deu erro ou nao
			String error = rs.updateDates(chekIn, chekOut);
			if (error != null) {
				System.out.println("Error reservation: " + error);
			} else {
				
				System.out.println(rs);

			}

			

		}

	}

}
