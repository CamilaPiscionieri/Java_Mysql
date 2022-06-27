
public class Encuesta {
	
	private int id_Encuesta;
	private String hora_encuesta;
	private String fecha_encuesta;
	
	public void mostrarEncuesta(){
		System.out.println("..............");
	}
	
	public void guardarFecha(){
		fecha_encuesta = "SYSDATE";
	}
	
	public void guardarHora(){
		hora_encuesta = "SYSDATE";
	}

}
