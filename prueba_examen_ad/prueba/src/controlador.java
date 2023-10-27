import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class controlador {
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {

        try {
            int seleccion = Integer.parseInt(bf.readLine());

            switch (seleccion) {
                case 1:
                    consultarVentasRealizadas();
                    break;
                case 2:
                    insertarVenta();
                    break;
                default:
                    break;
            }

        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("ERROR");
        }
    }

    public static void insertarVenta() {
        
    
        try {
            Ventas venta = new Ventas();
    
            System.out.println("Escribe la fecha de la venta (YYYY-MM-DD):");
            String fechaVenta = bf.readLine();
            venta.setFecha_de_venta(Date.valueOf(fechaVenta));
    
            System.out.println("Escribe el descuento aplicado:");
            int descuento = Integer.parseInt(bf.readLine());
            venta.setDescuento(descuento);
    
            System.out.println("Escribe una descripción de la venta:");
            String descripcion = bf.readLine();
            venta.setDescripcion(descripcion);
    
            System.out.println("Escribe el importe de la venta:");
            float importe = Float.parseFloat(bf.readLine());
            venta.setImporte(importe);
    
            System.out.println("Escribe la matrícula del vehículo vendido:");
            String matricula = bf.readLine();
            venta.setMatricula_fk(matricula);
    
            System.out.println("Escribe el DNI del cliente que realizó la compra:");
            String dniCliente = bf.readLine();
            venta.setDni_fk(dniCliente);
    
            Class.forName("com.mysql.jdbc.Driver");
    
            Connection conexion = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/concesionario?allowPublicKeyRetrieval=true&useSSL=false", "root", "1234");
    
            String insert = "INSERT INTO ventas (fecha_de_venta, descuento, descripcion, importe, matricula_fk, dni_fk) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conexion.prepareStatement(insert);
            ps.setDate(1, venta.getFecha_de_venta());
            ps.setInt(2, venta.getDescuento());
            ps.setString(3, venta.getDescripcion());
            ps.setFloat(4, venta.getImporte());
            ps.setString(5, venta.getMatricula_fk());
            ps.setString(6, venta.getDni_fk());
    
            int valorConsulta = ps.executeUpdate();
            System.out.println("Venta registrada con éxito. Filas afectadas: " + valorConsulta);
    
            conexion.close();
            ps.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void consultarVentasRealizadas() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
    
            Connection conexion = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/concesionario?allowPublicKeyRetrieval=true&useSSL=false", "root", "1234");
    
            Statement sentencia = conexion.createStatement();
            String sql = "SELECT * FROM ventas WHERE importe > 0";
            ResultSet resultado = sentencia.executeQuery(sql);
    
            while (resultado.next()) {
                Ventas venta = new Ventas(); // Crear una instancia de la clase Ventas
    
                venta.setId(resultado.getInt("id"));
                venta.setFecha_de_venta(resultado.getDate("fecha_de_venta"));
                venta.setDescuento(resultado.getInt("descuento"));
                venta.setDescripcion(resultado.getString("descripcion"));
                venta.setImporte(resultado.getFloat("importe"));
                venta.setMatricula_fk(resultado.getString("matricula_fk"));
                venta.setDni_fk(resultado.getString("dni_fk"));
    
                System.out.println("Venta [ID= " + venta.getId() + ", Fecha de Venta= " + venta.getFecha_de_venta() + ", Descuento= " + venta.getDescuento()
                    + ", Descripción= " + venta.getDescripcion() + ", Importe= " + venta.getImporte() + ", Matrícula= " + venta.getMatricula_fk()
                    + ", DNI del Cliente= " + venta.getDni_fk() + " ]");
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