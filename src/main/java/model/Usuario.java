package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int codUsu;

	private String apeUsu;

	private String contraUsu;

	private String correoUsu;

	private int estUsu;

	@Temporal(TemporalType.DATE)
	private Date fecUsu;

	private String nomUsu;

	private int rolUsu;

	//bi-directional many-to-one association to Carrito
	@OneToMany(mappedBy="usuario")
	private List<Carrito> carritos;

	//bi-directional many-to-one association to Pedido
	@OneToMany(mappedBy="usuario")
	private List<Pedido> pedidos;

	public Usuario() {
	}

	public int getCodUsu() {
		return this.codUsu;
	}

	public void setCodUsu(int codUsu) {
		this.codUsu = codUsu;
	}

	public String getApeUsu() {
		return this.apeUsu;
	}

	public void setApeUsu(String apeUsu) {
		this.apeUsu = apeUsu;
	}

	public String getContraUsu() {
		return this.contraUsu;
	}

	public void setContraUsu(String contraUsu) {
		this.contraUsu = contraUsu;
	}

	public String getCorreoUsu() {
		return this.correoUsu;
	}

	public void setCorreoUsu(String correoUsu) {
		this.correoUsu = correoUsu;
	}

	public int getEstUsu() {
		return this.estUsu;
	}

	public void setEstUsu(int estUsu) {
		this.estUsu = estUsu;
	}

	public Date getFecUsu() {
		return this.fecUsu;
	}

	public void setFecUsu(Date fecUsu) {
		this.fecUsu = fecUsu;
	}

	public String getNomUsu() {
		return this.nomUsu;
	}

	public void setNomUsu(String nomUsu) {
		this.nomUsu = nomUsu;
	}

	public int getRolUsu() {
		return this.rolUsu;
	}

	public void setRolUsu(int rolUsu) {
		this.rolUsu = rolUsu;
	}

	public List<Carrito> getCarritos() {
		return this.carritos;
	}

	public void setCarritos(List<Carrito> carritos) {
		this.carritos = carritos;
	}

	public Carrito addCarrito(Carrito carrito) {
		getCarritos().add(carrito);
		carrito.setUsuario(this);

		return carrito;
	}

	public Carrito removeCarrito(Carrito carrito) {
		getCarritos().remove(carrito);
		carrito.setUsuario(null);

		return carrito;
	}

	public List<Pedido> getPedidos() {
		return this.pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public Pedido addPedido(Pedido pedido) {
		getPedidos().add(pedido);
		pedido.setUsuario(this);

		return pedido;
	}

	public Pedido removePedido(Pedido pedido) {
		getPedidos().remove(pedido);
		pedido.setUsuario(null);

		return pedido;
	}

}