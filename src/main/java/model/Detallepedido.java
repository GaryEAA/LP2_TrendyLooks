package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the detallepedido database table.
 * 
 */
@Entity
@NamedQuery(name="Detallepedido.findAll", query="SELECT d FROM Detallepedido d")
public class Detallepedido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int codDetPed;

	private int canDetPed;

	private double totDetPed;

	//bi-directional many-to-one association to Pedido
	@ManyToOne
	@JoinColumn(name="codPed")
	private Pedido pedido;

	//bi-directional many-to-one association to Producto
	@ManyToOne
	@JoinColumn(name="codProd")
	private Producto producto;

	public Detallepedido() {
	}

	public int getCodDetPed() {
		return this.codDetPed;
	}

	public void setCodDetPed(int codDetPed) {
		this.codDetPed = codDetPed;
	}

	public int getCanDetPed() {
		return this.canDetPed;
	}

	public void setCanDetPed(int canDetPed) {
		this.canDetPed = canDetPed;
	}

	public double getTotDetPed() {
		return this.totDetPed;
	}

	public void setTotDetPed(double totDetPed) {
		this.totDetPed = totDetPed;
	}

	public Pedido getPedido() {
		return this.pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Producto getProducto() {
		return this.producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

}