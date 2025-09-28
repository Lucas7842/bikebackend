package org.example.Service;

import java.util.Optional;

public interface IInscrevaseService {
    public Optional<SeguroInscrevaseService> salvar(SeguroInscrevaseService inscrevase);
    public Optional<SeguroInscrevaseService> buscarPorId(Long id);
    public Optional<SeguroInscrevaseService> editarSenha(long id, String password);
    public Optional<SeguroInscrevaseService> deletarCadastro(long id);
    public Optional<SeguroInscrevaseService> buscarTodos();

}
