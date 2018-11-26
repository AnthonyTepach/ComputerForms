package com.anthonytepach.database;
import com.anthonytepach.configuracion.LoggerRegistros;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
public class ConexionMySql {

    private static Connection objConexion = null;
    private LoggerRegistros log4j = new LoggerRegistros(this.getClass());

    private ConexionMySql() {
        final String user = "root";
        final String pass = "";
        final String server = "jdbc:mysql://192.168.1.166/";
        final String DB = "db_cfprojets";
        final String DriverMySQL = "com.mysql.cj.jdbc.Driver";
        final String zonaHoraria = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        try {
            Class.forName(DriverMySQL);
            objConexion = DriverManager.getConnection(server + DB + zonaHoraria, user, pass);
        } catch (ClassNotFoundException ex) {
            log4j.setFatal(ex.getMessage(), ex.fillInStackTrace());
            JOptionPane.showMessageDialog(new JRootPane(),ex.getException(),"No se encontro la clase Driver",JOptionPane.ERROR_MESSAGE);
        }catch(SQLException ex){
            log4j.setFatal(ex.getMessage(), ex.fillInStackTrace());
            JOptionPane.showMessageDialog(new JRootPane(),ex.fillInStackTrace(),"Error con la conexion a la BD",JOptionPane.ERROR_MESSAGE);
        }
    }
    public static Connection getConnection() {
        if (objConexion == null) {
            new ConexionMySql();
        }
        return objConexion;
    }
}
