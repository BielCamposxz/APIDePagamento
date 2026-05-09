package com.gabriel.APIDePagamento.Services.Transacao;

import com.gabriel.APIDePagamento.Model.TransacaoModel;
import com.gabriel.APIDePagamento.Model.TransacaoSemTransmiterModel;
import com.gabriel.APIDePagamento.Model.UsuarioModel;

import java.util.List;

public interface ITransacaoService {
    public void Salvar(TransacaoSemTransmiterModel transicao);
    public List<TransacaoModel> RetornarAllTrasition(int id);
    public List<TransacaoModel> RetornarTransitionUser(int id);
    public String FazerPagamento(TransacaoSemTransmiterModel transicao, int id);

}
