package com.fiap.ReservasRestaurantes.ReservasRestaurantes.utils;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Copy;

import com.fiap.ReservasRestaurantes.cliente.DTO.ClienteDTO;
import com.fiap.ReservasRestaurantes.cliente.entity.Cliente;
import com.fiap.ReservasRestaurantes.comentario.DTO.ComentarioDTO;
import com.fiap.ReservasRestaurantes.comentario.entity.Comentario;
import com.fiap.ReservasRestaurantes.endereco.DTO.EnderecoDTO;
import com.fiap.ReservasRestaurantes.endereco.entity.Endereco;
import com.fiap.ReservasRestaurantes.horario.entity.Horario;
import com.fiap.ReservasRestaurantes.horario.entity.enumerations.DiaSemanaEnum;
import com.fiap.ReservasRestaurantes.horario.entity.enumerations.TurnoEnum;
import com.fiap.ReservasRestaurantes.mesa.entity.Mesa;
import com.fiap.ReservasRestaurantes.mesa.entity.enumerations.PosicaoMesaEnum;
import com.fiap.ReservasRestaurantes.mesa.entity.enumerations.StatusOcupacaoMesa;
import com.fiap.ReservasRestaurantes.reserva.entity.Reserva;
import com.fiap.ReservasRestaurantes.reserva.entity.enumerations.StatusReservaEnum;
import com.fiap.ReservasRestaurantes.restaurante.entity.Restaurante;
import com.fiap.ReservasRestaurantes.restaurante.entity.enumerations.StatusRestauranteEnum;
import com.fiap.ReservasRestaurantes.restaurante.entity.enumerations.TipoCozinhaEnum;

public class TestHelper {  

    /**
     * Creates and returns a test client with predefined information.
     *
     * @return         the test client created
     */    
    public static Cliente criarClienteTeste() {
        Cliente cliente = new Cliente();
        cliente.setId(0);
        cliente.setNome("João");
        cliente.setEmail("joao@example.com");
        cliente.setDataCadastro(LocalDate.now());
        cliente.setEndereco(new Endereco(0L, 
                        "rua abc",     
                     123,
                     "Centro", 
                     "São Paulo",
                     "SP", 
                       "Brasil", 
                        "00000-000"));
        return cliente;
    }

    public static Cliente criarClienteTeste1() {
        Cliente cliente1 = new Cliente();
        cliente1.setId(1L);
        cliente1.setNome("Paulinho");
        cliente1.setEmail("Paulinho@gmail.com");
        cliente1.setDataCadastro(LocalDate.now());
        cliente1.setEndereco(new Endereco(1L, 
                                      "rua abc1",     
                                   1233,
                                   "Centro1", 
                                   "Caramuru",
                                   "XX", 
                                     "Brasil",
                                      "00000-000"));
        return cliente1;
    }

    public static ClienteDTO clienteDTO(Cliente cliente) {
        return new ClienteDTO(
                cliente.getId(),
                cliente.getNome(),
                cliente.getEmail(),
                cliente.getDataCadastro(),
                cliente.getEndereco());
    }

    
    /**
     * A function to create and return a new Endereco object.
     *
     * @return         	the newly created Endereco object
     */
    public static Endereco criarEnderecoTeste() {
        return new Endereco(0L,
                        "rua abc",     
                     123,
                     "Centro", 
                     "São Paulo",
                     "SP", 
                       "Brasil", 
                        "00000-000");
    }

    /**
     * A function to create and return a new Endereco object.
     *
     * @return         	the newly created Endereco object
     */
    public static Endereco criarEnderecoTeste1() {
        return new Endereco(0L,
                        "rua def",     
                     123,
                     "cidade das flores", 
                     "Osasco",
                     "SP", 
                       "Brasil", 
                        "00000-000");
    }

    /**
     * Creates a new EnderecoDTO object based on the provided Endereco object.
     *
     * @param  endereco  the Endereco object to create the EnderecoDTO from
     * @return           the newly created EnderecoDTO object
     */
    public static EnderecoDTO enderecoDTO(Endereco endereco) {
        return new EnderecoDTO(
                endereco.getId(),
                endereco.getRua(),
                endereco.getNumero(),
                endereco.getBairro(),
                endereco.getCidade(),
                endereco.getEstado(),
                endereco.getPais(),
                endereco.getCep());

    }
    
    /**
     * Cria um horario para os testes.
     *
     * @return  horaRest
     */
    public static Horario criarHorarioTeste() {
        Restaurante restaurante = criarRestauranteTeste();

        Horario horaRest = new Horario(0L,
                                        restaurante,
                                        restaurante.getNome(),
                                        TurnoEnum.ALMOCO,
                                        DiaSemanaEnum.DOMINGO,
                                        LocalDate.now(),
                                        LocalDate.now());
        return horaRest;
    }

    /**
     * Create a test restaurant with empty schedules, reservations, and tables, and a randomly generated address. 
     *
     * @return         	the created restaurant
     */
    public static Restaurante criarRestauranteTeste() {
        List<Horario> horarios = List.of();
        List<Reserva> reservas = List.of();
        List<Mesa> mesas = List.of();
        Endereco endereco = new Endereco(0L, 
                                     "rua abc",     
                                  123,
                                  "Centro", 
                                  "São Paulo",
                                  "SP", 
                                    "Brasil", 
                                     "00000-000");
                                     
        Restaurante restaurante = new Restaurante(0L,
                                                "Dois Irmaos",
                                                endereco,
                                                "doisIrmaos@doisIrmaos.com",
                                                horarios,
                                                reservas,
                                                mesas,
                                                TipoCozinhaEnum.INTERNACIONAL,
                                                10,
                                                StatusRestauranteEnum.ATIVO,
                                                LocalDate.now()); 
                                                    
        return restaurante;
    }

    /**
     * Creates a test reservation.
     *
     * @return         the test reservation
     */
    public static Reserva criarReservaTeste() {
        List<Mesa> mesas = List.of();
        return new Reserva(0L,
                    criarClienteTeste(),
                    criarRestauranteTeste(),
                    mesas,
                    2,
                    LocalDate.now(),
                    LocalDate.now(),
                    LocalDate.now(),
                    10,
                    LocalDate.now(),
                    StatusReservaEnum.ATIVO);
    }

    /**
     * Creates a test Mesa object.
     *
     * @return         the test Mesa object created
     */
    public static Mesa criarMesaTeste() {

        return new Mesa(0L,
                        "1",
                        criarRestauranteTeste(),
                        null,
                        64,
                        StatusOcupacaoMesa.OCUPADA,
                        PosicaoMesaEnum.INTERNA);
    }

    /**
     * A method to create a test comment.
     *
     * @return         	the created test comment
     */
    public static Comentario criarComentarioTeste(){

        Comentario comentario = new Comentario();
        comentario.setId(0L);
        comentario.setCliente(TestHelper.criarClienteTeste());
        comentario.setTitulo("Restaurante Bom");
        comentario.setTexto("Excelente");
        comentario.setAvaliacao(5);
        comentario.setDataCriacao(LocalDate.now());

        return comentario;
    }

    /**
     * A method to create a test comment.
     *
     * @return         	the created test comment
     */
    public static Comentario criarComentarioTeste1(){

        Comentario comentario = new Comentario();
        comentario.setId(1L);
        comentario.setCliente(TestHelper.criarClienteTeste1());
        comentario.setTitulo("Restaurante ruim");
        comentario.setTexto("não servia pao de alho");
        comentario.setAvaliacao(1);
        comentario.setDataCriacao(LocalDate.now());

        return comentario;
    }

    /**
     * Converts a Comentario object to a ComentarioDTO object.
     *
     * @param  comentario   the Comentario object to convert
     * @return              the converted ComentarioDTO object
     */
    public static ComentarioDTO toDTO(Comentario comentario) {
        return new ComentarioDTO(
                comentario.getId(),
                comentario.getCliente(),
                comentario.getTitulo(),
                comentario.getTexto(),
                comentario.getAvaliacao(),
                comentario.getDataCriacao());
    }

    
}
