
public class Cliente {
	private int id_Cliente;
	private String nombre;
	private String CUIT;
	private TipoCliente tipocliente;
	private Articulo articulo;
	private Factura factura;
	private Encuesta encuesta;
	
	public Cliente(){
		
	}
	
	public Cliente(int id_Cliente){
		this.id_Cliente = id_Cliente;
	}
	
	public Cliente(String nombre, String CUIT, TipoCliente tipocliente){
		this.nombre = nombre;
		this.CUIT = CUIT;
		this.tipocliente = tipocliente;
	}
	
	public void completarEncuesta(){
		encuesta.mostrarEncuesta();
		System.out.println("Encuesta Completada");
		encuesta.guardarFecha();
		encuesta.guardarHora();
	}
	
	public void pagarFactura(TipoFactura tipofactura, TipoDePago tipodepago){
		factura.hacerFactura(tipofactura, tipodepago);
	}
	
	public String getNombre(){
		return nombre;
	}
	
	public String getCUIT(){
		return CUIT;
	}
	
	public String getTipoCliente(){
		return tipocliente.toString();
	}
	
	public int getIdCliente(){
		return id_Cliente;
	}
	
	public void setIdCliente(int id_Cliente){
		this.id_Cliente = id_Cliente;
	}
}
