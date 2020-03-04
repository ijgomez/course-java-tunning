package powerhoteles.alex;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * DTO de Hotel
 *
 */
public class Hotel {
	private int id;
	private String nombre;
	private int categoria;
	private String direccion;
	private String poblacion;
	private String provincia;
	private String cp;
	private double precioIndividual;
	private double precioDoble;
	private String descripcion;
	private int planoX;
	private int planoY;
	
	private FotoDAO fotoDAO;
	private CaracteristicaDAO caracteristicaDAO;
	
	

	
	/**
	 * @return the fotoDAO
	 */
	public FotoDAO getFotoDAO() {
		return fotoDAO;
	}
	/**
	 * @param fotoDAO the fotoDAO to set
	 */
	public void setFotoDAO(FotoDAO fotoDAO) {
		this.fotoDAO = fotoDAO;
	}
	/**
	 * @return the caracteristicaDAO
	 */
	public CaracteristicaDAO getCaracteristicaDAO() {
		return caracteristicaDAO;
	}
	/**
	 * @param caracteristicaDAO the caracteristicaDAO to set
	 */
	public void setCaracteristicaDAO(CaracteristicaDAO caracteristicaDAO) {
		this.caracteristicaDAO = caracteristicaDAO;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the categoria
	 */
	public int getCategoria() {
		return categoria;
	}
	/**
	 * @param categoria the categoria to set
	 */
	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}
	/**
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}
	/**
	 * @param direccion the direccion to set
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	/**
	 * @return the poblacion
	 */
	public String getPoblacion() {
		return poblacion;
	}
	/**
	 * @param poblacion the poblacion to set
	 */
	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}
	/**
	 * @return the provincia
	 */
	public String getProvincia() {
		return provincia;
	}
	/**
	 * @param provincia the provincia to set
	 */
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	/**
	 * @return the cp
	 */
	public String getCp() {
		return cp;
	}
	/**
	 * @param cp the cp to set
	 */
	public void setCp(String cp) {
		this.cp = cp;
	}
	/**
	 * @return the precioIndividual
	 */
	public double getPrecioIndividual() {
		return precioIndividual;
	}
	/**
	 * @param precioIndividual the precioIndividual to set
	 */
	public void setPrecioIndividual(double precioIndividual) {
		this.precioIndividual = precioIndividual;
	}
	/**
	 * @return the precioDoble
	 */
	public double getPrecioDoble() {
		return precioDoble;
	}
	/**
	 * @param precioDoble the precioDoble to set
	 */
	public void setPrecioDoble(double precioDoble) {
		this.precioDoble = precioDoble;
	}
	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}
	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	/**
	 * @return the planoX
	 */
	public int getPlanoX() {
		return planoX;
	}
	/**
	 * @param planoX the planoX to set
	 */
	public void setPlanoX(int planoX) {
		this.planoX = planoX;
	}
	/**
	 * @return the planoY
	 */
	public int getPlanoY() {
		return planoY;
	}
	/**
	 * @param planoY the planoY to set
	 */
	public void setPlanoY(int planoY) {
		this.planoY = planoY;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hotel other = (Hotel) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public String toString() {
		return "Hotel #"+getId()+" "+getNombre()+", "+getDireccion()+" "+getPoblacion()+" "+getCp()+" ("+getProvincia()+")";
	}
	
	
	// lazy loading 
	public ArrayList<Foto> getFotos() throws SQLException {
		return fotoDAO.findByHotel(id);
	}
	public ArrayList<Caracteristica> getCaracteristicas() throws SQLException{
		return caracteristicaDAO.findByHotel(id);
	}

	
}
