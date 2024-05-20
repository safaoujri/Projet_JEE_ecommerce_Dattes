package org.xproce.datte.service;

import org.springframework.stereotype.Component;
import org.xproce.datte.dao.entities.Command;

import java.util.List;

@Component
public interface CommandManager {
    void ajouterCommand(Command commande);

    Command getCommandeById(Integer commandeId);

    List<Command> getAllCommandes();
}
