package com.example;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class ArtistAO {

	public void create(String name) throws SQLException {
		Connection con = Database.getConnection();
		try (PreparedStatement pstmt = con.prepareStatement(
				"insert into artists (nume) values (?)")) {
			pstmt.setString(1, name);
			pstmt.executeUpdate();
		}
	}

	public Integer findByName(String name) throws SQLException {
		Connection con = Database.getConnection();
		try (Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(
						"select id from artists where nume='" + name + "'")) {
			return rs.next() ? rs.getInt(1) : null;
		}
	}

	public String findById(int id) throws SQLException {
		Connection con = Database.getConnection();
		try (Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(
						"select nume from artists where id=" + id)) {
			return rs.next() ? rs.getString(1) : null;
		}
	}
}
