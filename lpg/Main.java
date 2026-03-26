package com.karthik.lpg;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        LPGDAO dao = new LPGDAO();

        while (true) {
            System.out.println("\n===== Smart LPG Booking System =====");
            System.out.println("1. Book Cylinder");
            System.out.println("2. View Bookings");
            System.out.println("3. Update Delivery Status");
            System.out.println("4. Delete Booking");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");
            int ch = sc.nextInt();

            switch (ch) {

                case 1:
                    System.out.println("Select User Type:");
                    System.out.println("1. Householder");
                    System.out.println("2. Commercial");

                    int type = sc.nextInt();

                    if (type == 2) {
                        System.out.println("⚠ Due to global conflict affecting LPG supply, commercial bookings are temporarily restricted.");
                    } else {
                        System.out.print("Enter Name: ");
                        String name = sc.next();

                        int quantity = 1; // only 1 allowed

                        dao.bookCylinder(name, "Householder", quantity);
                    }
                    break;

                case 2:
                    dao.viewBookings();
                    break;

                case 3:
                    System.out.print("Enter Booking ID: ");
                    int id = sc.nextInt();

                    System.out.println("1. Pending");
                    System.out.println("2. Out for Delivery");
                    System.out.println("3. Delivered");

                    int s = sc.nextInt();
                    String status = "";

                    if (s == 1) status = "Pending";
                    else if (s == 2) status = "Out for Delivery";
                    else status = "Delivered";

                    dao.updateStatus(id, status);
                    break;

                case 4:
                    System.out.print("Enter Booking ID: ");
                    int del = sc.nextInt();

                    dao.deleteBooking(del);
                    break;

                case 5:
                    System.out.println("Exit...");
                    sc.close();
                    System.exit(0);
            }
        }
    }
}