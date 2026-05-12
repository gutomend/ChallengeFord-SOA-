package br.com.fiap.autospec_api.controller;

import br.com.fiap.autospec_api.dto.VeiculoDTO;
import br.com.fiap.autospec_api.dto.EspecificacaoDTO;
import br.com.fiap.autospec_api.model.Especificacao;
import br.com.fiap.autospec_api.model.Veiculo;
import br.com.fiap.autospec_api.service.VeiculoService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/veiculos")
public class VeiculoController {

    private final VeiculoService service;

    public VeiculoController(VeiculoService service) {
        this.service = service;
    }

    @Operation(summary = "Cadastrar veículo com especificações")
    @PostMapping
    public Veiculo criar(@RequestBody @Valid VeiculoDTO dto) {

        Veiculo veiculo = new Veiculo();

        veiculo.setMarca(dto.getMarca());
        veiculo.setModelo(dto.getModelo());
        veiculo.setVersao(dto.getVersao());

        if (dto.getEspecificacoes() != null) {

            List<Especificacao> especificacoes =
                    dto.getEspecificacoes()
                            .stream()
                            .map(this::converterEspecificacao)
                            .toList();

            veiculo.setEspecificacoes(especificacoes);
        }

        return service.salvar(veiculo);
    }

    @Operation(summary = "Listar veículos")
    @GetMapping
    public List<Veiculo> listarTodos() {
        return service.listarTodos();
    }

    private Especificacao converterEspecificacao(
            EspecificacaoDTO dto) {

        Especificacao especificacao = new Especificacao();

        especificacao.setAtributo(dto.getAtributo());
        especificacao.setValor(dto.getValor());

        return especificacao;
    }
}