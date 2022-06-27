import javax.swing.JOptionPane;

public class Empleado {
	
	private String legajo;
	private String nombre_empleado;
	private String apellido_empleado;
	private String DNI_empleado;
	private String CUIL_empleado;
	private TipoEmpleado tipoempleado;
	private boolean conectado = true;
	private boolean desconectado = false;
	
	public Empleado(String nombre_empleado, String apellido_empleado,String DNI_empleado
			,String CUIL_empleado, TipoEmpleado tipoempleado){
		this.nombre_empleado = nombre_empleado;
		this.apellido_empleado = apellido_empleado;
		this.DNI_empleado = DNI_empleado;
		this.CUIL_empleado = CUIL_empleado;
		this.tipoempleado = tipoempleado;
	}
	
	public void iniciarSesion(String usuario,String contrasenia,TipoEmpleado tipoempleado){
	if(validarEmpleado(tipoempleado)){
		if(usuario.equalsIgnoreCase("") && contrasenia.equalsIgnoreCase("")){
			guardarHoraFechaEntrada();
			conectarUsuario();
			System.out.println("Inicio Sesion exitosamente");
		}else{
			System.out.println("Usuario o contrasenia incorrectos");
		}
	}else{
		System.out.println("No tiene permisos para acceder al sistema");
	}
	}
	
	public void cerrarSesion(){
		if(conectarUsuario()){
			String confirmacion = JOptionPane.showInputDialog("Desea cerrar sesion?");
			if(confirmacion.equalsIgnoreCase("SI")){
				guardarHoraFechaSalida();
				desconectarUsuario();
				System.out.println("Ha cerrado sesion exitosamente");
			}else{
				//...
			}
		}
	}
	
	public boolean validarEmpleado(TipoEmpleado tipoempleado){
		return tipoempleado == TipoEmpleado.MOZO || tipoempleado == TipoEmpleado.BARTENDER
		|| tipoempleado == TipoEmpleado.CANDYBAR || tipoempleado == TipoEmpleado.CERVECERO
		|| tipoempleado == TipoEmpleado.COCINERO || tipoempleado == TipoEmpleado.EMPLEADO_ADMINISTRATIVO;
	}
	
	public String guardarHoraFechaEntrada(){
		return "SYSDATE";
	}
	
	public String guardarHoraFechaSalida(){
		return "SYSDATE";
	}
	
	public boolean conectarUsuario(){
		return conectado;
	}
	
	public boolean desconectarUsuario(){
		return desconectado;
	}

	public String getLegajo() {
		return legajo;
	}

	public void setLegajo(String legajo) {
		this.legajo = legajo;
	}

	public String getNombre_empleado() {
		return nombre_empleado;
	}

	public void setNombre_empleado(String nombre_empleado) {
		this.nombre_empleado = nombre_empleado;
	}

	public String getApellido_empleado() {
		return apellido_empleado;
	}

	public void setApellido_empleado(String apellido_empleado) {
		this.apellido_empleado = apellido_empleado;
	}

	public String getDNI_empleado() {
		return DNI_empleado;
	}

	public void setDNI_empleado(String dNI_empleado) {
		DNI_empleado = dNI_empleado;
	}

	public String getTipoempleado() {
		return tipoempleado.toString();
	}

	public void setTipoempleado(TipoEmpleado tipoempleado) {
		this.tipoempleado = tipoempleado;
	}

	public String getCUIL_empleado() {
		return CUIL_empleado;
	}

	public void setCUIL_empleado(String cUIL_empleado) {
		CUIL_empleado = cUIL_empleado;
	}
	
	

}
