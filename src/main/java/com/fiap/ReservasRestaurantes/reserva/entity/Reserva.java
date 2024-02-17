package com.fiap.ReservasRestaurantes.reserva.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fiap.ReservasRestaurantes.cliente.entity.Cliente;
import com.fiap.ReservasRestaurantes.mesa.entity.Mesa;
import com.fiap.ReservasRestaurantes.reserva.entity.enumerations.StatusReservaEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name = "reserva")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Reserva {

    @Id
    @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 

    @ManyToOne
    @JoinColumn(name = "cliente_id", referencedColumnName = "id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "mesa_id", referencedColumnName = "id")
    private Mesa mesa;

    @Column
    private int numPessoas;

    @Column(nullable = false, columnDefinition = "DATE")
    private LocalDate dataReserva;

    @Column(nullable = false, columnDefinition = "DATE")
    private LocalDate dataCriacao;

    @Column(nullable = false, columnDefinition = "DATE")
    private LocalDate inicioReserva;

    @Column
    private int toleranciaMinutos;

    @Column(nullable = false, columnDefinition = "DATE")
    private LocalDate horarioLimite;

    @Column
    private StatusReservaEnum status; 
    
}
