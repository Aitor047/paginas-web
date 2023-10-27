package prueba_examen_ad;

import java.sql.*;

public class controlador {
    public static void main(String[] args) {
        
    }

    public static void consultarVentas() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
    
            Connection conexion = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/concesionario?allowPublicKeyRetrieval=true&useSSL=false", "root", "1234");
    
            Statement sentencia = conexion.createStatement();
            String sql = "SELECT *, SUM(importe) AS importe_total FROM ventas";
            ResultSet resultado = sentencia.executeQuery(sql);
    
            while (resultado.next()) {
                int id = resultado.getInt("id");
                Date fechaVenta = resultado.getDate("fecha_de_venta");
                int descuento = resultado.getInt("descuento");
                String descripcion = resultado.getString("descripcion");
                float importe = resultado.getFloat("importe");
                String matricula = resultado.getString("matricula_fk");
                String dni = resultado.getString("dni_fk");
                float importeTotal = resultado.getFloat("importe_total");
    
                System.out.println("Venta [ID= " + id + ", Fecha de Venta= " + fechaVenta + ", Descuento= " + descuento
                        + ", Descripción= " + descripcion + ", Importe= " + importe + ", Matrícula= " + matricula
                        + ", DNI del Cliente= " + dni + " ]");
                System.out.println("Importe Total de Todas las Ventas: " + importeTotal);
            }
    
            conexion.close();
            sentencia.close();
            resultado.close();
    
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}