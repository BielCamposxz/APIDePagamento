package com.gabriel.APIDePagamento.Services.Notificacao;

import com.gabriel.APIDePagamento.Model.NotificationModel;

import java.util.List;

public interface INotificacaoService {
    public void CriarNotificacao();
    public List<NotificationModel> BuscarPorId(int id);
    public int UltimaNotificacao();
    public List<NotificationModel> RetornarAll(int id);
}
