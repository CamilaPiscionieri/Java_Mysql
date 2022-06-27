import javax.swing.JOptionPane;

public class Mozo {
	
	private String legajo;
	private Mesa mesa;
	private Pedido pedidos;
	
	public void abrirMesa(int nroMesa){
		//consulta nroMesa y que devuelva el estado
		if(mesa.getMesaDisponible(EstadoMesa.DISPONIBLE)){
			mesa.setEstadoMesa(EstadoMesa.ABIERTA);
			System.out.println("Mesa nro: " + nroMesa + "abierta");
		}
	}
	
	public void cargarPedido(){
		String pedido = JOptionPane.showInputDialog("Introduzca el pedido");
		System.out.println(pedido);
		System.out.println("Pedido cargado");
		pedidos.setEstadoPedido(EstadoPedido.PENDIENTE);
	}
	
	public void marcharPedido(String pedido){
		pedidos.setEstadoPedido(EstadoPedido.MARCHANDO);
	}
	
	public void entragarPedido(){
		pedidos.setEstadoPedido(EstadoPedido.ENTREGADO);
	}
	
	public void limpiarMesa(int nroMesa){
		System.out.println("Limpiando mesa" + nroMesa);
		mesa.setEstadoMesa(EstadoMesa.DISPONIBLE);
	}

}
