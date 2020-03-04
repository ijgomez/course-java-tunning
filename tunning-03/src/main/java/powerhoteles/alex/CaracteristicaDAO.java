package powerhoteles.alex;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CaracteristicaDAO {
	private Connection con;
	public CaracteristicaDAO(Connection con) {
		this.con = con;
	}
	private Caracteristica leerDesde(ResultSet rs)throws SQLException {
		Caracteristica c = new Caracteristica();
		c.setIcono(rs.getString("icono"));
		c.setId(rs.getInt("id"));
		c.setNombre(rs.getString("nombre"));
		return c;
	}
	
	public ArrayList<Caracteristica> findByHotel(int idHotel) throws SQLException {
		PreparedStatement psql = con.prepareStatement(
				"select caracteristicas.* from caracteristicas,hoteles_caracteristicas where "+
				"caracteristicas.id = hoteles_caracteristicas.id_caracteristica and "+
				"hoteles_caracteristicas.id_hotel = ?");
		psql.setInt(1, idHotel);
		ArrayList<Caracteristica> caracteristicas = new ArrayList<Caracteristica>();
		ResultSet rs = psql.executeQuery();
		while (rs.next()) {
			caracteristicas.add(leerDesde(rs));
		}
		rs.close();
		psql.close();
		return caracteristicas;
	}
}
