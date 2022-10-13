package com.Prestamos.Reto4.Service;

import com.Prestamos.Reto4.Entities.Message;
import com.Prestamos.Reto4.Repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getAll(){
        return messageRepository.getAll();
    }


    public Optional<Message> getMessage(int id){
        return messageRepository.getMessage(id);
    }

    public Message save(Message message){
        if(message.getIdMessage()==null){
            return messageRepository.save(message);
        }else{
            Optional<Message> paux= messageRepository.getMessage(message.getIdMessage());
            if(paux.isEmpty()){
                return messageRepository.save(message);
            }else{
                return message;
            }
        }
    }
    public Message update(Message message){
        if(message.getIdMessage()!=null){
            Optional<Message>g= messageRepository.getMessage(message.getIdMessage());
            if(!g.isEmpty()){
                if(message.getMessageText()!=null){
                    g.get().setMessageText(message.getMessageText());
                }
                return messageRepository.save(g.get());
            }
        }
        return message;
    }

    public boolean deleteMessage(int id){
        Boolean borrar= getMessage(id).map(message -> {
            messageRepository.delete(message);
            return true;
        }).orElse(false);
        return borrar;
    }

}