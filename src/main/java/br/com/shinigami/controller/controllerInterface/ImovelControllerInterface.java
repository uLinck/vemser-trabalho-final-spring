package br.com.shinigami.controller.controllerInterface;

import br.com.shinigami.dto.imovel.ImovelCreateDTO;
import br.com.shinigami.dto.imovel.ImovelDTO;
import br.com.shinigami.exceptions.RegraDeNegocioException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

public interface ImovelControllerInterface {
//    @Operation(summary = "listar imoveis", description = "Listar todos os imoveis do banco de dados")
//    @ApiResponses(
//            value = {
//                    @ApiResponse(responseCode = "200", description = "Retorna a lista de imoveis"),
//                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
//                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
//            }
//    )
//    ResponseEntity<List<ImovelDTO>> list(@RequestParam("page") Integer page) throws RegraDeNegocioException;

    @Operation(summary = "Buscar imovel", description = "Busca o imovel pelo id do banco de dados")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna o contrato"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    ResponseEntity<ImovelDTO> findById(@PathVariable("idImovel") Integer idImovel) throws RegraDeNegocioException;

    @Operation(summary = "listar imoveis disponiveis", description = "Listar todos os imoveis disponiveis para aluguel do banco de dados")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna a lista de imoveis disponiveis para aluguel"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    public ResponseEntity<List<ImovelDTO>> findByDisponiveis() throws RegraDeNegocioException;

    @Operation(summary = "Criar imovel", description = "Cria o imovel no banco de dados")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Imovel criado com Sucesso."),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    ResponseEntity<ImovelDTO> create(@RequestBody @Valid ImovelCreateDTO imovel) throws RegraDeNegocioException;

    @Operation(summary = "Atualizar imovel", description = "Atualiza o imovel do banco de dados com base no id e o body informado")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Imovel atualizado com sucesso."),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    ResponseEntity<ImovelDTO> update(@PathVariable("idImovel") Integer idImovel,
                                     @RequestBody @Valid ImovelCreateDTO imovelCreate) throws RegraDeNegocioException;

    @Operation(summary = "Deletar imovel", description = "Deleta o imovel do banco de dados")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Imovel deletado!"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    ResponseEntity<Void> delete(@PathVariable("idImovel") Integer idImovel) throws RegraDeNegocioException;
}
