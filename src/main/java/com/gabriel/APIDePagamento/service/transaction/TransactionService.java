package com.gabriel.APIDePagamento.service.transaction;

import com.gabriel.APIDePagamento.infra.exception.ForbiddenException;
import com.gabriel.APIDePagamento.infra.exception.NotFoundException;
import com.gabriel.APIDePagamento.objectvalue.TypeUserEnum;
import com.gabriel.APIDePagamento.entity.*;
import com.gabriel.APIDePagamento.repository.transaction.ITransactionRepository;
import com.gabriel.APIDePagamento.repository.user.IUserRepository;
import com.gabriel.APIDePagamento.service.notification.INotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService implements ITransactionService {
    private final ITransactionRepository transactionRepository;

    private final IUserRepository userRepository;

    private final INotificationService notificationService;

    public TransactionService(ITransactionRepository transactionRepository, IUserRepository userRepository, INotificationService notificationService) {
        this.transactionRepository = transactionRepository;
        this.userRepository = userRepository;
        this.notificationService = notificationService;
    }

    public String makePayment(TransactionEntity transaction){
        UserEntity senderUser = this.userRepository.getUserById(transaction.getSenderUserId());
        UserEntity receiverUser = this.userRepository.getUserById(transaction.getReceiverUserId());
        if(senderUser == null || receiverUser == null) throw new NotFoundException("Nenhum usuario encontrado");

        if(senderUser.getTypeUser() == TypeUserEnum.Logista) return "Logistas nao podem fazer transacaoes";
        if(senderUser.getUserBalance() < transaction.getTransitionValue()) return "Saldo insuficiente";
        if(receiverUser.getTypeUser() == TypeUserEnum.Bancario) throw new ForbiddenException("bancarios nao podem receber transacoes");

        receiverUser.deposit(transaction.getTransitionValue());
        senderUser.withdraw(transaction.getTransitionValue());
        this.transactionRepository.saveTransaction(transaction);
        this.notificationService.createNotification(transaction);
        return "pagamento feito";
    }

    public List<TransactionEntity> getAllTransaction(int id)
    {
        UserEntity senderUser = this.userRepository.getUserById(id);
        if(senderUser == null) throw new NotFoundException("Nenhum usuario encontrado");
        if(senderUser.getTypeUser() != TypeUserEnum.Bancario) throw new ForbiddenException("Apenas bancarios podem ver todas as transicoes");

        return this.transactionRepository.getAllTransaction();
    }

    public List<TransactionEntity> getTransactionByUserId(int id) {
        return this.transactionRepository.getTransactionByUserId(id);
    }

}
