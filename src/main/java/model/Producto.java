package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the producto database table.
 * 
 */
@Entity
@NamedQuery(name="Producto.findAll", query="SELECT p FROM Producto p")
public class Producto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int codProd;

	private String descProd;

	private int estProd;

	@Temporal(TemporalType.DATE)
	private Date fecProd;

	private String imgProd;

	private String nomProd;

	private double preProd;

	private int stockProd;

	//bi-directional many-to-one association to Carrito
	@OneToMany(mappedBy="producto")
	private List<Carrito> carritos;

	//bi-directional many-to-one association to Detallepedido
	@OneToMany(mappedBy="producto")
	private List<Detallepedido> detallepedidos;

	//bi-directional many-to-one association to Categoria
	@ManyToOne
	@JoinColumn(name="codCat")
	private Categoria categoria;

	public Producto() {
	}

	public int getCodProd() {
		return this.codProd;
	}

	public void setCodProd(int codProd) {
		this.codProd = codProd;
	}

	public String getDescProd() {
		return this.descProd;
	}

	public void setDescProd(String descProd) {
		this.descProd = descProd;
	}

	public int getEstProd() {
		return this.estProd;
	}

	public void setEstProd(int estProd) {
		this.estProd = estProd;
	}

	public Date getFecProd() {
		return this.fecProd;
	}

	public void setFecProd(Date fecProd) {
		this.fecProd = fecProd;
	}

	public String getImgProd() {
		return this.imgProd;
	}

	public void setImgProd(String imgProd) {
		this.imgProd = imgProd;
	}

	public String getNomProd() {
		return this.nomProd;
	}

	public void setNomProd(String nomProd) {
		this.nomProd = nomProd;
	}

	public double getPreProd() {
		return this.preProd;
	}

	public void setPreProd(double preProd) {
		this.preProd = preProd;
	}

	public int getStockProd() {
		return this.stockProd;
	}

	public void setStockProd(int stockProd) {
		this.stockProd = stockProd;
	}

	public List<Carrito> getCarritos() {
		return this.carritos;
	}

	public void setCarritos(List<Carrito> carritos) {
		this.carritos = carritos;
	}

	public Carrito addCarrito(Carrito carrito) {
		getCarritos().add(carrito);
		carrito.setProducto(this);

		return carrito;
	}

	public Carrito removeCarrito(Carrito carrito) {
		getCarritos().remove(carrito);
		carrito.setProducto(null);

		return carrito;
	}

	public List<Detallepedido> getDetallepedidos() {
		return this.detallepedidos;
	}

	public void setDetallepedidos(List<Detallepedido> detallepedidos) {
		this.detallepedidos = detallepedidos;
	}

	public Detallepedido addDetallepedido(Detallepedido detallepedido) {
		getDetallepedidos().add(detallepedido);
		detallepedido.setProducto(this);

		return detallepedido;
	}

	public Detallepedido removeDetallepedido(Detallepedido detallepedido) {
		getDetallepedidos().remove(detallepedido);
		detallepedido.setProducto(null);

		return detallepedido;
	}

	public Categoria getCategoria() {
		return this.categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

}