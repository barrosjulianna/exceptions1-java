package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Principal {

	public static void main(String[] args)  {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Scanner sc = new Scanner(System.in);
			try {
				
			
			System.out.println("Room number:");
			int roomNumber = sc.nextInt();
			System.out.println("Check in date (dd/MM/yyyy");
			Date chekIn = sdf.parse(sc.next());
			System.out.println("Check Out  date (dd/MM/yyyy");
			Date chekOut = sdf.parse(sc.next());
	
			Reservation rs = new Reservation(roomNumber, chekIn, chekOut);
			System.out.println(rs);
	
			System.out.println("\nEnter data to update the reservation:");
			System.out.println("Check in date (dd/MM/yyyy)");
			chekIn = sdf.parse(sc.next());
			System.out.println("Check Out  date (dd/MM/yyyy)");
			chekOut = sdf.parse(sc.next());
	
			rs.updateDates(chekIn, chekOut);
			System.out.println(rs);
		}
		catch(ParseException e) {
			System.out.println("Invalid date format");
		}
			catch(DomainException e) {
				System.out.println("Error n reservation: "+e.getMessage());
				//QUALQUER OUTRA EXCESSAO MOSTRAR ESSE ERRO, P N QUEBRAR O PROGRAMAAA
			} catch(RuntimeException e) {
				System.out.println("Unexpected error");
			}
			
		
		
	}

}
