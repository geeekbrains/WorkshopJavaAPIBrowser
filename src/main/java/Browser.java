import java.util.*;

public class Browser {
    // Using a LinkedList to keep track of the URL history
    private static LinkedList<String> history = new LinkedList<>();

    // This variable keeps track of the current position in the history
    private static int currentPosition = -1;

    // Using a HashMap to keep count of the number of times each URL was visited
    private static Map<String, Integer> visitCounts = new HashMap<>();

    // Visit a new URL
    public static void visit(String url) {
        // If we have moved back in history, remove all forward history before adding the new url
        if (currentPosition != history.size() - 1) {
            history.subList(currentPosition + 1, history.size()).clear();
        }
        // Add the URL to the end of the history and increment the currentPosition
        history.add(url);
        currentPosition++;

        // Increase the count of the visited url
        visitCounts.put(url, visitCounts.getOrDefault(url, 0) + 1);
    }

    // Go back in history
    public static String back() {
        if (currentPosition > 0) {
            currentPosition--;
        }
        // Return the new current URL
        return history.get(currentPosition);
    }

    // Go forward in history
    public static String forward() {
        if (currentPosition < history.size() - 1) {
            currentPosition++;
        }
        // Return the new current URL
        return history.get(currentPosition);
    }

    // Get the current URL
    public static String current() {
        return history.get(currentPosition);
    }

    // List all visited URLs
    public static List<String> listAllVisited() {
        return new ArrayList<>(history);
    }

    // Get the visit count for a specific URL
    public static int countVisits(String url) {
        return visitCounts.getOrDefault(url, 0);
    }

    public static void reset() {
        history = new LinkedList<>();
        currentPosition = -1;
        visitCounts = new HashMap<>();
    }

    public static void main(String[] args) {
        visit("gb.ru");
        visit("google.ru");
        System.out.println(current()); // google.ru
        System.out.println(back());    // gb.ru
        System.out.println(forward()); // google.ru
        visit("google.ru");
        visit("vk.com");
        System.out.println(listAllVisited()); // [gb.ru, google.ru, google.ru, vk.com]
        System.out.println(countVisits("google.ru")); // 2
        reset();
        System.out.println(listAllVisited()); // []
    }
}
