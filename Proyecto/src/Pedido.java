
public class Pedido {
	
	private int id_Pedido;
	private String hora_pedido;
	private String fecha_pedido;
	private EstadoPedido estadopedido;
	
	public void setEstadoPedido(EstadoPedido estado){
		System.out.println(estado);
	}

}
