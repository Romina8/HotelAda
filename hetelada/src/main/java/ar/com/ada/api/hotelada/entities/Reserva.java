package ar.com.ada.api.hotelada.entities;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "Reserva")
public class Reserva{

    @Id
    @Column(name="reserva_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reservaId;
    @Column(name = "fecha_Reserva")
    private Date fechaReserva;
    @Column(name = "fecha_ingreso")
    private Date fechaIngreso;
    @Column(name = "fecha_egreso")
    private Date fechaEgreso;
    private Integer habitacion;
    @Column(name = "import_reserva")
    private BigDecimal importReserva;
    @Column(name = "import_total")
    private BigDecimal importTotal;
    @Column(name = "importe_pagado")
    private BigDecimal importePagado;
    @Column(name = "estado_pago")
    private int estadoPago;
    @ManyToOne
    @JoinColumn(name = "huesped_id", referencedColumnName = "huesped_id")//es el foreing key
    private Huesped huesped;

    public int getReservaId() {
        return reservaId;
    }

    public void setReservaId(int reservaId) {
        this.reservaId = reservaId;
    }

    public Date getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(Date fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Date getFechaEgreso() {
        return fechaEgreso;
    }

    public void setFechaEgreso(Date fechaEgreso) {
        this.fechaEgreso = fechaEgreso;
    }

    public Integer getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Integer habitacion) {
        this.habitacion = habitacion;
    }

    public BigDecimal getImportReserva() {
        return importReserva;
    }

    public void setImportReserva(BigDecimal importReserva) {
        this.importReserva = importReserva;
    }

    public BigDecimal getImportTotal() {
        return importTotal;
    }

    public void setImportTotal(BigDecimal importTotal) {
        this.importTotal = importTotal;
    }

    public BigDecimal getImportePagado() {
        return importePagado;
    }

    public void setImportePagado(BigDecimal importePagado) {
        this.importePagado = importePagado;
    }

    public int getEstadoPago() {
        return estadoPago;
    }

    public void setEstadoPago(int estadoPago) {
        this.estadoPago = estadoPago;
    }

    public Huesped getHuesped() {
        return huesped;
    }

    public void setHuesped(Huesped huesped) {
        this.huesped = huesped;
        this.huesped.getReservas().add(this); //Hay relación biridireccional.
    }


    //por ahora vamos a crear este con int
    //Huesped la dejamos para después

    //Tipos de datos: bando primitivo y bando de objeto.
    //--bando primitivo: int.
    //--bando de objeto: Integer. 

}