package br.com.fiap.autospec_api.service;

import br.com.fiap.autospec_api.model.Veiculo;
import br.com.fiap.autospec_api.repository.VeiculoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeiculoService {

    private final VeiculoRepository repository;

    public VeiculoService(VeiculoRepository repository) {
        this.repository = repository;
    }

    public Veiculo salvar(Veiculo veiculo) {

        if (veiculo.getEspecificacoes() != null) {

            veiculo.getEspecificacoes().forEach(especificacao ->
                    especificacao.setVeiculo(veiculo)
            );
        }

        return repository.save(veiculo);
    }

    public List<Veiculo> listarTodos() {
        return repository.findAll();
    }
}