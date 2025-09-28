package org.example.Service;

import lombok.RequiredArgsConstructor;
import org.example.Model.InscrevaseDTO;
import org.example.Model.SeguroIncrevase;
import org.example.Model.InscrevaseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class SeguroInscrevaseService {

    private final InscrevaseRepository seguroInscrevaseRepository;

    public SeguroIncrevase salvar(SeguroIncrevase seguroIncrevase) {
        return seguroInscrevaseRepository.save(seguroIncrevase);
    }

    public SeguroIncrevase buscarPorId(Long id) {
        return seguroInscrevaseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cadastro não encontrado"));
    }

    public SeguroIncrevase editarSenha(long id, String senha) {
        SeguroIncrevase user = buscarPorId(id);
        user.setSenha(senha);
        return seguroInscrevaseRepository.save(user);
    }

    public SeguroIncrevase deletarCadastro(long id) {
        SeguroIncrevase user = buscarPorId(id);
        seguroInscrevaseRepository.delete(user);
        return user;
    }

    public List<SeguroIncrevase> buscarTodos() {
        return seguroInscrevaseRepository.findAll();
    }

    public SeguroIncrevase buscarPorEmail(String email) {
        return seguroInscrevaseRepository.findByEmail(email);
    }

    public InscrevaseDTO inscrevaseDto(SeguroIncrevase seguroIncrevase){
        return new InscrevaseDTO(
                seguroIncrevase.getNome(),
                seguroIncrevase.getEmail(),
                seguroIncrevase.getSenha()
        );
    }
}
