package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.TimeZone;


public class JarvisHandler extends TelegramLongPollingBot{

    @Autowired
    MessageRepository messageRepository;

    private final String token;

    private  String botName;

    public JarvisHandler(String token) {
        this.token = token;
    }

    @Override
    public void onUpdateReceived(Update update) {
        Message message = new Message();
        message.setUsername(update.getMessage().getFrom().getUserName());
        message.setText(update.getMessage().getText());
        message.setFullMessage(update.toString());
        LocalDateTime triggerTime =
                LocalDateTime.ofInstant(Instant.ofEpochSecond(update.getMessage().getDate()),
                        TimeZone.getDefault().toZoneId());
        message.setDate(triggerTime);

        messageRepository.save(message);
    }

    @Override
    public String getBotUsername() {
//        return botName;
        return "TheMarvelousJarvisBot";
    }


    @Override
    public String getBotToken() {
        return token;
    }
}
