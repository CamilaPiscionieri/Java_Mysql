
public class Registro_empleado {

	private int id_Registro_Empleado;
	private String hora_entrada;
	private String hora_salida;
	private String fecha;
	private Empleado empleado;
	
	public void guardarHoraEntrada(){
		hora_entrada = empleado.guardarHoraFechaEntrada();
	}
	
	public void guardarHoraSalida(){
		hora_salida = empleado.guardarHoraFechaSalida();
	}
}
