package org.example.Service;


import lombok.RequiredArgsConstructor;
import org.example.Model.SeguroIncrevase;
import org.example.Model.SeguroInscreaveseRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SeguroInscrevaseService {

    private  final SeguroInscreaveseRepository seguroInscreveseRepository;

    public SeguroInscrevaseService(SeguroInscreaveseRepository seguroInscreveseRepository) {
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
}
