package com.gabriel.APIDePagamento.Services.Transacao;

import com.gabriel.APIDePagamento.Model.TransacaoModel;
import com.gabriel.APIDePagamento.Model.TransacaoSemTransmiterModel;
import com.gabriel.APIDePagamento.Model.UsuarioModel;
import com.gabriel.APIDePagamento.Repositorio.Transacao.ITransacaoRepositorio;
import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransacaoService implements ITransacaoService{
    @Autowired
    public ITransacaoRepositorio repositorio;

    public void Salvar(TransacaoSemTransmiterModel transicao) {
        TransacaoModel transacaoInstacia = new TransacaoModel(
                transicao.id,
                transicao.userId,
                transicao.idUserRecived,
                transicao.userId,
                transicao.valor
        );

        repositorio.Salvar(transacaoInstacia);
    }

    public List<TransacaoModel> RetornarAllTrasition() {
        return repositorio.BuscarTodos();
    }

    public List<TransacaoModel> RetornarTransitionUser(int id) {
        List<TransacaoModel> transacao = repositorio.BuscarTodos();
        return transacao.stream().filter(x -> x.userId == id).toList();
    }

}
