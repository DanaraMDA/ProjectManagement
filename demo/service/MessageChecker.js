@Service
public class MessageChecker {

    private volatile Instant lastCheckTime = null;
    private final RestReceiver restReceiver;

    public MessageChecker(RestReceiver restReceiver) {
    this.restReceiver = restReceiver;
}

    @Scheduled(fixedDelay = 3000)
public synchronized void checkMessages() throws IOException {
    lastCheckTime = restReceiver.receiveMessages(lastCheckTime);
}
}
