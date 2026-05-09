package com.gabriel.APIDePagamento.Repositorio.Transacao;

import com.gabriel.APIDePagamento.Model.TransacaoModel;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ITransacaoRepositorio {
    public void Salvar(TransacaoModel transacao);
    public List<TransacaoModel> BuscarTodos();
}
