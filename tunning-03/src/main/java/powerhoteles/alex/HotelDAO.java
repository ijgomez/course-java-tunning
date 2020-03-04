package powerhoteles.alex;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class HotelDAO {
	private Connection con;
	private FotoDAO fotoDAO;
	private CaracteristicaDAO caracteristicaDAO;
	
	public HotelDAO(Connection con) {
		this.con = con;
		fotoDAO = new FotoDAO(con);
		caracteristicaDAO = new CaracteristicaDAO(con);
	}
	
	private Hotel leerDesde(ResultSet rs) throws SQLException{
		Hotel h = new Hotel();
		h.setCaracteristicaDAO(caracteristicaDAO);
		h.setFotoDAO(fotoDAO);
		h.setId(rs.getInt("id"));
		h.setCategoria(rs.getInt("categoria"));
		h.setPlanoX(rs.getInt("planoX"));
		h.setPlanoY(rs.getInt("planoY"));
		h.setPrecioIndividual(rs.getDouble("precioIndividual"));
		h.setPrecioDoble(rs.getDouble("precioDoble"));
		h.setDescripcion(rs.getString("descripcion"));
		h.setDireccion(rs.getString("direccion"));
		h.setNombre(rs.getString("nombre"));
		h.setPoblacion(rs.getString("poblacion"));
		h.setProvincia(rs.getString("provincia"));
		h.setCp(rs.getString("Cp"));
		return h;
	}
	
	public Hotel findById(int id) throws SQLException{
		PreparedStatement psql = con.prepareStatement("select * from hoteles where id = ?");
		psql.setInt(1, id);
		ResultSet rs = psql.executeQuery();
		if (rs.next())
			return leerDesde(rs);
		else
			return null;
		
	}
	
	public ArrayList<Hotel> findByPrecio(
			double precioMin,
			double precioMax,
			TipoHabitacion tipo) throws SQLException {
		PreparedStatement psql;
		switch (tipo) {
			case DOBLE:
				psql = con.prepareStatement("select * from hoteles where preciodoble between ? and ? ");
				psql.setDouble(1, precioMin);
				psql.setDouble(2, precioMax);
				break;
			case INDIVIDUAL :
				psql = con.prepareStatement("select * from hoteles where precioindividual between ? and ? ");
				psql.setDouble(1, precioMin);
				psql.setDouble(2, precioMax);
				break;
			default :
				psql = con.prepareStatement("select * from hoteles where (precioindividual between ? and ?) " +
						" or preciodoble between ? and ?");
				psql.setDouble(1, precioMin);
				psql.setDouble(2, precioMax);
				psql.setDouble(3, precioMin);
				psql.setDouble(4, precioMax);
				break;
		}
		ResultSet rs = psql.executeQuery();
		ArrayList<Hotel> hoteles = new ArrayList<Hotel>();
		while (rs.next()) {
			hoteles.add(leerDesde(rs));
		}
		rs.close();
		psql.close();
		return hoteles;
	}
}

