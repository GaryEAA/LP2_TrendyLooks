package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the pedido database table.
 * 
 */
@Entity
@NamedQuery(name="Pedido.findAll", query="SELECT p FROM Pedido p")
public class Pedido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int codPed;

	private int canprodPed;

	private String contPed;

	private String dirPed;

	@Temporal(TemporalType.DATE)
	private Date fecPed;

	private String telPed;

	private double totPed;

	//bi-directional many-to-one association to Detallepedido
	@OneToMany(mappedBy="pedido")
	private List<Detallepedido> detallepedidos;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="codUsu")
	private Usuario usuario;

	public Pedido() {
	}

	public int getCodPed() {
		return this.codPed;
	}

	public void setCodPed(int codPed) {
		this.codPed = codPed;
	}

	public int getCanprodPed() {
		return this.canprodPed;
	}

	public void setCanprodPed(int canprodPed) {
		this.canprodPed = canprodPed;
	}

	public String getContPed() {
		return this.contPed;
	}

	public void setContPed(String contPed) {
		this.contPed = contPed;
	}

	public String getDirPed() {
		return this.dirPed;
	}

	public void setDirPed(String dirPed) {
		this.dirPed = dirPed;
	}

	public Date getFecPed() {
		return this.fecPed;
	}

	public void setFecPed(Date fecPed) {
		this.fecPed = fecPed;
	}

	public String getTelPed() {
		return this.telPed;
	}

	public void setTelPed(String telPed) {
		this.telPed = telPed;
	}

	public double getTotPed() {
		return this.totPed;
	}

	public void setTotPed(double totPed) {
		this.totPed = totPed;
	}

	public List<Detallepedido> getDetallepedidos() {
		return this.detallepedidos;
	}

	public void setDetallepedidos(List<Detallepedido> detallepedidos) {
		this.detallepedidos = detallepedidos;
	}

	public Detallepedido addDetallepedido(Detallepedido detallepedido) {
		getDetallepedidos().add(detallepedido);
		detallepedido.setPedido(this);

		return detallepedido;
	}

	public Detallepedido removeDetallepedido(Detallepedido detallepedido) {
		getDetallepedidos().remove(detallepedido);
		detallepedido.setPedido(null);

		return detallepedido;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}