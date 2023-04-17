package ru.coffeecoders.questbot.keyboards;

import com.pengrad.telegrambot.model.request.ReplyKeyboardMarkup;

import java.util.List;

public class JoinTeamKeyboard {

    private final ReplyKeyboardMarkup keyboard;

    private JoinTeamKeyboard(List<String> teamsNames) {
        keyboard = new ReplyKeyboardMarkup(makeButtons(teamsNames))
                .resizeKeyboard(true)
                .oneTimeKeyboard(true)
                .selective(true);
    }

    public static ReplyKeyboardMarkup createKeyboard(List<String> teamsNames) {
        return new JoinTeamKeyboard(teamsNames).keyboard;
    }

    private String[][] makeButtons(List<String> teamsNames) {
        String[][] buttons = new String[teamsNames.size()][1];
        for (int i = 0; i < teamsNames.size(); i++) {
                buttons[i][0] = teamsNames.get(i);
        }
        return buttons;
    }
}