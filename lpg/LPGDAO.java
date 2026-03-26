package com.karthik.lpg;
import java.sql.*;

public class LPGDAO {

    // BOOK CYLINDER
    public void bookCylinder(String name, String type, int qty) {
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO bookings(name, user_type, quantity, booking_date, delivery_status) VALUES (?, ?, ?, CURDATE(), 'Pending')"
            );

            ps.setString(1, name);
            ps.setString(2, type);
            ps.setInt(3, qty);

            ps.executeUpdate();
            System.out.println("Booking Successful ✅");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // VIEW BOOKINGS
    public void viewBookings() {
        try {
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM bookings");

            System.out.println("\nID | Name | Type | Qty | Date | Status");
            System.out.println("------------------------------------------------");

            while (rs.next()) {
                System.out.println(
                    rs.getInt("booking_id") + " | " +
                    rs.getString("name") + " | " +
                    rs.getString("user_type") + " | " +
                    rs.getInt("quantity") + " | " +
                    rs.getString("booking_date") + " | " +
                    rs.getString("delivery_status")
                );
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // UPDATE DELIVERY STATUS
    public void updateStatus(int id, String status) {
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "UPDATE bookings SET delivery_status=? WHERE booking_id=?"
            );

            ps.setString(1, status);
            ps.setInt(2, id);

            ps.executeUpdate();
            System.out.println("Status Updated ✅");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // DELETE BOOKING
    public void deleteBooking(int id) {
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "DELETE FROM bookings WHERE booking_id=?"
            );

            ps.setInt(1, id);

            ps.executeUpdate();
            System.out.println("Booking Deleted ❌");

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}