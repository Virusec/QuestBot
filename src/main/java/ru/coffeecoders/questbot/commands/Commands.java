package ru.coffeecoders.questbot.commands;

import org.springframework.stereotype.Component;

import static ru.coffeecoders.questbot.commands.Commands.Attribute.*;

@Component
public class Commands {
    public enum Command {
        NEWADMIN(ADMIN),
        NEWGAME(ADMIN),
        PLAYING(ADMIN),
        QUESTIONSMENU(ADMIN),
        ADDQUESTION(ADMIN),
        SHOWQUESTIONS(ADMIN),
        MAIN(ADMIN),
        DELETEQUESTION(ADMIN),
        EDITQUESTION(ADMIN),
        ADMINON(GLOBALADMIN),
        START(GLOBALADMIN),
        EDITKEYBOARD (ADMIN),
        STARTGAME (ADMIN),
        STOPTGAME(ADMIN),
        STARTTEAMMAKER(ADMIN),
        SCORE(PLAYER),
        TASKS(PLAYER),
        REGTEAM(PLAYER),
        JOINTEAM(PLAYER);

        private final Attribute attribute;

        Command(Attribute attribute) {
            this.attribute = attribute;
        }

        public Attribute getAttribute() {
            return attribute;
        }
    }

    public enum Attribute {
        GLOBALADMIN,
        ADMIN,
        PLAYER
    }
}
