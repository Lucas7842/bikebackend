package org.example.Service;


import lombok.RequiredArgsConstructor;
import org.example.Model.InscrevaseDTO;
import org.example.Model.SeguroIncrevase;
import org.example.Model.InscreaveseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class SeguroInscrevaseService {

    private  final InscreaveseRepository seguroInscreveseRepository;

    public SeguroInscrevaseService(InscreaveseRepository seguroInscreveseRepository) {
        this.seguroInscreveseRepository = seguroInscreveseRepository;
    }
    public SeguroIncrevase salvar(SeguroIncrevase seguroIncrevase) {
        return seguroInscreveseRepository.save(seguroIncrevase);
    }

    public SeguroIncrevase buscarPorId(Long id) {
        return seguroInscreveseRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Cadastro não encontrado")
        );
    }
    public SeguroIncrevase editarSenha(long id, String password) {
        SeguroIncrevase user = buscarPorId(id);
        user.setSenha(password);
        return seguroInscreveseRepository.save(user);
    }

    public SeguroIncrevase deletarCadastro(long id) {
        SeguroIncrevase user = buscarPorId(id);
        seguroInscreveseRepository.delete(user);
        return user;
    }
    public List<SeguroIncrevase> buscarTodos() {
        return seguroInscreveseRepository.findAll();
    }
    public SeguroIncrevase buscarPorEmail(String email) {
        return seguroInscreveseRepository.findByEmail(email);
    }

    public InscrevaseDTO inscrevaseDto(SeguroIncrevase seguroIncrevase){
        return new InscrevaseDTO(
                seguroIncrevase.getNome(),
                seguroIncrevase.getEmail(),
                seguroIncrevase.getSenha()
        );
    }
}
