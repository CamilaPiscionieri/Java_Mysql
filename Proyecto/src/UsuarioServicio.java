import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioServicio {
	
    private final String INSERT_STATEMENT = "INSERT INTO cliente"
            + "(Nombre_cliente,CUIT_cliente,Tipo_cliente) VALUES "
            + "(?,?,?)";
    
    private final String INSERT_EMPLEADO_STATEMENT = "INSERT INTO empleado"
            + "(Nombre_empleado,Apellido_empleado,DNI,CUIL,Tipo_empleado) VALUES "
            + "(?,?,?,?,?)";
    
    private final String INSERT_STATEMENT_PEDIDO = "INSERT INTO pedido"
    		+ "(Hora_pedido,Fecha_pedido,Estado_pedido,id_Mesa_Cliente,Legajo) VALUES"
    		+ "(?,?,?,?,?)";
    
    private final String INSERT_STATEMENT_PEDIDO_ARTICULO = "INSERT INTO pedido_articulo"
    		+ "(id_Pedido,id_Articulo,Cantidad_pedido_articulo,Precio_pedido_articulo) VALUES"
    		+ "(?,?,?,?)";
    
    private final String INSERT_STATEMENT_ARTICULO = "INSERT INTO articulo"
    		+ "(Nombre_articulo,id_Tipo_articulo,Tiempo_preparacion_articulo,Precio_articulo) VALUES"
    		+ "(?,?,?,?)";
    
    private final String INSERT_STATEMENT_TIPO_ARTICULO = "INSERT INTO tipo_articulo"
    		+ "(Tipo_articulo) VALUES"
    		+ "(?)";
    
    private final String INSERT_STATEMENT_TIPO_EMPLEADO = "INSERT INTO tipo_empleado"
    		+ "(Tipo_empleado) VALUES"
    		+ "(?)";
    
    private final String INSERT_STATEMENT_MESA = "INSERT INTO mesa"
    		+ "(Estado_Mesa) VALUES"
    		+ "(?)";
    
    private final String INSERT_STATEMENT_REGISTRO_EMPLEADO = "INSERT INTO registro_empleado"
    		+ "(Legajo,Hora_entrada,Estado_registro_empleado) VALUES"
    		+ "(?,?,?)";
    
    private final String INSERT_STATEMENT_MESA_CLIENTE = "INSERT INTO mesa_cliente"
    		+ "(id_Mesa,id_Cliente,Estado_Mesa_Cliente) VALUES"
    		+ "(?,?,?)";
    
    private final String SELECT_BY_NAME_STATEMENT = "SELECT id_Cliente "
            + " FROM cliente"
            + " WHERE Nombre_cliente = ? ";
    
    private final String SELECT_BY_NAME_TIPO_ARTICULO_STATEMENT = "SELECT id_Tipo_articulo "
            + " FROM tipo_articulo"
            + " WHERE Tipo_articulo = ? ";
    
    private final String SELECT_BY_NAME_ARTICULO_STATEMENT = "SELECT id_Articulo "
            + " FROM articulo"
            + " WHERE Nombre_articulo = ? ";
    
    private final String SELECT_BY_ESTADO_STATEMENT = "SELECT Estado_Mesa "
            + " FROM mesa"
            + " WHERE id_Mesa = ? ";
    
    private final String SELECT_BY_ESTADO_PEDIDO_STATEMENT = "SELECT Estado_pedido "
            + " FROM pedido"
            + " WHERE id_Pedido = ? ";
    
    private final String SELECT_BY_ESTADO_MESA_CLIENTE_STATEMENT = "SELECT Estado_Mesa_Cliente "
            + " FROM mesa_cliente"
            + " WHERE id_Mesa_Cliente = ? ";
    
    private final String UPDATE_MESA_STATEMENT = "UPDATE mesa "
            + " SET Estado_Mesa = ? "
            + " WHERE id_Mesa = ?";
    
    private final String UPDATE_MESA_CLIENTE_STATEMENT = "UPDATE mesa_cliente "
            + " SET Estado_Mesa_Cliente = ? "
            + " WHERE id_Mesa_Cliente = ?";
    
    private final String UPDATE_PEDIDO_STATEMENT = "UPDATE pedido "
            + " SET Estado_pedido = ? "
            + " WHERE id_Pedido = ?";
    
    private final String UPDATE_HORARIO_EMPLEADO_STATEMENT = "UPDATE registro_empleado "
            + " SET Estado_registro_empleado = ? AND Hora_salida = ? "
            + " WHERE id_Registro_empleado = (SELECT MAX(id_Registro_empleado) FROM registro_empleado"
    		+ "WHERE Legajo = ?)";
    
    //Ingresar un cliente nuevo
    public void insertarCliente(Cliente cliente) {

        Connection conexion = null;
        PreparedStatement preparedStmtInsercion = null;

        try {

            conexion = AdministradorDeConexiones.getConnection();
            preparedStmtInsercion = conexion.prepareStatement(INSERT_STATEMENT);
            preparedStmtInsercion.setString(1, cliente.getNombre());
            preparedStmtInsercion.setString(2, cliente.getCUIT());
            preparedStmtInsercion.setString(3, cliente.getTipoCliente());
            preparedStmtInsercion.execute();

        } catch (ReflectiveOperationException | SQLException ex) {
            Logger.getLogger(UsuarioServicio.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (preparedStmtInsercion != null) {
                try {
                    preparedStmtInsercion.close();
                    conexion.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioServicio.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    //Ingresar un nuevo tipo de articulo
    public void insertarTipoArticulo(String tipopreparador){
    	
    	Connection conexion = null;
        PreparedStatement preparedStmtInsercion = null;

        try {

            conexion = AdministradorDeConexiones.getConnection();
            preparedStmtInsercion = conexion.prepareStatement(INSERT_STATEMENT_TIPO_ARTICULO);
            preparedStmtInsercion.setString(1, tipopreparador);
            preparedStmtInsercion.execute();

        } catch (ReflectiveOperationException | SQLException ex) {
            Logger.getLogger(UsuarioServicio.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (preparedStmtInsercion != null) {
                try {
                    preparedStmtInsercion.close();
                    conexion.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioServicio.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    //Ingresar mesas en esta disponible
    public void insertarMesas(String mesas){
    	
    	Connection conexion = null;
        PreparedStatement preparedStmtInsercion = null;

        try {

            conexion = AdministradorDeConexiones.getConnection();
            preparedStmtInsercion = conexion.prepareStatement(INSERT_STATEMENT_MESA);
            preparedStmtInsercion.setString(1, mesas);
            preparedStmtInsercion.execute();

        } catch (ReflectiveOperationException | SQLException ex) {
            Logger.getLogger(UsuarioServicio.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (preparedStmtInsercion != null) {
                try {
                    preparedStmtInsercion.close();
                    conexion.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioServicio.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    //Asignar una mesa con su cliente por su nombre y el id de la mesa
    public void insertarMesa_Cliente(String Nombre_cliente, int id_Mesa){
    	
    	Connection conexion = null;
        PreparedStatement preparedStmtInsercion = null;

        try {

        	if(verificarEstadoMesa(id_Mesa)){
        		
                conexion = AdministradorDeConexiones.getConnection();
                preparedStmtInsercion = conexion.prepareStatement(INSERT_STATEMENT_MESA_CLIENTE);
                preparedStmtInsercion.setInt(1, id_Mesa);
                preparedStmtInsercion.setInt(2, getIdClientePorNombre(Nombre_cliente));
                preparedStmtInsercion.setString(3, "Pidiendo");
                preparedStmtInsercion.execute();
                
        	}else{
        		System.out.println("No se puede ocupar una mesa que ya esta abierta");
        	}

        } catch (ReflectiveOperationException | SQLException ex) {
            Logger.getLogger(UsuarioServicio.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (preparedStmtInsercion != null) {
                try {
                    preparedStmtInsercion.close();
                    conexion.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioServicio.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    //Cambiar el estado de la mesa (por su id)
    public void cambiarEstadoMesa(int id_Mesa,String estado){
    	
    	Connection conexion = null;
        PreparedStatement preparedStmtActualizar = null;

        try {

            conexion = AdministradorDeConexiones.getConnection();
            preparedStmtActualizar = conexion.prepareStatement(UPDATE_MESA_STATEMENT);
            preparedStmtActualizar.setString(1, estado);
            preparedStmtActualizar.setInt(2, id_Mesa);
            preparedStmtActualizar.execute();

        } catch (ReflectiveOperationException | SQLException ex) {
            Logger.getLogger(UsuarioServicio.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (preparedStmtActualizar != null) {
                try {
                	preparedStmtActualizar.close();
                    conexion.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioServicio.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    //Obtener el id del cliente por su nombre
    public int getIdClientePorNombre(String Nombre_cliente){

        Connection conexion = null;
        PreparedStatement preparedStmtbuscar = null;
        int id = 0;

        try {
            conexion = AdministradorDeConexiones.getConnection();
            preparedStmtbuscar = conexion.prepareStatement(
                    SELECT_BY_NAME_STATEMENT);
            preparedStmtbuscar.setString(1, Nombre_cliente);
            ResultSet rs = preparedStmtbuscar.executeQuery();

            if (rs.next()) {
            	id = rs.getInt("id_Cliente");
            } else {
                System.out.println("No existe usuario para el usuario: " + Nombre_cliente);
            }
        } catch (SQLException | ReflectiveOperationException ex) {
            Logger.getLogger(UsuarioServicio.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (conexion != null) {
                    preparedStmtbuscar.close();
                    conexion.close();
                }
            } catch (SQLException e) {
            }
        }
        return id;
    }
    
    //Verificar si la mesa puede ser ocupada (para ser ocupada debe estar disponible)
    public boolean verificarEstadoMesa(int id_Mesa){

        Connection conexion = null;
        PreparedStatement preparedStmtbuscar = null;
        String estado_mesa = null;

        try {
            conexion = AdministradorDeConexiones.getConnection();
            preparedStmtbuscar = conexion.prepareStatement(
            		SELECT_BY_ESTADO_STATEMENT);
            preparedStmtbuscar.setInt(1, id_Mesa);
            ResultSet rs = preparedStmtbuscar.executeQuery();

            if (rs.next()) {
            	estado_mesa = rs.getString("Estado_Mesa");
            } else {
                System.out.println("No existe esa ID de mesa");
            }
        } catch (SQLException | ReflectiveOperationException ex) {
            Logger.getLogger(UsuarioServicio.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (conexion != null) {
                    preparedStmtbuscar.close();
                    conexion.close();
                }
            } catch (SQLException e) {
            }
        }
        return estado_mesa.equalsIgnoreCase("Disponible");
    }
    
    //Verificar el estado de la mesa segun el id de la mesa cliente
    public boolean verificarEstadoMesaCliente(int id_Mesa_Cliente){

        Connection conexion = null;
        PreparedStatement preparedStmtbuscar = null;
        String estado_mesa = null;

        try {
            conexion = AdministradorDeConexiones.getConnection();
            preparedStmtbuscar = conexion.prepareStatement(
            		SELECT_BY_ESTADO_MESA_CLIENTE_STATEMENT);
            preparedStmtbuscar.setInt(1, id_Mesa_Cliente);
            ResultSet rs = preparedStmtbuscar.executeQuery();

            if (rs.next()) {
            	estado_mesa = rs.getString("Estado_Mesa_Cliente");
            } else {
                System.out.println("No existe esa ID de mesa");
            }
        } catch (SQLException | ReflectiveOperationException ex) {
            Logger.getLogger(UsuarioServicio.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (conexion != null) {
                    preparedStmtbuscar.close();
                    conexion.close();
                }
            } catch (SQLException e) {
            }
        }
        return estado_mesa.equalsIgnoreCase("Pidiendo");
    }
    
    //Ingresar un pedido con su hora y fecha, con la seleccion de la mesa con el cliente
	public void insertarPedido(String Hora_pedido,String Fecha_pedido
			 ,String Estado_pedido,int id_Mesa_Cliente, int Legajo){
	    	
	    	Connection conexion = null;
	        PreparedStatement preparedStmtInsercion = null;
	
	        try {
	        	
	        	if(verificarEstadoMesaCliente(id_Mesa_Cliente)){
	        		
		        	conexion = AdministradorDeConexiones.getConnection();
			        preparedStmtInsercion = conexion.prepareStatement(INSERT_STATEMENT_PEDIDO);
			        preparedStmtInsercion.setString(1, Hora_pedido);
			        preparedStmtInsercion.setString(2, Fecha_pedido);
			        preparedStmtInsercion.setString(3, Estado_pedido);
			        preparedStmtInsercion.setInt(4, id_Mesa_Cliente);
			        preparedStmtInsercion.setInt(5, Legajo);
			        preparedStmtInsercion.execute();	
	        		
	        	}else{
	        		System.out.println("No se puede cambiar el estado de una mesa que no esta"
	        				+ "pidiendo");
	        	}
	
	        } catch (ReflectiveOperationException | SQLException ex) {
	            Logger.getLogger(UsuarioServicio.class.getName()).log(Level.SEVERE, null, ex);
	        } finally {
	            if (preparedStmtInsercion != null) {
	                try {
	                    preparedStmtInsercion.close();
	                    conexion.close();
	                } catch (SQLException ex) {
	                    Logger.getLogger(UsuarioServicio.class.getName()).log(Level.SEVERE, null, ex);
	                }
	            }
	        }
	    }
	
    //Cambiar el estado de la mesa con su cliente (por su id)
    public void cambiarEstadoMesaCliente(int id_Mesa_Cliente,String estado){
    	
    	Connection conexion = null;
        PreparedStatement preparedStmtActualizar = null;

        try {

            conexion = AdministradorDeConexiones.getConnection();
            preparedStmtActualizar = conexion.prepareStatement(UPDATE_MESA_CLIENTE_STATEMENT);
            preparedStmtActualizar.setString(1, estado);
            preparedStmtActualizar.setInt(2, id_Mesa_Cliente);
            preparedStmtActualizar.execute();

        } catch (ReflectiveOperationException | SQLException ex) {
            Logger.getLogger(UsuarioServicio.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (preparedStmtActualizar != null) {
                try {
                	preparedStmtActualizar.close();
                    conexion.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioServicio.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    //Cambiar el estado del pedido por su id a marchando
    public void cambiarEstadoPedido(int id_Pedido,String estado){
    	
    	Connection conexion = null;
        PreparedStatement preparedStmtActualizar = null;

        try {

            conexion = AdministradorDeConexiones.getConnection();
            preparedStmtActualizar = conexion.prepareStatement(UPDATE_PEDIDO_STATEMENT);
            preparedStmtActualizar.setString(1, estado);
            preparedStmtActualizar.setInt(2, id_Pedido);
            preparedStmtActualizar.execute();

        } catch (ReflectiveOperationException | SQLException ex) {
            Logger.getLogger(UsuarioServicio.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (preparedStmtActualizar != null) {
                try {
                	preparedStmtActualizar.close();
                    conexion.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioServicio.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    //Verificar el estado del estado si es que se puede marchar si esta en pendiente
    public boolean verificarEstadoPedido(int id_Pedido){

        Connection conexion = null;
        PreparedStatement preparedStmtbuscar = null;
        String estado_pedido = null;

        try {
            conexion = AdministradorDeConexiones.getConnection();
            preparedStmtbuscar = conexion.prepareStatement(
            		SELECT_BY_ESTADO_PEDIDO_STATEMENT);
            preparedStmtbuscar.setInt(1, id_Pedido);
            ResultSet rs = preparedStmtbuscar.executeQuery();

            if (rs.next()) {
            	estado_pedido = rs.getString("Estado_pedido");
            } else {
                System.out.println("No existe esa ID de pedido");
            }
        } catch (SQLException | ReflectiveOperationException ex) {
            Logger.getLogger(UsuarioServicio.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (conexion != null) {
                    preparedStmtbuscar.close();
                    conexion.close();
                }
            } catch (SQLException e) {
            }
        }
        return estado_pedido.equalsIgnoreCase("Pendiente");
    }
    
    //Verificar el estado del estado si es que se puede entregar si esta en marchando
    public boolean verificarEstadoPedidoMarchando(int id_Pedido){

        Connection conexion = null;
        PreparedStatement preparedStmtbuscar = null;
        String estado_pedido = null;

        try {
            conexion = AdministradorDeConexiones.getConnection();
            preparedStmtbuscar = conexion.prepareStatement(
            		SELECT_BY_ESTADO_PEDIDO_STATEMENT);
            preparedStmtbuscar.setInt(1, id_Pedido);
            ResultSet rs = preparedStmtbuscar.executeQuery();

            if (rs.next()) {
            	estado_pedido = rs.getString("Estado_pedido");
            } else {
                System.out.println("No existe esa ID de pedido");
            }
        } catch (SQLException | ReflectiveOperationException ex) {
            Logger.getLogger(UsuarioServicio.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (conexion != null) {
                    preparedStmtbuscar.close();
                    conexion.close();
                }
            } catch (SQLException e) {
            }
        }
        return estado_pedido.equalsIgnoreCase("Marchando");
    }
    
    //Ingresar un empleado nuevo
    public void insertarEmpleado(Empleado empleado) {

        Connection conexion = null;
        PreparedStatement preparedStmtInsercion = null;

        try {

            conexion = AdministradorDeConexiones.getConnection();
            preparedStmtInsercion = conexion.prepareStatement(INSERT_EMPLEADO_STATEMENT);
            preparedStmtInsercion.setString(1, empleado.getNombre_empleado());
            preparedStmtInsercion.setString(2, empleado.getApellido_empleado());
            preparedStmtInsercion.setString(3, empleado.getDNI_empleado());
            preparedStmtInsercion.setString(4, empleado.getCUIL_empleado());
            preparedStmtInsercion.setString(5, empleado.getTipoempleado());
            preparedStmtInsercion.execute();

        } catch (ReflectiveOperationException | SQLException ex) {
            Logger.getLogger(UsuarioServicio.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (preparedStmtInsercion != null) {
                try {
                    preparedStmtInsercion.close();
                    conexion.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioServicio.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    //Ingresar un nuevo tipo de empleado
    public void insertarTipoEmpleado(String tipoempleado){
    	
    	Connection conexion = null;
        PreparedStatement preparedStmtInsercion = null;

        try {

            conexion = AdministradorDeConexiones.getConnection();
            preparedStmtInsercion = conexion.prepareStatement(INSERT_STATEMENT_TIPO_EMPLEADO);
            preparedStmtInsercion.setString(1, tipoempleado);
            preparedStmtInsercion.execute();

        } catch (ReflectiveOperationException | SQLException ex) {
            Logger.getLogger(UsuarioServicio.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (preparedStmtInsercion != null) {
                try {
                    preparedStmtInsercion.close();
                    conexion.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioServicio.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    //Ingresar un artiuclo
    public void insertarArticulo(String nombreArticulo, String id_Tipo_articulo
    		, String Tiempo_preparacion, int Precio_articulo){
    	
    	Connection conexion = null;
        PreparedStatement preparedStmtInsercion = null;

        try {

            conexion = AdministradorDeConexiones.getConnection();
            preparedStmtInsercion = conexion.prepareStatement(INSERT_STATEMENT_ARTICULO);
            preparedStmtInsercion.setString(1, nombreArticulo);
            preparedStmtInsercion.setInt(2, getIdTipoArticuloPorNombre(id_Tipo_articulo));
            preparedStmtInsercion.setString(3, Tiempo_preparacion);
            preparedStmtInsercion.setInt(4, Precio_articulo);
            preparedStmtInsercion.execute();

        } catch (ReflectiveOperationException | SQLException ex) {
            Logger.getLogger(UsuarioServicio.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (preparedStmtInsercion != null) {
                try {
                    preparedStmtInsercion.close();
                    conexion.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioServicio.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    //Obtener el id del tipo articulo por su nombre
    public int getIdTipoArticuloPorNombre(String Nombre_articulo){

        Connection conexion = null;
        PreparedStatement preparedStmtbuscar = null;
        int id = 0;

        try {
            conexion = AdministradorDeConexiones.getConnection();
            preparedStmtbuscar = conexion.prepareStatement(
                    SELECT_BY_NAME_TIPO_ARTICULO_STATEMENT);
            preparedStmtbuscar.setString(1, Nombre_articulo);
            ResultSet rs = preparedStmtbuscar.executeQuery();

            if (rs.next()) {
            	id = rs.getInt("id_Tipo_articulo");
            } else {
                System.out.println("No existe articulo: " + Nombre_articulo);
            }
        } catch (SQLException | ReflectiveOperationException ex) {
            Logger.getLogger(UsuarioServicio.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (conexion != null) {
                    preparedStmtbuscar.close();
                    conexion.close();
                }
            } catch (SQLException e) {
            }
        }
        return id;
    }
    
    //Ingresar pedido_artiuclo
    public void insertarPedidoArticulo(int id_Pedido, String id_Articulo
    		, int Cantidad_pedido_articulo, int Precio_pedido_articulo){
    	
    	Connection conexion = null;
        PreparedStatement preparedStmtInsercion = null;

        try {

            conexion = AdministradorDeConexiones.getConnection();
            preparedStmtInsercion = conexion.prepareStatement(INSERT_STATEMENT_PEDIDO_ARTICULO);
            preparedStmtInsercion.setInt(1, id_Pedido);
            preparedStmtInsercion.setInt(2, getIdArticuloPorNombre(id_Articulo));
            preparedStmtInsercion.setInt(3, Cantidad_pedido_articulo);
            preparedStmtInsercion.setInt(4, Precio_pedido_articulo*Cantidad_pedido_articulo);
            preparedStmtInsercion.execute();

        } catch (ReflectiveOperationException | SQLException ex) {
            Logger.getLogger(UsuarioServicio.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (preparedStmtInsercion != null) {
                try {
                    preparedStmtInsercion.close();
                    conexion.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioServicio.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    //Obtener el id del articulo por su nombre
    public int getIdArticuloPorNombre(String Nombre_articulo){

        Connection conexion = null;
        PreparedStatement preparedStmtbuscar = null;
        int id = 0;

        try {
            conexion = AdministradorDeConexiones.getConnection();
            preparedStmtbuscar = conexion.prepareStatement(
                    SELECT_BY_NAME_ARTICULO_STATEMENT);
            preparedStmtbuscar.setString(1, Nombre_articulo);
            ResultSet rs = preparedStmtbuscar.executeQuery();

            if (rs.next()) {
            	id = rs.getInt("id_Articulo");
            } else {
                System.out.println("No existe articulo: " + Nombre_articulo);
            }
        } catch (SQLException | ReflectiveOperationException ex) {
            Logger.getLogger(UsuarioServicio.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (conexion != null) {
                    preparedStmtbuscar.close();
                    conexion.close();
                }
            } catch (SQLException e) {
            }
        }
        return id;
    }
    
    
    public void registrarHorarioEmpleado(int Legajo, String Hora_actual, String Estado_registro_empleado){
    	
    	Connection conexion = null;
        PreparedStatement preparedStmtInsercion = null;

        try {
        		
            conexion = AdministradorDeConexiones.getConnection();
            preparedStmtInsercion = conexion.prepareStatement(INSERT_STATEMENT_REGISTRO_EMPLEADO);
            preparedStmtInsercion.setInt(1, Legajo);
            preparedStmtInsercion.setString(2, Hora_actual);
            preparedStmtInsercion.setString(3, Estado_registro_empleado);
            preparedStmtInsercion.execute();

        } catch (ReflectiveOperationException | SQLException ex) {
            Logger.getLogger(UsuarioServicio.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (preparedStmtInsercion != null) {
                try {
                    preparedStmtInsercion.close();
                    conexion.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioServicio.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }  
    
}
