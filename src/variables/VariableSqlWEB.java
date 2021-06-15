package variables;

public class VariableSqlWEB {

	
	public static final String BUSCA_CUENTA_TIENDA="select * from cuenta_tienda where EMAIL=?";
	
	public static final String CON_EMIAL_BUSCA_ID_TIENDA="select id_tienda from cuenta_tienda where email=?";
	
	public static final String BUSCA_EMAIL_TIENDA="select email from cuenta_tienda where EMAIL=?";
	
	public static final String REGITARAR_CUENTA_TIENDA="insert into cuenta_tienda values(?,?,default,?,default,?)";
	
	public static final String ANADAIR_TIENDA="insert into tienda values(null,?,?,?,?,?,null,?)";

	public static final String CON_ROWID_BUSCA_IDTIENDA="select ID_tienda from tienda where ROWID=?";

	
	public static final String ANADIR_QR="update tienda set qr=? where id_tienda=?";
	
	public static final String BUSCA_CATEGORIA="select id_categoria from categoria where nombre_categoria=?";
	
	public static final String USAURIO_ENLINEA="update cuenta_tienda set en_linea=? where email=?";
	
	public static final String ACTIVAR_LA_CUENTA="update cuenta_tienda set activado=1 where email=?";
	
	
	public static final String BUSCAR_CODIGO_ACTIVACION="select codigo_activacion from cuenta_tienda where email=?";
	
	public static final String ACTUALIZAR_CODIGO_ACTIVACION="update cuenta_tienda  set codigo_activacion=? where email=?";
	
	
	public static final String BUSCAR_INCORPORAR="Select * from incorporar where id_cola=? and id_usuario=?";
	
	
	public static final String BUSCAR_LISTA_PRODUCTO="SELECT producto.id_producto,precio,producto.nombre,producto.categoria"
			+ ",producto.id_tienda from\r\n"
			+ "        tienda join producto on producto.id_tienda=tienda.id_tienda\r\n"
			+ "         where tienda.id_tienda=? and  producto.nombre like ?";
	
	

	public static final String BUSCAR_COMIDA_CON_ID="SELECT id_producto,ingrediente,url_foto from\r\n"
			+ "        comida where id_producto=?";
	
	
	
	public static final String BUSCAR_SERVICIO_CON_ID="   SELECT id_producto,descripcion from\r\n"
			+ "        servicio where id_producto=?";
	
	
	public static final String BUSCAR_MERCANCIA_CON_QR="  SELECT id_producto, url_foto,descripcion ,stock from\r\n"
			+ "        mercancia where id_producto=?";
	
	
	public static final String BUSCAR_LISTA_PRODUCTOS_USUARIO="select distinct precio,nombre,cantidad_producto,producto.id_producto\r\n"
			+ "from producto join \r\n"
			+ "incorporar on incorporar.id_producto=producto.id_producto\r\n"
			+ "join usuarioencola on usuarioencola.id_cola=incorporar.id_cola\r\n"
			+ "where incorporar.id_cola=? and incorporar.id_usuario=?\r\n"
			+ " and incorporar.cantidad_producto>0"
			+ "and incorporar.estado='E'";
	
	
	
	public static final String BUSCAR_TIENDA_POR_NOMBRE_CALLE="select tienda.nombre, direccion, tienda.id_tienda, nombre_categoria from tienda \r\n"
			+ "join categoria on tienda.id_categoria=categoria.id_categoria\r\n"
			+ "\r\n"
			+ "where nombre like ? or direccion like ? ";


	public static final String ID_TIENDA_BUSCA_PRODUCTO="select * from cola where cola.id_tienda=? and estado='a' and fecha=?";
	
	public static final String LISTAR_RPIMEROS_TURNOS="	select DISTINCT cola.turno_actual, usuario.id_usuario,usuarioencola.turno,formato,usuario.nombre,hora_cancelar,hora_entrada from usuarioencola\r\n"
			+ "		   join usuario on usuario.id_usuario=usuarioencola.id_usuario\r\n"
			+ "            join cola on cola.id_cola=usuarioencola.id_cola\r\n"
			+ "	        where  estado_cliente='E' and usuarioencola.id_cola=?\r\n"
			+ "        \r\n"
			+ "        order by usuarioencola.turno\r\n";

	

	public static final String USUARIO_EN_PROCESO="update  usuarioencola  set ESTADO_CLIENTE='P' , HORA_TERMINADA=? "
			+ "where turno=? "
			+ "and id_cola=?";
	
	
	
	public static final String DEJAR_UTLIMO_USUARIO_P_EN_T="update usuarioencola set estado_cliente='T'"
			+ " where id_cola=? and estado_cliente='P' and id_usuario=?";
	
	
	
	
	public static final String LISTA_CLIENTE_EN_TIENDA="	select DISTINCT usuario.id_usuario,usuarioencola.turno,usuario.nombre from usuarioencola\r\n"
			+ "		   join usuario on usuario.id_usuario=usuarioencola.id_usuario\r\n"      
			+ "	        where  estado_cliente='P' and usuarioencola.id_cola=?\r\n"
			+ "        \r\n"
			+ "        order by usuarioencola.turno\r\n";
	
	
	
	public static final String DEJAR_ESTADO_PRODUCTO_EN_T="update incorporar set estado='T' where  id_cola=? and id_usuario=? ";
	
	
	
	
	
	
	public static final String ACTURALIZAR_TRUNO_ACTUAL="update cola set turno_Actual="
			+ "?"
			+ "where id_cola=?";
	
	
	public static final String TURNO_ACTUAL_EN_COLA="select turno_Actual from cola where id_cola=?";
	
	
	
	public static final String TURNO_QUEDA_EN_COLA="select count (*) from usuarioencola where estado_cliente='E' and id_cola=?";
	
	
	
	
	public static final String CREA_COLA_NUEVA="insert into cola values(null,?,?,'a',0,'cola',0)";
	
	
	public static final String BUSCAR_UTLIMO_ID_COLA="select max(id_cola) from cola";
	
	
	
	public static final String BUSCAR_SI_HAY_COLA_CRADA="select id_cola from cola where id_tienda=? and fecha=? and estado='a'";
	
	
	public static final String SI_HAY_ESTE_TURNO_EN_FILA="select id_usuario from usuarioencola where turno=? and estado_cliente='E'";
	
	
	public static final String CON_ID_TIENDA_BUSCA_TIEMPO_TURNO_ACTUAL="select  turno_actual, tiempomedia ,id_cola from tienda\r\n"
			+ "         join cola on cola.id_tienda=tienda.id_tienda\r\n"
			+ "		where tienda.id_tienda=? and cola.estado='a' and cola.fecha=?";
	
	
	public static final String CON_EMIAL_BUSCA_INFORMACION_TIENDA="select cuenta_tienda.id_tienda , nombre from tienda"
			+ " join cuenta_tienda on cuenta_tienda.id_tienda=tienda.id_tienda "
			+ "where email =?";
	
	
	public static final String BUSCAR_QR_POR_ID_TIENDA="select qr from tienda where id_tienda=?";
	
	
	public static final String ACTIVAR_FILA="update cola set estado='a' where id_cola=?";
	
	
	public static final String DESACTIVAR_FILA="update cola set estado='d' where id_cola=?";
	
	
	public static final String BUSCAR_ESTADO_FILA="select estado from cola  where id_cola=?";
	
	
	public static final String BUSCAR_ID_USER_POR_ID_COLA="select cuenta_usuario.id_usuario from cuenta_usuario\r\n"
			+ "join cuenta_tienda on cuenta_tienda.email=cuenta_usuario.email\r\n"
			+ "join cola on cola.id_tienda=cuenta_tienda.id_tienda\r\n"
			+ "where cola.id_cola=?";
	
	public static final String RESETABLECER_CONTRASENA_TIENDA="update cuenta_tienda set contrasena=? where id_tienda=?";
	
	public static final String RESETABLECER_CONTRASENA_USUAIRO="update cuenta_USUARIO set contrasena=? where id_usuario=?";
}
