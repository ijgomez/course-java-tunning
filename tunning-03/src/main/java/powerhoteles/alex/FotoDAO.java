package powerhoteles.alex;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FotoDAO {
	private Connection con;
	
	public FotoDAO(Connection con) {
		this.con = con;
	}
	
	private Foto leerDesde(ResultSet rs) throws SQLException {
		Foto f= new Foto();
		f.setDescripcion(rs.getString("descripcion"));
		f.setId(rs.getInt("id"));
		f.setFoto(rs.getString("foto"));
		return f;
	}
	
	public ArrayList<Foto> findByHotel(int idHotel) throws SQLException {
		PreparedStatement psql = con.prepareStatement("select * from fotos where id_hotel = ?");
		psql.setInt(1, idHotel);
		ResultSet rs = psql.executeQuery();
		ArrayList<Foto> fotos = new ArrayList<Foto>();
		while (rs.next()) {
			fotos.add(leerDesde(rs));
		}
		rs.close();
		psql.close();
		return fotos;
	}
}
