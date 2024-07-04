package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the carrito database table.
 * 
 */
@Entity
@NamedQuery(name="Carrito.findAll", query="SELECT c FROM Carrito c")
public class Carrito implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int codCarr;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="codUsu")
	private Usuario usuario;

	//bi-directional many-to-one association to Producto
	@ManyToOne
	@JoinColumn(name="codProd")
	private Producto producto;

	public Carrito() {
	}

	public int getCodCarr() {
		return this.codCarr;
	}

	public void setCodCarr(int codCarr) {
		this.codCarr = codCarr;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Producto getProducto() {
		return this.producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

}