package br.com.shinigami.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "CLIENTE")
public class Cliente{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CLIENTE_SEQ")
    @SequenceGenerator(name = "CLIENTE_SEQ", sequenceName = "SEQ_CLIENTE", allocationSize = 1)
    @Column(name = "ID_CLIENTE")
    private Integer idCliente;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "CPF")
    private String cpf;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "TELEFONE")
    private String telefone;

    @Column(name = "ATIVO")
    private Tipo ativo;

    @Column(name = "TIPO_CLIENTE")
    private TipoCliente tipoCliente;

    // ver a relação
    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente")
    @JoinColumn(name = "id_imovel", referencedColumnName = "id_imovel")
    private Set<Imovel> imoveis;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "locador")
    private Set<Contrato> contratosLocador;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "locatario")
    private Set<Contrato> contratosLocatario;

}
