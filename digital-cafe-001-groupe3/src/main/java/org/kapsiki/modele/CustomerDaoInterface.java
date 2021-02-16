package org.kapsiki.modele;
import java.sql.SQLException;

public interface CustomerDaoInterface {
	void connect() throws SQLException;
	void disconnect() throws SQLException;
}