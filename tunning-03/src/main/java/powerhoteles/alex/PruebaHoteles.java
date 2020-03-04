package powerhoteles.alex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class PruebaHoteles {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.1.2:1521:test","hoteles","hoteles");
			HotelDAO dao = new HotelDAO(con);
			ArrayList<Hotel> baratos = dao.findByPrecio(30, 100, TipoHabitacion.DOBLE);
			for(Hotel hotel : baratos) {
				String fotos = "";
				for (Foto foto : hotel.getFotos())
					fotos+="["+foto.getFoto()+" "+foto.getDescripcion()+"]";
				
				String caracteristicas = "";
				for (Caracteristica c : hotel.getCaracteristicas())
					caracteristicas+="["+c.getIcono()+" "+c.getNombre()+"]";
				
				System.out.println(hotel);
				System.out.println("Fotos: "+fotos);
				System.out.println("Características	: "+caracteristicas);
				System.out.println();
				
			}
		} catch (ClassNotFoundException e) {
			System.out.println("No se pudo cargar el driver ");
		} catch (SQLException e) {
			System.out.printf("Error %d de SQL : %s\n",e.getErrorCode(),e.getMessage());
			e.printStackTrace();
		} finally {
			if (con != null) try { con.close(); } catch (SQLException e) {}
		}

	}

}
