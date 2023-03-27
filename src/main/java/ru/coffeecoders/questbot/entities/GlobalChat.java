/**
 * Author: ezuykow
 */

package ru.coffeecoders.questbot.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "global_chats")
public class GlobalChat {

    @Id
    @Column(name = "tg_chat_id")
    private long tgChatId;

    public long getTgChatId() {
        return tgChatId;
    }

    public void setTgChatId(long tgChatId) {
        this.tgChatId = tgChatId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GlobalChat that = (GlobalChat) o;
        return tgChatId == that.tgChatId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(tgChatId);
    }

    @Override
    public String toString() {
        return "GlobalChat{" +
                "tgChatId=" + tgChatId +
                '}';
    }
}
