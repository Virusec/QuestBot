package ru.coffeecoders.questbot.managers.commands;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.coffeecoders.questbot.actions.commands.PlayersCommandsActions;
import ru.coffeecoders.questbot.models.ExtendedUpdate;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PlayersCommandsManagerTest {
    @Mock
    private PlayersCommandsActions playersCommandsActions;
    @Mock
    private ExtendedUpdate exUpdate;
    @InjectMocks
    private PlayersCommandsManager playersCommandsManager;

    @Test
    void manageCommandScoreTest() {
        when(exUpdate.getMessageChatId()).thenReturn(1L);
        playersCommandsManager.manageCommand(exUpdate, Command.INFO);
        Mockito.verify(playersCommandsActions).showInfo(exUpdate.getMessageChatId());
    }

    @Test
    void manageCommandRegTeamTest() {
        playersCommandsManager.manageCommand(exUpdate, Command.REGTEAM);
        Mockito.verify(playersCommandsActions).regTeam(exUpdate);
    }
  @Test
    void manageCommandJoinTeamTest() {
        playersCommandsManager.manageCommand(exUpdate, Command.JOINTEAM);
        Mockito.verify(playersCommandsActions).joinTeam(exUpdate);
    }

}