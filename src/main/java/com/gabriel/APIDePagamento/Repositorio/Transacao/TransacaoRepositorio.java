package com.gabriel.APIDePagamento.Repositorio.Transacao;

import com.gabriel.APIDePagamento.Model.TransacaoModel;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;

@Repository
public class TransacaoRepositorio implements ITransacaoRepositorio {
    List<TransacaoModel> transoes = new LinkedList();

    public void Salvar(TransacaoModel transacao) {
        transoes.add(transacao);
    }

    public List<TransacaoModel> BuscarTodos() {
        return transoes;
    }

}
