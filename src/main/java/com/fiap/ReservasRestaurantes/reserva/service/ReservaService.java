package com.fiap.ReservasRestaurantes.reserva.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiap.ReservasRestaurantes.cliente.entity.Cliente;
import com.fiap.ReservasRestaurantes.excecoes.ResourceNotFoundException;
import com.fiap.ReservasRestaurantes.reserva.DTO.ReservaDTO;
import com.fiap.ReservasRestaurantes.reserva.entity.Reserva;
import com.fiap.ReservasRestaurantes.reserva.repository.ReservaRepository;
import com.fiap.ReservasRestaurantes.restaurante.entity.Restaurante;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    // add
    public ReservaDTO inserirReserva(ReservaDTO reservaDTO) {
        Reserva reserva = toEntity(reservaDTO);

        // Salva o novo Reserva no repositório
        reserva = reservaRepository.save(reserva);

        // Retorna o novo reserva
        return toDTO(reserva);
    }

    // read all
    public List<Reserva> buscarReservas() {
        return reservaRepository.findAll();
    }

    // read
    public Optional<Reserva> buscarReserva(Long id) {
        return reservaRepository.findById(id);
    }

    // delete
    public String excluirReserva(Long id) throws ResourceNotFoundException {
        try {
            Reserva reserva = reservaRepository.findById(id)
                    .orElseThrow(
                            () -> new ResourceNotFoundException("Reserva não encontrado para este id :: " + id));

            reservaRepository.deleteById(reserva.getId());
        } catch (Exception e) {
            throw new ResourceNotFoundException("Reserva não encontrado para este id :: " + id);
        }
        return "Reserva excluído com sucesso!";
    }

    public ReservaDTO toDTO(Reserva reserva) {
        return new ReservaDTO(
                reserva.getId(),
                reserva.getCliente(),
                reserva.getRestaurante(),
                reserva.getMesa(),
                reserva.getNumPessoas(),
                reserva.getDataReserva(),
                reserva.getDataCriacao(),
                reserva.getInicioReserva(),
                reserva.getToleranciaMinutos(),
                reserva.getHorarioLimite(),
                reserva.getStatus());
    }

    public Reserva toEntity(ReservaDTO reservaDTO) {
        // Convertendo ReservaDTO para Reserva
        Reserva reserva = new Reserva();
        reserva.setId(reservaDTO.id());
        reserva.setCliente(reservaDTO.cliente());
        reserva.setRestaurante(reservaDTO.restaurante());
        reserva.setMesa(reservaDTO.mesa());
        reserva.setNumPessoas(reservaDTO.numPessoas());
        reserva.setDataReserva(reservaDTO.dataReserva());
        reserva.setDataCriacao(reservaDTO.dataCriacao());
        reserva.setInicioReserva(reservaDTO.inicioReserva());
        reserva.setToleranciaMinutos(reservaDTO.toleranciaMinutos());
        reserva.setHorarioLimite(reservaDTO.horarioLimite());

        return reserva;
    }

    // public List<Reserva> encontrarReservasPorRestauranteEData(Restaurante
    // restaurante, LocalDate data) {
    // return reservaRepository.findByRestauranteIdAndDataReserva(restaurante,
    // data);
    // }

    // Métodos do negócio da classe
    public List<Reserva> encontrarReservasPorRestauranteEData(Restaurante restaurante, LocalDate data)
            throws ResourceNotFoundException {
        List<Reserva> reservas = reservaRepository.findByRestauranteAndDataReserva(restaurante, data);
        if (reservas.isEmpty()) {
            throw new ResourceNotFoundException("Não há reservas cadastradas para o dia " + data
                    + " para o restaurante " + restaurante.getId() + ".");
        }
        return reservas;
    }

    // Métodos do negócio da classe
    public List<Reserva> encontrarReservasPorClienteEData(Cliente cliente, LocalDate data)
            throws ResourceNotFoundException {
        List<Reserva> reservas = reservaRepository.findByClienteAndDataReserva(cliente, data);
        if (reservas.isEmpty()) {
            throw new ResourceNotFoundException("Não há reservas cadastradas para o dia " + data
                    + " para o cliente " + cliente.getId() + ".");
        }
        return reservas;
    }

    // Métodos do negócio da classe
    public List<Reserva> encontrarReservasPorRestauranteEClienteEData(Restaurante restaurante, Cliente cliente, LocalDate data)
            throws ResourceNotFoundException {
        List<Reserva> reservas = reservaRepository.findByClienteAndDataReserva(cliente, data);
        if (reservas.isEmpty()) {
            throw new ResourceNotFoundException("Não há reservas cadastradas para o dia " + data
                    + " para o cliente " + cliente.getId() + ".");
        }
        return reservas;
    }

    public Optional<List<ReservaDTO>> buscarReservaPorRestaurante(long restauranteId) {
        return null;
    }

    public Optional<List<ReservaDTO>> buscarReservaPorCliente(long restauranteId, long clienteId) {
        return null;
    }

    public void cancelarTodasReservasPorRestaurante(long restauranteId) {

    }

    public void cancelarTodasReservaPorRestaurante(long restauranteId, long clienteId) {

    }

    public Optional<List<ReservaDTO>> excluirReservasExpiradas(long restauranteId) {
        return null;
    }

    // lista reservas ativas
    public List<Reserva> reservasAtivas() {

        return null;

    }

    // lista reservas ativas
    public List<Reserva> listaReservasExpiradas() {

        return null;

    }

    // lista reservas ativas
    public List<Reserva> listaReservasPorCliente() {

        return null;

    }
}
