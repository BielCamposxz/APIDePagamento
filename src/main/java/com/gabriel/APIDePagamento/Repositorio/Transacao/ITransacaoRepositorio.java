package com.gabriel.APIDePagamento.Repositorio.Transacao;

import com.gabriel.APIDePagamento.Model.TransacaoModel;

import java.util.List;

public interface ITransacaoRepositorio {
    public void Salvar(TransacaoModel transacao);
    public List<TransacaoModel> BuscarTodos();
}
