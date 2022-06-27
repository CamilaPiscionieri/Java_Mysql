import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Timer;

public class Aplicacion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Definir un objeto cliente y darle valores
		//Cliente cliente = new Cliente("Marcos","1-4564897",TipoCliente.RESPONSABLEINSCRIPTO);
		
		UsuarioServicio servicio = new UsuarioServicio();
		
		//Insertar un cliente en la tabla Cliente
		//servicio.insertarCliente(cliente);
		
		//Insertar un tipo de articulo en la tabla Tipo_articulo
		//servicio.insertarTipoArticulo(TipoPreparadores.COCINERO.toString());
		
		//Insertar mesas en forma de disponible
		//for(int k = 1;k<5;k++){
			//servicio.insertarMesas(EstadoMesa.DISPONIBLE.toString());
		//}
		
		//Forma de buscar el id del cliente por su nombre
		//Cliente cliente = servicio.getIdClientePorNombre("Juan");
		//Verificacion de que me llega el id correcto
		//System.out.println(cliente.getIdCliente());
		
		
		//Cliente cliente = new Cliente();
		//Insertar un cliente a una mesa por su nombre
		//Y verificar si la mesa esta disponible para ser abierta
		/*servicio.insertarMesa_Cliente("Nahuel", 3);
		if(servicio.verificarEstadoMesa(3)){
			servicio.cambiarEstadoMesa(3,EstadoMesa.ABIERTA.toString());
		}else{
			System.out.println("No se puede cambiar el estado de la mesa");
		}*/
		
		//Insertar un pedido con la hora y la fecha
		//segun el id de la mesa_cliente
		//Verificando que la mesa este pidiendo y que cuando se suba el pedido
		//se cambie el estado a esperando el pedido
		/*
		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		Date date = new Date();
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDate localDate = LocalDate.now();
		
		servicio.insertarPedido(dateFormat.format(date),dtf.format(localDate)
				,EstadoPedido.PENDIENTE.toString(),2,2);
		*/
		/*		
		if(servicio.verificarEstadoMesaCliente(3)){
			servicio.cambiarEstadoMesaCliente(3,EstadoMesa_Cliente.ESPERANDO_PEDIDO.toString());
		}else{
			System.out.println("Esta mesa ya esta esperando su pedido");
		}
		*/
		
		//Cambiar el estado del pedido que esta en pendiente a marchando de forma aleatoria
		/*
		if(servicio.verificarEstadoPedido(1)){
			servicio.cambiarEstadoPedido(1,EstadoPedido.MARCHANDO.toString());
		}else{
			System.out.println("Este pedido ya esta siendo marchando o ya fue entregado");
		}
		*/
		
		
		//Cambiar el estado del pedido que esta en marchando a entregado de forma aleatoria
		/*
		if(servicio.verificarEstadoPedidoMarchando(1)){
			servicio.cambiarEstadoPedido(1,EstadoPedido.ENTREGADO.toString());
		}else{
			System.out.println("Este pedido ya ha sido entregado");
		}
		*/
		
		//Definir un objeto cliente y darle valores
		//Empleado empleado = new Empleado("Juan","Cebilla","45789684","1544544586-8",TipoEmpleado.COCINERO);
		
		//Insertar un empleado en la tabla Empleado
		//servicio.insertarEmpleado(empleado);
		
		//Insertar un tipo de empleado en la tabla Tipo_empleado
		//servicio.insertarTipoEmpleado(TipoEmpleado.MOZO.toString());
		
		//Insertar un articulo
		//servicio.insertarArticulo("Papas", TipoPreparadores.COCINERO.toString(), "20 minutos", 150);
		
		//Insertar datos en la tabla pedido_articulo
		//servicio.insertarPedidoArticulo(1,"Papas",2,150);
		
		//Registrar la hora de entrada y salida del empleado
		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss yyyy/MM/dd");
		Date date = new Date();
		
		servicio.registrarHorarioEmpleado(1, dateFormat.format(date), EstadoRegistro_Empleado.ABIERTO.toString());
		servicio.registrarHorarioEmpleado(1, dateFormat.format(date), EstadoRegistro_Empleado.CERRADO.toString());
		
	}

}
