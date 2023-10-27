import java.sql.Date;

public class Ventas {
    private int id;
    private Date fecha_de_venta;
    private int descuento;
    private String descripcion;
    private float importe;
    private String matricula_fk;
    private String dni_fk;

    // Getters y setters para cada atributo
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha_de_venta() {
        return fecha_de_venta;
    }

    public void setFecha_de_venta(Date fecha_de_venta) {
        this.fecha_de_venta = fecha_de_venta;
    }

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getImporte() {
        return importe;
    }

    public void setImporte(float importe) {
        this.importe = importe;
    }

    public String getMatricula_fk() {
        return matricula_fk;
    }

    public void setMatricula_fk(String matricula_fk) {
        this.matricula_fk = matricula_fk;
    }

    public String getDni_fk() {
        return dni_fk;
    }

    public void setDni_fk(String dni_fk) {
        this.dni_fk = dni_fk;
    }
}
