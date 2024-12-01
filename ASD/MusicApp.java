import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

class Queue {
    private LinkedList<String> tracks;
    private int currIdx;

    public Queue() {
        tracks = new LinkedList<>();
        currIdx = -1;
    }

    public void addTrack(String track) {
        tracks.add(track);
    }

    public void moveTrack(int from, int to) {
        int total = tracks.size();
        if (total == 0) return;

        from = ((from % total) + total) % total;
        to = ((to % total) + total) % total;

        if (from >= 0 && from < total && to >= 0 && to < total) {
            String track = tracks.remove(from);
            tracks.add(to, track);

            if (from == currIdx) {
                currIdx = to;
            } else if (from < currIdx && to >= currIdx) {
                currIdx--;
            } else if (from > currIdx && to <= currIdx) {
                currIdx++;
            }
        }
    }
    public void removeTrack(int idx) {
        int total = tracks.size();
        if (total == 0) return;

        idx = ((idx % total) + total) % total;

        if (idx >= 0 && idx < total) {
            tracks.remove(idx);

            if (tracks.isEmpty()) {
                currIdx = -1;
            } else {
                if (idx < currIdx) {
                    currIdx--;
                } else if (idx == currIdx) {
                    if (currIdx >= tracks.size()) {
                        currIdx = (currIdx - 1 + tracks.size()) % tracks.size();
                    }
                }
            }
        }
    }

    public void playAt(int idx, String queueName) {
        if (!tracks.isEmpty()) {
            int total = tracks.size();
            currIdx = ((idx % total) + total) % total;
            System.out.println("Playlist " + queueName + " sedang diputar: " + tracks.get(currIdx));
        }
    }

    public void nextTrack(String queueName) {
        if (!tracks.isEmpty()) {
            if (currIdx == -1) {
                currIdx = 0;
            } else {
                currIdx = (currIdx + 1) % tracks.size();
            }
            System.out.println("Playlist " + queueName + " sedang diputar: " + tracks.get(currIdx));
        }
    }

    public void prevTrack(String queueName) {
        if (!tracks.isEmpty()) {
            if (currIdx == -1) {
                currIdx = tracks.size() - 1;
            } else {
                currIdx = (currIdx - 1 + tracks.size()) % tracks.size();
            }
            System.out.println("Playlist " + queueName + " sedang diputar: " + tracks.get(currIdx));
        }
    }

    public boolean hasTracks() {
        return !tracks.isEmpty();
    }

    public String getCurrentTrack() {
        if (currIdx >= 0 && currIdx < tracks.size()) {
            return tracks.get(currIdx);
        }
        return "";
    }
}

public class MusicApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Queue> queues = new HashMap<>();

        while (true) {
            String input = scanner.nextLine();
            String[] cmd = input.split(" ");

            if (cmd[0].equals("EXIT")) {
                break;
            } else if (cmd[0].equals("INSERT")) {
                String name = cmd[1];
                Queue queue = queues.getOrDefault(name, new Queue());

                if (cmd.length == 2) {
                    queues.put(name, queue);
                } else if (cmd.length == 3) {
                    queue.addTrack(cmd[2]);
                    queues.put(name, queue);
                }
            } else if (cmd[0].equals("MOVE")) {
                String name = cmd[1];
                Queue queue = queues.get(name);
                if (queue != null && queue.hasTracks()) {
                    int fromIdx = Integer.parseInt(cmd[2]);
                    int toIdx = Integer.parseInt(cmd[3]);

                    queue.moveTrack(fromIdx, toIdx);
                }
            } else if (cmd[0].equals("REMOVE")) {
                String name = cmd[1];
                Queue queue = queues.get(name);
                if (queue != null && queue.hasTracks()) {
                    int idx = Integer.parseInt(cmd[2]);

                    queue.removeTrack(idx);
                }
            } else if (cmd[0].equals("PLAYAT")) {
                String name = cmd[1];
                Queue queue = queues.get(name);
                if (queue != null && queue.hasTracks()) {
                    int idx = Integer.parseInt(cmd[2]);

                    queue.playAt(idx, name);
                }
            } else if (cmd[0].equals("NEXT")) {
                String name = cmd[1];
                Queue queue = queues.get(name);
                if (queue != null && queue.hasTracks()) {
                    queue.nextTrack(name);
                }
            } else if (cmd[0].equals("PREV")) {
                String name = cmd[1];
                Queue queue = queues.get(name);
                if (queue != null && queue.hasTracks()) {
                    queue.prevTrack(name);
                }
            }
        }
        scanner.close();
    }
}
