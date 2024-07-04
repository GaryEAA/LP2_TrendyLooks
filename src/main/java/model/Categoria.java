package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the categoria database table.
 * 
 */
@Entity
@NamedQuery(name="Categoria.findAll", query="SELECT c FROM Categoria c")
public class Categoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int codCat;

	private int estCat;

	@Temporal(TemporalType.DATE)
	private Date fecCat;

	private String nomCat;

	//bi-directional many-to-one association to Producto
	@OneToMany(mappedBy="categoria")
	private List<Producto> productos;

	public Categoria() {
	}

	public int getCodCat() {
		return this.codCat;
	}

	public void setCodCat(int codCat) {
		this.codCat = codCat;
	}

	public int getEstCat() {
		return this.estCat;
	}

	public void setEstCat(int estCat) {
		this.estCat = estCat;
	}

	public Date getFecCat() {
		return this.fecCat;
	}

	public void setFecCat(Date fecCat) {
		this.fecCat = fecCat;
	}

	public String getNomCat() {
		return this.nomCat;
	}

	public void setNomCat(String nomCat) {
		this.nomCat = nomCat;
	}

	public List<Producto> getProductos() {
		return this.productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	public Producto addProducto(Producto producto) {
		getProductos().add(producto);
		producto.setCategoria(this);

		return producto;
	}

	public Producto removeProducto(Producto producto) {
		getProductos().remove(producto);
		producto.setCategoria(null);

		return producto;
	}

}